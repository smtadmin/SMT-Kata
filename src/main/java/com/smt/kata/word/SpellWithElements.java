package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: SpellWithElements.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Spell with Chemical Elements
 * 
 * Write a function that takes a string and finds all possible ways to spell it using
 * abbreviations from the periodic table.
 * 
 * More Details
 * 
 * Every chemical element in the periodic table has a unique symbol consisting of 
 * one to three letters. For instance, the symbols for oxygen and helium are O and He. 
 * A puzzle some chemistry students try is to spell a common word using the symbols 
 * from the periodic table.
 *  For example, you can spell the word phone with the symbols P, H, O and Ne, which 
 * are the symbols for phosphorus, hydrogen, oxygen and neon, respectively.
 * 
 * What Your Function Should Do
 * Create a function called SpellWithElements that takes a string as input. The 
 * output of your function should be a list of lists containing all possible spellings 
 * of the string using chemical element abbreviations. 
 * 
 * in[2]:=SpellWithElements["sarcasm"]
 * Out[2]={{S, Ar, Ca, Sm}}
 * In[3]:=SpellWithElements["police"]
 * Out[3]={{Po, Li, Ce}, {P, O, Li, Ce}}
 * In[4]:=SpellWithElements["Zoo"]
 * Out[4]={}
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 25, 2021
 * @updates:
 ****************************************************************************/
public class SpellWithElements {

	private Map<String, String> elements = new HashMap<>();
	
	/**
	 * Assigns the elements on init
	 */
	public SpellWithElements() {
		super();
		this.loadElements();
	}
	
	/**
	 * Finds the matching patterns of words to the letter(s)
	 * @param source Phrae to match
	 * @return Collection of lists of the matching patterns
	 */
	public List<List<String>> findPatterns(String source) {
		List<List<String>> matches = new ArrayList<>();
		if (source == null || source.length() == 0) return matches;
		
		List<String> vals = recurse(source, 0, "", new ArrayList<>());
		
		for (String row : vals) {
			if (row.replace("|", "").equalsIgnoreCase(source)) {
				List<String> data = Arrays.asList(row.split("\\|"));
				matches.add(data);
			}
		}
		
		return matches;
	}
	
	/**
	 * Recurse a single and dual character match.  Concat the items to create a 
	 * unique list of possibilities
	 * @param source Source to process
	 * @param index Current index of the processing
	 * @param newSource Concatenated source
	 * @param entries Entry in the list for each entry
	 * @return List of entries
	 */
	protected List<String> recurse(String source, int index, String newSource, List<String> entries) {
		if (index + 1 >= source.length()) return entries;
		
		// Recurse the single character entries
		String single = source.substring(index, index + 1);
		if (elements.containsKey(single)) {
			entries.add(newSource + single + "|");
			recurse(source, index + 1, (newSource + single + "|"), entries);
		}
		
		// Recurse the 2 cahracter entries
		String two = source.substring(index, index + 2);
		if (elements.containsKey(two)) {
			entries.add(newSource + two + "|");
			recurse(source, index + 2, (newSource + two + "|"), entries);
		} else {
			return entries;
		}

		return entries;
	}
	
	/**
	 * Assigns all of the periodic elements to the map
	 */
	private void loadElements() {
		elements.put("h","hydrogen");
		elements.put("he","helium");
		elements.put("li","lithium");
		elements.put("be","beryllium");
		elements.put("b","boron");
		elements.put("c","carbon");
		elements.put("n","nitrogen");
		elements.put("o","oxygen");
		elements.put("f","fluorine");
		elements.put("ne","neon");
		elements.put("na","sodium");
		elements.put("mg","magnesium");
		elements.put("al","aluminum");
		elements.put("si","silicon");
		elements.put("p","phosphorus");
		elements.put("s","sulfur");
		elements.put("cl","chlorine");
		elements.put("ar","argon");
		elements.put("k","potassium");
		elements.put("ca","calcium");
		elements.put("sc","scandium");
		elements.put("ti","titanium");
		elements.put("v","vanadium");
		elements.put("cr","chromium");
		elements.put("mn","manganese");
		elements.put("fe","iron");
		elements.put("co","cobalt");
		elements.put("ni","nickel");
		elements.put("cu","copper");
		elements.put("zn","zinc");
		elements.put("ga","gallium");
		elements.put("ge","germanium");
		elements.put("as","arsenic");
		elements.put("se","selenium");
		elements.put("br","bromine");
		elements.put("kr","krypton");
		elements.put("rb","rubidium");
		elements.put("sr","strontium");
		elements.put("y","yttrium");
		elements.put("zr","zirconium");
		elements.put("nb","niobium");
		elements.put("mo","molybdenum");
		elements.put("tc","technetium");
		elements.put("ru","ruthenium");
		elements.put("rh","rhodium");
		elements.put("pd","palladium");
		elements.put("ag","silver");
		elements.put("cd","cadmium");
		elements.put("in","indium");
		elements.put("sn","tin");
		elements.put("sb","antimony");
		elements.put("te","tellurium");
		elements.put("i","iodine");
		elements.put("xe","xenon");
		elements.put("cs","cesium");
		elements.put("ba","barium");
		elements.put("la","lanthanum");
		elements.put("ce","cerium");
		elements.put("pr","praseodymium");
		elements.put("nd","neodymium");
		elements.put("pm","promethium");
		elements.put("sm","samarium");
		elements.put("eu","europium");
		elements.put("gd","gadolinium");
		elements.put("tb","terbium");
		elements.put("dy","dysprosium");
		elements.put("ho","holmium");
		elements.put("er","erbium");
		elements.put("tm","thulium");
		elements.put("yb","ytterbium");
		elements.put("lu","lutetium");
		elements.put("hf","hafnium");
		elements.put("ta","tantalum");
		elements.put("w","tungsten");
		elements.put("re","rhenium");
		elements.put("os","osmium");
		elements.put("ir","iridium");
		elements.put("pt","platinum");
		elements.put("au","gold");
		elements.put("hg","mercury");
		elements.put("tl","thallium");
		elements.put("pb","lead");
		elements.put("bi","bismuth");
		elements.put("po","polonium");
		elements.put("at","astatine");
		elements.put("rn","radon");
		elements.put("fr","francium");
		elements.put("ra","radium");
		elements.put("ac","actinium");
		elements.put("th","thorium");
		elements.put("pa","protactinium");
		elements.put("u","uranium");
		elements.put("np","neptunium");
		elements.put("pu","plutonium");
		elements.put("am","americium");
		elements.put("cm","curium");
		elements.put("bk","berkelium");
		elements.put("cf","californium");
		elements.put("es","einsteinium");
		elements.put("fm","fermium");
		elements.put("md","mendelevium");
		elements.put("no","nobelium");
		elements.put("lr","lawrencium");
		elements.put("rf","rutherfordium");
		elements.put("db","dubnium");
		elements.put("sg","seaborgium");
		elements.put("bh","bohrium");
		elements.put("hs","hassium");
		elements.put("mt","meitnerium");
	}
}
