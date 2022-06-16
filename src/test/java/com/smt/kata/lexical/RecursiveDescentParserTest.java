package com.smt.kata.lexical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RecursiveDescentParserTest {

	RecursiveDescentParser rdp = new RecursiveDescentParser();

	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateNull() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex(null);
	    });

	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.NOT_EMPTY_EXCEPTION));

	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateEmpty() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("");
	    });

	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.NOT_EMPTY_EXCEPTION));
    }
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testInvalidExpressionCharacters() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("1 + a = 1");
	    });
		
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.INVALID_CHAR_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testLeftHandSideUnbalanced() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("1");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.LEFT_UNBALANCED_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testInvalidInteger() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("(1+1)=+");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.INVALID_INT_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testInvalidOperator() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("(1 _ 2) = 1");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.INVALID_OP_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testMissingOperator() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("(1 ");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.MISSING_OP_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testMissingRightHandParen() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("(1 + 3");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.MISSING_CLOSE_PAREN_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testMissingRightHandParenInvalid() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("(1 + 3(");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.MISSING_CLOSE_PAREN_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testInvalidCharExpression() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("+");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.INVALID_EXPRESSION_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testInvalidSolution() throws Exception {
		Exception exception = assertThrows(ParseException.class, () -> {
			rdp.lex("((((12+12) - 2) * 2) / 11)=6");
	    });
		
		String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(RecursiveDescentParser.RIGHT_UNBALANCED_EXCEPTION));
	}
	
	/**
	 * Test method for {@link com.smt.kata.math.NoOpDivision#divide(int, int)}.
	 */
	@Test
	void testValidateValid() throws Exception {
		assertEquals(4, rdp.lex("((((12+12) - 2) * 2) / 11)=4"));
	}
}
