package com.tomtom.patterncounter.io;

import java.util.Map;

/**
 * Standard output interface
 */
public interface IStandardOutput {

	/**
	 * Iterate and print the given input map
	 * @param result Map&lt;String,Integer&gt;- The unique item as key and count as number
	 */
	void printOutput(Map<String, Integer> result);

}
