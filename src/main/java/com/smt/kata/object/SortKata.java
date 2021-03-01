package com.smt.kata.object;

// JDK 11.x
import java.util.Comparator;

import com.smt.kata.util.HashCodeUtil;

/****************************************************************************
 * <b>Title</b>: SortKata.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> This Kata focuses on Collection sorting and how it works
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 7, 2021
 * @updates:
 ****************************************************************************/
public class SortKata implements Comparable<SortKata> {
	
	private String id;
	private String name;
	private int age;

	/**
	 * 
	 */
	public SortKata() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * (non-javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeUtil.hash(this.getId())
			+ HashCodeUtil.hash(this.getName())
			+ HashCodeUtil.hash(getAge());
	}
	
	/*
	 * (non-javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getId() + "|" + getName() + "|" + getAge();
	}
	
	/*
	 * (non-javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SortKata)) return false;
		SortKata per = (SortKata)obj;
		return this.hashCode() == per.hashCode();
	}
	
	/*
	 * (non-javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(SortKata per) {
		if (this.getId() == null) return -1;
		else return this.getId().compareTo(per.getId());
	}
	
	/**
	 * 
	 * @author etewa
	 *
	 */
	public class AgeComparator implements Comparator<SortKata> {

		@Override
		public int compare(SortKata src, SortKata dest) {
			return Integer.compare(src.getAge(), dest.getAge());
		}
		
	}
	
	/**
	 * 
	 * @author etewa
	 *
	 */
	class NameComparator implements Comparator<SortKata> {

		@Override
		public int compare(SortKata src, SortKata dest) {
			if (dest.getName() == null ) return 1;
			else return src.getName().compareTo(dest.getName());
		}
		
	}

}




