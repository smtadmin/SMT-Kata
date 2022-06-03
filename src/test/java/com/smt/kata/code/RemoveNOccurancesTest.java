package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class RemoveNOccurancesTest {

	private RemoveNOccurances rno = new RemoveNOccurances();

	@Test
	void testNull() throws Exception {
		assertEquals(0, rno.removeOccurances(null, 0).length);
	}
	
	@Test
	void testEmpty() throws Exception {
		assertEquals(0, rno.removeOccurances(new int[0], 0).length);
	}
	
	@Test
	void testBadOccurance() throws Exception {
		assertEquals(0, rno.removeOccurances(new int[0], -1).length);
	}
	
	@Test
	void testRemoveAll() throws Exception {
		int[] data = new int[] {1,2,3,1,2,3,1,2,3,4};
		int [] res = rno.removeOccurances(data, 0);
		assertEquals(res.length, 0);
	}
	
	@Test
	void testMax2() throws Exception {
		int[] sol = new int[] {4,1,2,3,1,2,3,4};
		int[] data = new int[] {4,1,2,3,1,2,3,1,2,3,4};
		int [] res = rno.removeOccurances(data, 2);
		assertEquals(res.length, sol.length);
		IntStream.range(0, sol.length).forEach(i -> assertEquals(res[i], sol[i]));
	}
	
	@Test
	void testOverMax() throws Exception {
		int[] data = new int[] {1,2,3,1,2,3,1,2,3,4};
		int [] res = rno.removeOccurances(data, 5);
		assertEquals(res.length, data.length);
		IntStream.range(0, data.length).forEach(i -> assertEquals(res[i], data[i]));
	}
	
	@Test
	void testOverComp() throws Exception {
		int[] sol = new int[] {-1,2,3,1,-2,4,-6};
		int[] data = new int[] {-1,2,3,1,2,3,1,-2,3,4,-6};
		int [] res = rno.removeOccurances(data, 1);
		assertEquals(res.length, sol.length);
		IntStream.range(0, sol.length).forEach(i -> assertEquals(res[i], sol[i]));
	}
}
