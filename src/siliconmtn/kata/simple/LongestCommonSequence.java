package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequence.java
 * <b>Project</b>: _Sandbox
 * <b>Description: </b> Given two strings, write a method that finds the longest 
 * common sub-sequence.  No COLLECTIONS or other libraries are needed
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
		
		one = "a long time ago in a galaxy far far away";
		two = "there is going to be a time at the movie";
		System.out.println(findLongestCommonSequence(one, two));
		
		one = "the denver broncos really suck this year";
		two = "the year 20220 has been really crappy";
		System.out.println(findLongestCommonSequence(one, two));
		
		one = "cookies are realy yummy, especially chocolate chips";
		two = "browser can track usage through the use of cookies";
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
