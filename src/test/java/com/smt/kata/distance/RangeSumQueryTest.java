package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Kata Libs
import com.smt.kata.distance.bean.CoordinateVO;
import com.smt.kata.distance.bean.Rectangle;

/****************************************************************************
 * <b>Title</b>: RangeSumQueryTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for Range Sum Query Kata
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 31, 2021
 * @updates:
 ****************************************************************************/
class RangeSumQueryTest {
	
	// Members
	private int[][] matrix;
	private RangeSumQuery rsq;
	private List<Rectangle> areas;
	
	@BeforeEach
	public void init() {
		matrix = new int[][] {
			{1,2,3,4,5,6,7},
			{7,6,5,4,3,2,1},
			{1,1,1,1,1,1,1},
			{1,2,3,4,5,6,7},
			{7,6,5,4,3,2,1},
			{2,2,2,2,2,2,2}
		};
		
		rsq = new RangeSumQuery(matrix);
		areas = new ArrayList<>();
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeNullMatrix() throws Exception {
		rsq = new RangeSumQuery(null);
		assertEquals(0, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeEmptyMatrix() throws Exception {
		rsq = new RangeSumQuery(new int[0][]);
		assertEquals(0, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeMatrixTooSmall() throws Exception {
		rsq = new RangeSumQuery(new int[][] {{1}, {2}});
		assertEquals(0, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeEmptyAreas() throws Exception {
		assertEquals(0, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeEasy() throws Exception {
		areas.add(new Rectangle(new CoordinateVO(0, 0), new CoordinateVO(2,4)));
		assertEquals(45, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeBottomUp() throws Exception {
		areas.add(new Rectangle(new CoordinateVO(3, 4), new CoordinateVO(6,6)));
		assertEquals(30, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeOutsideMatrix() throws Exception {
		areas.add(new Rectangle(new CoordinateVO(13, 14), new CoordinateVO(16,16)));
		assertEquals(0, rsq.sumRange(areas));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeTwoNotOverlapping() throws Exception {
		areas.add(new Rectangle(new CoordinateVO(0, 0), new CoordinateVO(2,4)));
		areas.add(new Rectangle(new CoordinateVO(3, 4), new CoordinateVO(6,6)));
		assertEquals(75, rsq.sumRange(areas));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.RangeSumQuery#sumRange(java.util.List)}.
	 */
	@Test
	void testSumRangeTwoOverlapping() throws Exception {
		areas.add(new Rectangle(new CoordinateVO(0, 0), new CoordinateVO(4,4)));
		areas.add(new Rectangle(new CoordinateVO(2, 2), new CoordinateVO(6,6)));
		assertEquals(113, rsq.sumRange(areas));
	}
}
