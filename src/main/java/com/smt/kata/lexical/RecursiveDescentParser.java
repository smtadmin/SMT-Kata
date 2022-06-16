package com.smt.kata.lexical;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.siliconmtn.data.text.StringUtil;

/**
 * A Recursive Descent parser is a means of processing a lexicon (language + grammar) in a left to right format without backtracking and evaluate it for syntactical correctness.
 * This is how something like the JVM parses source code to confirm that your class is correct.
 * 
 * In this example we'll work with a fully Parenthesized notation to denote order of operation and precedence.  This can be defined using BNF Notation (Backus-Naur Form) using the pattern
 * 
 * <expression>  ::=  <number>  | "(" <expression> <operator> <expression> ")"
 * <operator>  ::=  "+" | "-" | "*" | "/"
 * 
 * The idea of BNF is to describe a lexicon from the highest level all the way down to component parts so that at any point, the available elements are defined and validation can be checked.
 * In the above example, an <expression> is the highest level element which can consist of either a number or a ( <expression> <operator> <expression> ) with <operator> consisting of the characters [+*-/]
 * 
 * This allows for the Recursive part of the Parser to know exactly how to branch logically and convert a String into proper tree.
 * 
 * As the Recursive portion executes, it can determine validity at runtime and throws a ParseException to denote any problems.
 * 
 * @author raptor
 *
 */
public class RecursiveDescentParser {

	public static final String NOT_EMPTY_EXCEPTION = "Expression cannot be empty";
	public static final String INVALID_CHAR_EXCEPTION = "Invalid characters detected in expression";
	public static final String LEFT_UNBALANCED_EXCEPTION = "Left Hand side unbalanced.";
	public static final String RIGHT_UNBALANCED_EXCEPTION = "Evaluation doesn't match right hand side.";
	public static final String INVALID_EXPRESSION_EXCEPTION = "Invalid character encountered when evaluating expression";
	public static final String MISSING_CLOSE_PAREN_EXCEPTION = "Missing Closing Parenthesis in parser.";
	public static final String INVALID_OP_EXCEPTION = "Invalid Operator.";
	public static final String INVALID_INT_EXCEPTION = "Invalid Integer";
	public static final String MISSING_OP_EXCEPTION = "Missing Operator";
	
	public int lex(String expression) throws ParseException {

		if(StringUtil.isEmpty(expression)) {
			throw new ParseException(NOT_EMPTY_EXCEPTION);
		} else if(expression.matches(".*[^\\d\\s=_+\\-()*/].*")) {
			throw new ParseException(INVALID_CHAR_EXCEPTION);
		}

		try(Scanner s = new Scanner(Arrays.stream(StringUtil.defaultString(expression).split("")).filter(str -> !StringUtil.isEmpty(str)).collect(Collectors.joining()))) {
			s.useDelimiter("");
			int leftEval = evaluateExpression(s);
			if(s.hasNext() && s.next().equals("=")) {
				if(getInt(s) == leftEval) {
					return leftEval;
				} else {
					throw new ParseException(RIGHT_UNBALANCED_EXCEPTION);
				}
			} else {
				throw new ParseException(LEFT_UNBALANCED_EXCEPTION);
			}
		}
	}

	private int evaluateExpression(Scanner s) throws ParseException {
		while(s.hasNext()) {
			if(s.hasNextInt()) {
				return getInt(s);
			} else if(s.hasNext()){
				if(s.next().equals("(")) {
					return parseNestedExpression(s);
				} else {
					throw new ParseException(INVALID_EXPRESSION_EXCEPTION);	
				}
			}
		}
		return 0;
	}

	private int parseNestedExpression(Scanner s) throws ParseException {
		int left = evaluateExpression(s);
		char op = getOperator(s);
		int right = evaluateExpression(s);
		if(!s.hasNext() || !s.next().equals(")")) {
			throw new ParseException(MISSING_CLOSE_PAREN_EXCEPTION);
		}
		return evaluateTuple(left, op, right);
		
	}

	private int evaluateTuple(int left, char op, int right) throws ParseException {
		switch(op) {
			case '+': return left + right;
			case '-': return left - right;
			case '*': return left * right;
			case '/': return left / right;
			default:
				throw new ParseException(INVALID_OP_EXCEPTION);
		}
	}

	private int getInt(Scanner s) throws ParseException {
		if(s.hasNextInt()) {
			int res = s.nextInt();
			while(s.hasNextInt()) {
				res = (res * 10) + s.nextInt();
			}
			return res;
		} else {
			throw new ParseException(INVALID_INT_EXCEPTION);
		}
	}

	private char getOperator(Scanner s) throws ParseException {
		 if(s.hasNext()) {
			 return s.next().charAt(0);
		 } else {
			 throw new ParseException(MISSING_OP_EXCEPTION);
		 }
	}	
}
