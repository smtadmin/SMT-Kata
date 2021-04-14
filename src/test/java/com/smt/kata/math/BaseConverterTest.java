package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> BaseConverterTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> The unit test for the Base Converter Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 6, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class BaseConverterTest {
	
	// Member
	BaseConverter bc = new BaseConverter();

	/**
		 * Test method for {@link com.smt.kata.math.BaseConverter#decimaltoBinary(int)}.
		 */
		@Test
		void testDecimaltoBinary() throws Exception {
			assertEquals(11, bc.decimaltoBinary(3));
			assertEquals(10000, bc.decimaltoBinary(16));
			assertEquals(101100101, bc.decimaltoBinary(357));
		}

	/**
		 * Test method for {@link com.smt.kata.math.BaseConverter#decimaltoOctal(int)}.
		 */
		@Test
		void testDecimaltoOctal() throws Exception {
			assertEquals(7, bc.decimaltoOctal(7));
			assertEquals(53, bc.decimaltoOctal(43));
			assertEquals(511, bc.decimaltoOctal(329));
		}

	/**
		 * Test method for {@link com.smt.kata.math.BaseConverter#decimaltoHexidecimal(int)}.
		 */
		@Test
		void testDecimaltoHexidecimal() throws Exception {
			assertEquals("C", bc.decimaltoHexidecimal(12));
			assertEquals("159", bc.decimaltoHexidecimal(345));
			assertEquals("12A", bc.decimaltoHexidecimal(298));
			assertEquals("FF", bc.decimaltoHexidecimal(255));
		}

	/**
		 * Test method for {@link com.smt.kata.math.BaseConverter#convertToDecimal(java.lang.String, int)}.
		 */
		@Test
		void testConvertToBaseToDecimalBinary() throws Exception {
			assertEquals(3, bc.convertToDecimal("11", 2));
			assertEquals(16, bc.convertToDecimal("10000", 2));
			assertEquals(357, bc.convertToDecimal("101100101", 2));
		}

	/**
		 * Test method for {@link com.smt.kata.math.BaseConverter#convertToDecimal(java.lang.String, int)}.
		 */
		@Test
		void testConvertToBaseToDecimalOctal() throws Exception {
			assertEquals(7, bc.convertToDecimal("7", 8));
			assertEquals(43, bc.convertToDecimal("53", 8));
			assertEquals(329, bc.convertToDecimal("511", 8));
		}
}
