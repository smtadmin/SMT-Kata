package com.smt.kata.math;

// JDK 11.x
import java.util.LinkedHashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> PurchaseChange.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Purchase Change
 * 
 * Correctly determine the fewest number of coins/bills to be given to a customer such 
 * that the sum of the coins' value would equal the correct amount of change.
 * 
 * For example
 * 
 * A price of .10 and a .25 paid should return one nickel (5) and one 
 * dime (10) or {DIME=1, NICKEL=1}
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 2, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class PurchaseChange {
	
	/**
	 * Currency enum to track money types
	 */
	public enum Currency {
		TWENTY_DOLLAR(2000), TEN_DOLLAR(1000), FIVE_DOLLAR(500), DOLLAR(100), QUARTER(25), DIME(10), NICKEL(5), PENNY(1);
		
		private int value;
		public int getCurrencyValue() { return value; }
		Currency(int value) {
			this.value = value;
		}
	}
	
	/**
	 * Calculates the change
	 * @param purchaseAmount The amount of the purchase
	 * @param moneyPaid The amount given to pay for the purchase
	 * @return Map with currencies and amounts
	 */
	public Map<Currency, Integer> calculate(double purchaseAmount, double moneyPaid) {
		// Create a map to hold the change
		Map<Currency, Integer> change = new LinkedHashMap<>();
		
		// Get the total change in pennies
		int totalChange = (int)((moneyPaid - purchaseAmount) * 100);
		
		// Make sure the money given is greater than the purchase amount
		if (totalChange < 1) return change;
		
		// Loop the currencies and calculate the change for each
		for (Currency item : Currency.values()) {
			int value = item.getCurrencyValue();
			if (value > totalChange) continue;
			
			change.put(item, (totalChange / value));
			totalChange = totalChange % value;
		}
		
		return change;
	}
}
