package com.smt.kata.object;

// Junit 5
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// Spacelibs 1.x
import com.siliconmtn.data.bean.GenericVO;

/****************************************************************************
 * <b>Title:</b> SerializerUtilTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Serializer util kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 19, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class SerializerUtilTest {

	// Members
	private SerializerUtil su = new SerializerUtil();
	
	/**
	 * Test method for {@link com.smt.kata.object.SerializerUtil#isSerializable(java.lang.Object)}.
	 */
	@Test
	void testIsSerializable() throws Exception {
		assertTrue(su.isSerializable("hello"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.SerializerUtil#isSerializable(java.lang.Object)}.
	 */
	@Test
	void testSerializableGenericVO() throws Exception {
		assertTrue(su.isSerializable(new GenericVO("hello", "world")));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.SerializerUtil#isSerializable(java.lang.Object)}.
	 */
	@Test
	void testSerializableGenericVOTwice() throws Exception {
		assertTrue(su.isSerializable(new GenericVO("hello", new GenericVO("World", "My World"))));
	}

	/**
	 * Test method for {@link com.smt.kata.object.SerializerUtil#isSerializable(java.lang.Object)}.
	 */
	@Test
	void testIsNotSerializable() throws Exception {
		assertFalse(su.isSerializable(new Object()));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.SerializerUtil#serialize(java.lang.Object)}.
	 */
	@Test
	void testSerialize() throws Exception {
		byte[] orig = new byte[] {-84, -19, 0, 5, 116, 0, 5, 104, 101, 108, 108, 111};
		byte[] ser = su.serialize("hello");
		
		for (int i = 0; i < orig.length; i++) {
			assertEquals(orig[i], ser[i]);
		}
	}

	/**
	 * Test method for {@link com.smt.kata.object.SerializerUtil#deserialize(byte[])}.
	 */
	@Test
	void testDeserialize() throws Exception {
		byte[] orig = new byte[] {-84, -19, 0, 5, 116, 0, 5, 104, 101, 108, 108, 111};
		assertEquals("hello", su.deserialize(orig));
	}

}
