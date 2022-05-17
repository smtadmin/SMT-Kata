package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DiamondGenerationTest {

	private DiamondGeneration dg = new DiamondGeneration();

	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void generateNull() throws Exception {
		List<String> diamond = dg.generateDiamond(null);
		assertEquals(0, diamond.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void generateInvalid() throws Exception {
		List<String> diamond = dg.generateDiamond(Character.valueOf('1'));
		assertEquals(0, diamond.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void generateNonPrintable() throws Exception {
		List<String> diamond = dg.generateDiamond(Character.forDigit(1, 10));
		assertEquals(0, diamond.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void generateDiamondUpperCase() throws Exception {
		List<String> diamond = dg.generateDiamond('C');
		assertEquals(5, diamond.size());
		assertEquals("  A  ", diamond.get(0));
		assertEquals(" B B ", diamond.get(1));
		assertEquals("C   C", diamond.get(2));
		assertEquals(" B B ", diamond.get(3));
		assertEquals("  A  ", diamond.get(4));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void generateDiamondLowerCase() throws Exception {
		List<String> diamond = dg.generateDiamond('c');
		assertEquals(5, diamond.size());
		assertEquals("  A  ", diamond.get(0));
		assertEquals(" B B ", diamond.get(1));
		assertEquals("C   C", diamond.get(2));
		assertEquals(" B B ", diamond.get(3));
		assertEquals("  A  ", diamond.get(4));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void generateDiamondSingleCase() throws Exception {
		List<String> diamond = dg.generateDiamond('A');
		assertEquals(1, diamond.size());
		assertEquals("A", diamond.get(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void generateDiamondLongCase() throws Exception {
		List<String> diamond = dg.generateDiamond('z');
		assertEquals(51, diamond.size());
		assertEquals("Z                                                 Z", diamond.get(25));
	}
}
