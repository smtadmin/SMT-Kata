package com.smt.kata.io;

// JDK 11.x
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: CountingLines.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Counting Code Lines
 * 
 * Counting lines of code in Java source is not quite as simple as it seems.
 * 
 * This week let’s write something vaguely useful: a utility that counts the number
 * of lines of actual code in a Java source file. For the purpose of this exercise, 
 * a line is counted if it contains something other than whitespace or text in a comment. 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 26, 2021
 * @updates:
 ****************************************************************************/
public class CountingLines {

	/**
	 * Location of the class to load
	 */
	public static final String RESOURCE = "/home/etewa/Code/git/Kata/SMT-Kata/src/main/java/";
	
	/**
	 * Get the actual number of lines of code for the given package and class
	 * @param clazzName Fully qualified name (com.smt.util.someclass)
	 * @return Number of lines of java code in the file
	 * @throws IOException
	 */
	public int getNumberLines(String clazzName) throws IOException {
		String filePath = clazzName.replace('.', '/') + ".java";
		List<String> lines = getClassContents(filePath);
		int totalLines = 0;
		for (String line : lines) {
			if (StringUtil.isEmpty(line) || line.startsWith("*") || line.startsWith("/")) continue;
			totalLines++;
		}
		
		return totalLines;
	}
	
	/**
	 * Retrieves the text of the file
	 * @return List of each line of the file, trimmed
	 * @throws IOException If file ot able to be loaded
	 */
	private List<String> getClassContents(String filePath) throws IOException {
		List<String> lines = new ArrayList<>();
        File f = new File(RESOURCE + filePath);
        try (InputStreamReader isr = new FileReader(f)) {
	    	try ( BufferedReader reader = new BufferedReader(isr)) {
	            String s;
	            while ( (s = reader.readLine() ) !=null ) {
	               lines.add(s.trim());
	            }
	    	}
        }
    	
        return lines;
	}
}
