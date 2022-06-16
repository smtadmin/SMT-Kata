package com.smt.kata.lexical;

import java.util.ArrayList;
import java.util.List;

import com.siliconmtn.data.text.StringUtil;

/**
 * Write a method that takes in a math equation and validates that it's correct.
 * 
 * A simple equation consists of addition and subtraction operations and all positive numbers followed by an = sign and the proper solution.
 * 
 * Example of invalid are as follows.
 * 
 * 1
 * 1 + a
 * 1 + 1 = 3
 * 1 * 5 = 5
 * 
 * Example of valid are as follows.
 * 1 + 1 = 2
 * 1 + 2 + 3 - 6 = 0
 *    1+    2 +3-    6 = 0        
 * 
 * @author raptor
 *
 */
public class SimpleSolver {

	/**
	 * Validate that a given equation is of proper structure and evaluates to correct answer.
	 * @param equation
	 * @return
	 */
	public boolean validate(String equation) {
		boolean valid = false;
		
		if(!StringUtil.isEmpty(equation) && isValid(equation)) {
			List<String> parts = parseEquation(equation);
			int solution = Integer.parseInt(parts.get(parts.size() - 1));
			int eqnSol = Integer.parseInt(parts.get(0));
			for(int i = 1; i < parts.size(); i++) {
				if(parts.get(i).equals("+")) {
					eqnSol += Integer.parseInt(parts.get(i + 1));
				} else if(parts.get(i).equals("-")) {
					eqnSol -= Integer.parseInt(parts.get(i + 1));
				}
			}
			valid = eqnSol == solution;
		}
		return valid;
	}

	/**
	 * Parse the Equation into pieces.
	 * @param equation
	 * @return
	 */
	private List<String> parseEquation(String equation) {
		List<String> parts = new ArrayList<>();
		StringBuilder part = new StringBuilder();

		for(char c : equation.toCharArray()) {
			if(Character.isDigit(c)) {
				part.append(c);
			} else if(!StringUtil.isEmpty(part)) {
				parts.add(part.toString());
				part = new StringBuilder();
			}
			
			if(c == '+' || c == '-' || c == '=') {
				parts.add(Character.toString(c));
			}
		}
		if(part.length() > 0) {
			parts.add(part.toString());
		}
		
		return parts;
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
