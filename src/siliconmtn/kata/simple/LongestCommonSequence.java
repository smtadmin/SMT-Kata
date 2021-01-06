package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequence.java
 * <b>Project</b>: _Sandbox
 * <b>Description: </b> Given two strings, write a method that finds the longest common sub-sequence.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class LongestCommonSequence {

	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String[] args) {
		String one = "Over hill over dale";
		String two = "James is old and over the hill";
		System.out.println(findLongestCommonSequence(one, two));
	}

	/**
	 * Finds the sequence
	 * @param s1 First String to compare
	 * @param s2 Second String to compare
	 * @return
	 */
	public static String findLongestCommonSequence(String s1, String s2) {
		String result = "";
		for (int length = s1.length(); length > 0; length--) {
			int startIndex = 0;
			while (startIndex + length <= s1.length()) {
				String current = s1.substring(startIndex, startIndex + length);
				if (s2.contains(current)) {
					result = current;
					break;
				}
				startIndex++;
			}
			if (result.length() != 0) {
				break;
			}
		}
		return result;
	}

}
