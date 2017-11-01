package com.tomtom.patterncounter.service;

import java.util.Map;


public interface PatternCounterService {

	/**
	 * @param file File name with path
	 * @param patternType list of accepted pattern types <br>
	 *  1- Word pattern count<br>
	 *  2- Number pattern count<br>
	 *  3- Phrase pattern count<br>
	 * @return Map&lt;String,Integer&gt;- The unique item as key and count as number
	 * @throws Exception Run time exception
	 */
	Map<String, Integer> findPatternFromFile(String file, String patternType) throws Exception;

}
