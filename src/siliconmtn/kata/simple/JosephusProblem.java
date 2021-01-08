package siliconmtn.kata.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: JosephusProblem.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class JosephusProblem {

	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]){
		System.out.println("Last Soldier: " + josephus(2,2)); // 1
		System.out.println("Last Soldier: " + josephus(35, 11)); // 18
		System.out.println("Last Soldier: " + josephus(11, 1));
	}

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	private static int josephus(int numberSoldiers, int interval){
		// Fill out the array
		Map<Integer, Boolean> soldiers = new LinkedHashMap<>();
		for (int i=1; i <= numberSoldiers; i++) { soldiers.put(i, false); }
		
		int ctr = interval;
		int i = 0;
		while(true) {
			//System.out.println("Ctr: " + ctr + "|" + soldiers);
			
			soldiers.put(ctr, true);
			if (oneLeft(soldiers)) break;
			
			ctr += interval;
			if (ctr > numberSoldiers) ctr = (interval - (numberSoldiers - ctr));
			
			i++;
		}
		
		return getLast(soldiers);
	}
	
	private static int getLast(Map<Integer, Boolean> soldiers) {
		for (Entry<Integer, Boolean> e : soldiers.entrySet()) {
			if (! e.getValue()) return e.getKey();
		}
		
		return 0;
	}
	
	private static boolean oneLeft(Map<Integer, Boolean> soldiers) {
		int ctr = 0;
		for (Entry<Integer, Boolean> e : soldiers.entrySet()) {
			if (! e.getValue()) ctr++;
			if (ctr > 1) break;
		}
		
		return ctr == 1;
	}

}
