package com.smt.kata.math;

// JDK 11.x
import java.util.logging.Logger;
import java.util.logging.Level;

// Spacelibs 1.x
import com.siliconmtn.data.format.RandomUtil;

// Kata Lib
import com.smt.kata.math.ProbabilityVO.RollType;

/****************************************************************************
 * <b>Title</b>: ProbabilityStudentClub.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Probability Student Club
 * Alice wants to join her school's Probability Student Club. Membership dues are 
 * computed via one of two simple probabilistic games.
 * 
 * The first game: roll a die repeatedly. Stop rolling once you get a five followed 
 * by a six. Your number of rolls is the amount you pay, in dollars.
 * 
 * The second game: same, except that the stopping condition is a five followed by a five.
 * 
 * Which of the two games should Alice elect to play? Does it even matter? 
 * Write a program to simulate the two games and calculate their expected value.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 20, 2021
 * @updates:
 ****************************************************************************/
public class ProbabilityStudentClub {
	
	// Members
	Logger logger = Logger.getLogger(ProbabilityStudentClub.class.getName());
	int countFirst;
	int countSecond;
	
	/**
	 * Constructor to calculate each item over the number of supplied iterations
	 * @param first First Probability values to run
	 * @param second Second Probability values to run
	 * @param iterations Number of times to run the probabilities
	 */
	public ProbabilityStudentClub(ProbabilityVO first, ProbabilityVO second, int iterations) {
		super();
		System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tF %1$tT] [%4$-7s] %5$s %n");
		
		for (int i=0; i < iterations; i++) {
			// Run both probabilities
			calculate(first);
			calculate(second);
			countFirst += first.getNumberRolls();
			countSecond += second.getNumberRolls();
			
			// Display the results
			displayNumberRolls(first, "First");
			displayNumberRolls(second, "Second");
			logger.log(Level.INFO, "**************************************************");
			
			// Reset the values
			first.resetRolls();
			second.resetRolls();
		}
		
		// Display the totals
		displayTotals(first, "First", countFirst, iterations);
		displayTotals(second, "Second", countSecond, iterations);
	}
	
	/**
	 * Calls and runs this code
	 * @param args not utilized
	 */
	public static void main(String[] args) {
		
		new ProbabilityStudentClub(
			new ProbabilityVO(5,6),
			new ProbabilityVO(5,5),
			100
		);
		
	}
	
	/**
	 * Displays the totals and averages of all of the iterations
	 * @param vo Probability object to total
	 * @param label HWich probability object was run
	 * @param total Total number of rolls
	 * @param loops Total number of iterations for the experiment
	 */
	public void displayTotals(ProbabilityVO vo, String label, int total, int loops) {
		double avg = total / loops;
		logger.log(Level.INFO, "The {0} Probability Took an average of {1} rolls", new Object[]{ label, avg});
	}
	
	/**
	 * Displays the results of each probability
	 * @param vo
	 * @param label
	 */
	public void displayNumberRolls(ProbabilityVO vo, String label) {
		logger.log(Level.INFO, "The {0} Probability Took {1} rolls", new Object[]{ label, vo.getNumberRolls()});
	}

	/**
	 * Controls the flow of both numbers being implemented
	 * @param vo Probability to calculate
	 */
	private void calculate(ProbabilityVO vo) {
		while(true) {
			findMatch(vo);
			int rand = RandomUtil.generateRandomNumber(1, 7);
			vo.addRoll(RollType.SECOND_NUMBER);
			if (vo.secondNumber == rand) break;
		}

	}
	
	/**
	 * Calls the random number generator and waits until the number is matched
	 * @param vo Probability object
	 * @param rt RollType to match
	 */
	public void findMatch(ProbabilityVO vo) {
		while(true) {
			int rand = RandomUtil.generateRandomNumber(1, 7);
			vo.addRoll(RollType.FIRST_NUMBER);
			if(vo.firstNumber == rand) break;
		}
	}
	
}

/**
 * Value object to hold each probability values
 */
class ProbabilityVO {
	enum RollType { FIRST_NUMBER, SECOND_NUMBER }
	int firstNumber;
	int secondNumber;
	int firstRoll;
	int secondRoll;
	
	/**
	 * Helper Constructor
	 * @param firstNumber Value of the first number
	 * @param secondNumber Value of the second number
	 */
	ProbabilityVO(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	/**
	 * Clears the counter
	 */
	public void resetRolls() {
		firstRoll = 0;
		secondRoll = 0;
	}
	
	/**
	 * Increments the roll counter;
	 * @param rt Roll Type to increment the roll counter
	 */
	public void addRoll(RollType rt) {
		if (RollType.FIRST_NUMBER.equals(rt)) firstRoll++;
		else secondRoll++;
	}
	
	/**
	 * Returns the total number of rolls
	 * @return Total of the first and second number rolls
	 */
	public int getNumberRolls() {
		return firstRoll + secondRoll;
	}
}
