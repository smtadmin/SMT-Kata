package com.smt.kata.data;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Apache commons 3.x
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: TagParser.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> In a tag-based language like XML or HTML, contents are 
 * enclosed between a start tag and an end tag like <tag>contents</tag>. Note 
 * that the corresponding end tag starts with a /.
 * 
 * Given a string of text in a tag-based language, parse this text and retrieve the 
 * contents enclosed within sequences of well-organized tags meeting the following criterion:
 * 
 * The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> 
 * is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.
 * Tags can be nested as many times as you'd like
 * For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
 * 
 * Process each tag and add the valid tags into a collection of tags
 * 
 * Tags can consist of any printable characters.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 27, 2021
 * @updates:
 ****************************************************************************/
public class TagParser {

	/**
	 * 
	 */
	public TagParser() {
		super();
	}

	/**
	 * Parses the content into 
	 * @param content
	 * @return
	 */
	public List<String> evaluateTags(String tag) {
		List<String> tags = new ArrayList<>();
		if (StringUtils.isEmpty(tag)) return tags;
		
		// Process the outer tags
		processFirstPass(tags, tag);
		
		// Process the inner tags.  Add to a new colelction as not to screw with the 
		// the looping Collection.class  Combine later
		List<String> innerTags = new ArrayList<>();
		for (String iTag : tags) {
			int start = iTag.indexOf('>') + 1;
			int end = iTag.lastIndexOf("</");
			processFirstPass(innerTags, iTag.substring(start, end));
		}
		
		tags.addAll(innerTags);
		return tags;
	}
	
	/**
	 * Grabs the outer tags and adds them to the list of tags
	 * @param tags
	 * @param tag
	 */
	private void processFirstPass(List<String> tags, String tag) {
		int loc = 0;
		while(true) {
			loc = parseTag(tags, tag, loc);
			if (loc >= tag.length()) break;
		}
	}
	
	/**
	 * Parses out a section of the content
	 * @param tags
	 * @param tag
	 * @param start
	 * @return
	 */
	private int parseTag(List<String> tags, String tag, int start) {
		String content = tag.toLowerCase();
		int firstStart = content.indexOf("<", start);
		if (firstStart == -1) return tag.length();
		
		int firstEnd = content.indexOf(">", start);
		if (firstEnd == -1 || firstEnd - firstStart > 5) return tag.length();
		
		String startTag = content.substring(firstStart, firstEnd + 1);
		String endTag = "</" + startTag.substring(1);
		
		int lastLoc = content.indexOf(endTag);
		if (lastLoc == -1) return tag.length();
		lastLoc += endTag.length();
		
		tags.add(tag.substring(firstStart, lastLoc));
		
		return lastLoc;
	}
}
