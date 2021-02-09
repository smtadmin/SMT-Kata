package com.smt.kata.object;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// JDk 11.x
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Kata Class
import com.smt.kata.object.Student.Grade;

/****************************************************************************
 * <b>Title</b>: ReflectionKataTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the Reflection Kata code puzzle
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 9, 2021
 * @updates:
 ****************************************************************************/
class ReflectionKataTest {
	
	private static ReflectionKata rk;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Sets the values for the members int he Student class (through the ReflectionKata)
		rk = new ReflectionKata("12345", "James", "Camire", Grade.SENIOR, 3.96);
	}

	/**
	 * Test method for {@link com.smt.kata.object.ReflectionKata#getInterfaces()}.
	 */
	@Test
	void testGetInterfaces() {
		assertEquals("java.io.Serializable", rk.getInterfaces().get(0).getTypeName());
	}

	/**
	 * Test method for {@link com.smt.kata.object.ReflectionKata#getEnumTypes()}.
	 */
	@Test
	void testGetEnumTypes() {
		List<Grade> enumTypes = rk.getEnumTypes();
		assertEquals(6, enumTypes.size());
		assertTrue(enumTypes.contains(Grade.FRESHMAN));
		assertTrue(enumTypes.contains(Grade.SOPHOMORE));
		assertTrue(enumTypes.contains(Grade.JUNIOR));
		assertTrue(enumTypes.contains(Grade.SENIOR));
		assertTrue(enumTypes.contains(Grade.GRADUATE));
		assertTrue(enumTypes.contains(Grade.DOCTORATE));
	}

	/**
	 * Test method for {@link com.smt.kata.object.ReflectionKata#getFields()}.
	 */
	@Test
	void testGetFields() {
		Map<String, Class<?>> fields = rk.getFields();
		List<String> keys = new ArrayList<>(fields.keySet());
		
		assertEquals(6, fields.size());
		assertEquals("firstName", keys.get(0));
		assertEquals(String.class, fields.get(keys.get(0)));
		assertEquals(double.class, fields.get(keys.get(1)));
		
		assertEquals("studentId", keys.get(5));
		assertEquals(String.class, fields.get(keys.get(5)));
	}

	/**
	 * Test method for {@link com.smt.kata.object.ReflectionKata#getMethods()}.
	 */
	@Test
	void testGetMethods() {
		Map<String, Class<?>> methods = rk.getMethods();
		List<String> keys = new ArrayList<>(methods.keySet());
		System.out.println(keys);
		assertEquals(10, methods.size());
		
		assertEquals("getFirstName", keys.get(0));
		assertEquals(String.class, methods.get(keys.get(0)));
		
		assertEquals("getStudentId", keys.get(4));
		assertEquals(String.class, methods.get(keys.get(4)));
		
		assertEquals("setGpa", keys.get(6));
		assertEquals(void.class, methods.get(keys.get(6)));
	}

	@Test
	void testGetMethodValues() throws Exception {
		Map<String, Object> values = rk.getMethodValues();
		List<String> keys = new ArrayList<>(values.keySet());
		
		assertEquals(5, values.size());
		assertEquals("James", values.get(keys.get(0)));
		assertEquals(3.96, values.get(keys.get(1)));
		assertEquals("Camire", values.get(keys.get(2)));
		assertEquals(Grade.SENIOR, values.get(keys.get(3)));
		assertEquals("12345", values.get(keys.get(4)));
	}

}
