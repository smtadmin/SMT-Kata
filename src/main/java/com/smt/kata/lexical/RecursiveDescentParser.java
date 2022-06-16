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
 * As the Recursive portion executes, it can determine validity at runtime and throws a ParseException to denote any problems by parsing through the given expression and recursively applying the BNF lexicon.
 * 
 * @author raptor
 *
 */
public class RecursiveDescentParser {

	/**
	 * ParseException message for when an expression is empty
	 */
	public static final String NOT_EMPTY_EXCEPTION = "Expression cannot be empty";
	
	/**
	 * ParseException message for when the expression contains invalid characters.
	 */
	public static final String INVALID_CHAR_EXCEPTION = "Invalid characters detected in expression";

	/**
	 * ParseException message for when the left hand side of the equation is unbalanced
	 */
	public static final String LEFT_UNBALANCED_EXCEPTION = "Left Hand side unbalanced.";

	/**
	 * ParseException message for when the right hand side of the equation doesn't match the left side evaluation.
	 */
	public static final String RIGHT_UNBALANCED_EXCEPTION = "Evaluation doesn't match right hand side.";

	/**
	 * ParseException message for when the left hand side encounters an invalid character in the <Expression>
	 */
	public static final String INVALID_EXPRESSION_EXCEPTION = "Invalid character encountered when evaluating expression";

	/**
	 * ParseException message for when an Expression is missing a close parenthesis
	 */
	public static final String MISSING_CLOSE_PAREN_EXCEPTION = "Missing Closing Parenthesis in parser.";

	/**
	 * ParseException message for when an Invalid Operator is encountered.
	 * For the sake of testing, I've allowed the _ character through in the regex for testing.
	 */
	public static final String INVALID_OP_EXCEPTION = "Invalid Operator.";

	/**
	 * ParseException message for when a number is expected and fails to parse.
	 */
	public static final String INVALID_INT_EXCEPTION = "Invalid Integer";

	/**
	 * ParseException message for when an operator is expected and fails to parse.
	 */
	public static final String MISSING_OP_EXCEPTION = "Missing Operator";

	/**
	 * Regex Pattern for validating a given expression.
	 */
	public static final String EXPRESSION_PATTERN = ".*[^\\d\\s=_+\\-()*/].*";

	/**
	 * Perform the Lexical Analysis of the given Expression.
	 * @param expression
	 * @return the value of the evaluated expression.
	 * @throws ParseException in the event that the expression can't be lexed.
	 */
	public int lex(String expression) throws ParseException {

		if(StringUtil.isEmpty(expression)) {
			throw new ParseException(NOT_EMPTY_EXCEPTION);
		} else if(expression.matches(EXPRESSION_PATTERN)) {
			throw new ParseException(INVALID_CHAR_EXCEPTION);
		}

		try(Scanner s = scanExpression(expression)) {
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

	/**
	 * Helper method that consumes an expression, sanitizes/strips it and returns it as a Scanner.
	 * @param expression
	 * @return
	 */
	private Scanner scanExpression(String expression) {
		return new Scanner(Arrays.stream(StringUtil.defaultString(expression).split("")).filter(str -> !StringUtil.isEmpty(str)).collect(Collectors.joining()));
	}

	/**
	 * Helper method for parsing an Expression contained in the given Scanner.
	 * @param s 
	 * @return
	 * @throws ParseException
	 */
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

	/**
	 * Helper method to evaluated a parenthetized expression of (digit <Operator> digit)
	 * @param s
	 * @return
	 * @throws ParseException Thrown when close paren is missing. 
	 */
	private int parseNestedExpression(Scanner s) throws ParseException {
		int left = evaluateExpression(s);
		char op = getOperator(s);
		int right = evaluateExpression(s);
		if(!s.hasNext() || !s.next().equals(")")) {
			throw new ParseException(MISSING_CLOSE_PAREN_EXCEPTION);
		}
		return evaluateTuple(left, op, right);
		
	}

	/**
	 * Helper method to evaluate a tuple consisting of left digit, operator and right digit.
	 * @param left
	 * @param op
	 * @param right
	 * @return
	 * @throws ParseException Thrown when an invalid operand is encountered.
	 */
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

	/**
	 * Helper method to retrieve an int.
	 * @param s
	 * @return
	 * @throws ParseException Thrown when an Int is expected in scanner but not encountered.
	 */
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

	/**
	 * Helper method to retrieve the Expression Operator
	 * @param s
	 * @return
	 * @throws ParseException Thrown when an Operator is missing.
	 */
	private char getOperator(Scanner s) throws ParseException {
		 if(s.hasNext()) {
			 return s.next().charAt(0);
		 } else {
			 throw new ParseException(MISSING_OP_EXCEPTION);
		 }
	}	
}
