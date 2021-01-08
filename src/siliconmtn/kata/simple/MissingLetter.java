package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: MissingLetter.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Create a method that takes an array of increasing letters 
 * and return the missing letter.  Tests will always have exactly one letter missing.
 * The length of the test array will always be at least two.
 * Tests will be in one particular case (upper or lower but never both).
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class MissingLetter {

	/**
	 * 
	 */
	public MissingLetter() {
		super();
	}

	/**
	 * Creates a set of conditions to check and calls the missing letter method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(missingLetter(new String[] { "a", "b", "c", "e", "f", "g" })); // "d"
		System.out.println(missingLetter(new String[] { "O", "Q", "R", "S" })); // "P"
		System.out.println(missingLetter(new String[] { "t", "u", "v", "w", "x", "z" })); // "y"
		System.out.println(missingLetter(new String[] { "m", "o" })); // "n"
	}
	
	/**
	 * loops through the String[] and checks the current item to the previous
	 * @param chars
	 * @return
	 */
	public static char missingLetter(String[] chars) {

		for (int i = 0; i < chars.length; ++i) {
			if (chars[i + 1].charAt(0) - chars[i].charAt(0) != 1) {
				return (char) (chars[i].toCharArray()[0] + 1);
			}
		}
		
		return '*';
	}

}
