package siliconmtn.kata.simple;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: PrimeNumber.java
 * <b>Project</b>: _Sandbox
 * <b>Description: </b> Create a program to print all of the prime numbers 
 * between 1 and 100.  Do not use any Math class functions.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class PrimeNumber {
	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.print(getPrimes(1000));
	}

	/**
	 * Loop and divide by numbers from 2 to 9.  Check for modulus against the number
	 * @param val - top end number to find primes (100 lists all primes from 0 - 100)
	 * @return
	 */
	public static String getPrimes(int val) {
		List<Integer> primes = new ArrayList<>();
		
		for(int number = 2; number<=val; number++){
			boolean isPrime = true;
			for (int i = 2; i < 10; i++) {
				if (i == number) continue;
				if (number % i == 0) {
					isPrime = false;
				}
			}
			
			if(isPrime) primes.add(number);
		}
		
		return primes.toString();
	}

}
