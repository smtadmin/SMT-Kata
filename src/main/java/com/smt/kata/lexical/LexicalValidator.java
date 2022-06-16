package com.smt.kata.lexical;

import com.siliconmtn.data.text.StringUtil;

/**
 * Part one of a series designed to help design a lexical Analyzer, this Kata focuses on performing string validation before any analysis occurs.
 * 
 * The goal is to write a regex
 * @author raptor
 *
 */
public class LexicalValidator {

	/**
	 * Validate that a given equation is of proper structure and evaluates to correct answer.
	 * @param equation
	 * @return
	 */
	public boolean validate(String equation) {
		return isValid(StringUtil.defaultString(equation));
	}
	
	/**
	 * Validate that the Equation has proper structure.
	 * @param equation
	 * @return
	 */
	private boolean isValid(String equation) {
		return equation.matches("[\\s]*(\\d+[\\s]*[\\+\\-][\\s]*)*(\\d+)[\\s]*=[\\s]*(\\d+)[\\s]*");
	}
}
