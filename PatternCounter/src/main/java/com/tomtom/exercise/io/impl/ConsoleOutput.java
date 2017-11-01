package com.tomtom.exercise.io.impl;

import java.util.Map;

import com.tomtom.exercise.io.IStandardOutput;


/**
 * The standard output that supports Console output 
 *
 */
public class ConsoleOutput implements IStandardOutput {

	@Override
	public void printOutput(Map<String, Integer> result) {
		if (result != null) {
			printResults(result);
		}

	}

	/**
	 * Iterate and print the results to console
	 * @param result Map&lt;String,Integer&gt;- The unique item as key and count as number
	 */
	private void printResults(Map<String, Integer> result) {
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			String key = entry.getKey().toString();
			Integer value = entry.getValue();
			if ((key != null) && (value == null)) {
				System.out.println(key);
			} else {
				System.out.println(key + ", " + value);
			}
		}

	}

}
