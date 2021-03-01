package com.smt.kata.object;

//JDK 11.x
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Inner class imports
import com.smt.kata.object.Student.Grade;

/****************************************************************************
 * <b>Title</b>: ReflectionKata.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> JAVA reflection is a very powerful tool to inspect the 
 * attributes of a class in runtime.  In this kata, you will display a list of 
 * the member variables with their class types as well as their methods and 
 * return types.  The returned entities will be alphabetized.  Also provide the 
 * Interface name and type for the student class
 * be alphabetized.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @param <T>
 * @since Feb 9, 2021
 * @updates:
 ****************************************************************************/
public class ReflectionKata {
	
	// Members
	private Map<String, Class<?>> fieldMap = new TreeMap<>();
	private Map<String, Class<?>> methodMap = new TreeMap<>();
	private Map<String, Object> valueMap = new TreeMap<>();
	private List<Type> interfaces = new ArrayList<>();
	private List<Grade> grades = new ArrayList<>();
	private Student student;
	
	/**
	 * 
	 */
	public ReflectionKata(String id, String first, String last, Grade level, double gpa)  throws Exception {
		super();
		student = new Student(id, first, last, level, gpa);
		processStudentClass();
	}

	/**
	 * Process the student class using reflection and stores those entities in the 
	 * appropriate collections
	 */
	private void processStudentClass() throws Exception {
		// Process the fields
		for (Field f : student.getClass().getDeclaredFields()) {
			fieldMap.put(f.getName(), f.getType());
		}
		
		
		// process the methods
		for (Method m : student.getClass().getDeclaredMethods()) {
			if (m.getName().startsWith("$")) continue;
			methodMap.put(m.getName(), m.getReturnType());
			
			// Add the values
			if (m.getName().startsWith("get"))
				valueMap.put(m.getName(), m.invoke(student));
		}
		
		// process the interfaces
		interfaces.addAll(Arrays.asList(student.getClass().getGenericInterfaces()));
		
		// Process the enum
		grades.addAll(Arrays.asList(Grade.class.getEnumConstants()));
	}
	
	/**
	 * Returns the values for each of the methods in the student class.
	 * @return
	 */
	public Map<String, Object> getMethodValues() {
		return valueMap;
	}
	
	/**
	 * Returns a collection of the interface types
	 * @return
	 */
	public List<Type> getInterfaces() {
		return interfaces;
	}
	
	/**
	 * Returns a collection of the enum types for the Grade enum
	 * @return
	 */
	public List<Grade> getEnumTypes() {
		return grades;
	}
	
	/**
	 * Returns an alphabetized list of fields in the student class
	 * @return
	 */
	public Map<String, Class<?>> getFields() {
		return fieldMap;
	}
	
	/**
	 * Returns an alphabetized list of methods in the stucent class
	 * @return
	 */
	public Map<String, Class<?>> getMethods() {
		return methodMap;
	}

}

/**
 * Inner class to be used by the reflection Kata
 * @author etewa
 *
 */
class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 257903626171696570L;

	/**
	 * Enum to supply the available options for grades
	 * @author etewa
	 *
	 */
	public enum Grade {
		FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, DOCTORATE
	}
	
	// Members
	private String studentId;
	private String firstName;
	private String lastName;
	private Grade level;
	private double gpa;
	
	/**
	 * Helper constructor to assign all user data
	 * @param studentId
	 * @param firstName The student's first name
	 * @param lastName The student's last name
	 * @param level The student's grade level
	 * @param gpa The student's grade point average
	 */
	public Student(String studentId, String firstName, String lastName, Grade level, double gpa ) {
		setStudentId(studentId);
		setFirstName(firstName);
		setLastName(lastName);
		setLevel(level);
		setGpa(gpa);
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the level
	 */
	public Grade getLevel() {
		return level;
	}

	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Grade level) {
		this.level = level;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}