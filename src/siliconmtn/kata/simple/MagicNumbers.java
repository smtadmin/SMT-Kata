package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: Palindrome.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> You are given the digits 1,2,3,4,5,6,7,8,9. You may add '+' and '-' operations 
 * in between any of the digits. You may also join digits together to form a bigger number. 
 * The digits must stay in the original order however. Your aim is to do this in such a way 
 * that the result of the equation is a number that the user provides. Create a program which 
 * will ask the user for a number then find every possible solution. 
 * Here is an example that results in 50:
 * 1 - 2 + 34 + 5 + 6 + 7 + 8 - 9 = 50
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class MagicNumbers {
	
	private static int[] elements = new int[] { 1,2,3,4,5,6,7,8,9 };

	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]){      
	    System.out.println("Magic Sequence: " + performMagicMath(50));
	}

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	private static String performMagicMath(int startNumber) {
		int total = 0;
		for (int ele : elements) {
			total += ele;
		}

		System.out.println(total);
		return "";
	}

}
