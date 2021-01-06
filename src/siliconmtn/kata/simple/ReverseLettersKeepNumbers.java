package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: MissingNumber.java 
 * <b>Project</b>: _Sandbox 
 * <b>Description: </b> Create a method that reverses letters in a string but 
 * keeps digits in their current order.
 * <b>Copyright:</b> Copyright (c) 2020 
 * <b>Company:</b> SiliconMountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Dec 21, 2020
 * @updates:
 ****************************************************************************/
public class ReverseLettersKeepNumbers {

	public static void main(String[] args) {
		System.out.println(reverse("ab89c".toCharArray())) ; // "cb89a"
		System.out.println(reverse("jkl5mn923o".toCharArray())) ; // "onm5lk923j"
		System.out.println(reverse("123a45".toCharArray())) ; // "123a45"
	}

	/**
	 * Reverses a string keeping the numbers in place
	 * @param cWord
	 * @return
	 */
	public static String reverse(char[] cWord) {
		String[] newWord = new String[cWord.length];
		
		// Loop forward and assign the numbers
		for (int i = 0; i < cWord.length; i++) {
			if (Character.getNumericValue(cWord[i]) < 10) newWord[i] = cWord[i] + "";
		}
		
		// Loop backwards and grab each letter and insert
		for (int i = cWord.length - 1; i > -1; i--) {
			if (Character.getNumericValue(cWord[i]) > 9) insertChar(cWord[i], newWord);
		}

		return String.join("", newWord);
	}
	
	/**
	 * Inserts a char into the first available slot
	 * @param c
	 * @param newWord
	 */
	public static void insertChar(char c, String[] newWord) {
		for (int i=0; i < newWord.length; i++) {
			if (newWord[i] == null) {
				newWord[i] = c + "";
				break;
			}
		}
	}
}