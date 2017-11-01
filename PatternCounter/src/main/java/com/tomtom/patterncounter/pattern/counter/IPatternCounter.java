package com.tomtom.patterncounter.pattern.counter;

import java.util.Map;


/**
 * The common interface that must be implemented by all patterns
 */
public interface IPatternCounter {

	/**
	 * Get Distinct counts of word/number/phrase from given input string 
	 * @param file - file contents as string
	 * @param fileName - name of the file
	 * @return  Map&lt;String,Integer&gt;- The unique item as key and count as number
	 */
	public Map<String, Integer> getCount(String file, String fileName);

}
