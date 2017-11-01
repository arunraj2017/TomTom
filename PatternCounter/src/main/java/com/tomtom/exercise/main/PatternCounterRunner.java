/***
 * PatternCounterRunner
 * This is the main class to run the application
 * 
 * Assumptions used for running the code:
 * 1. Java Version needed is 1.8
 * 2. Input file contents are expected to be in a single line rather than in multi lines
 * 3. Only whole numbers is considered as numbers not decimals
 * 4. If the file does not have minimum 3 words, none of the scenarios are executed and returns empty
 * 5. For Scenario 3 (Phrases) if there are not enough words for the last phrase, then that line is skipped
 * 6. Cucumber is used as tool for BDD and build tool is Maven
 * 7. Run time exception with proper message is thrown if there occurs any exception scenarios
 ***/

package com.tomtom.exercise.main;

import java.util.Map;
import java.util.Scanner;

import com.tomtom.exercise.service.PatternCounterService;
import com.tomtom.exercise.service.impl.PatternCounterServiceImpl;

public class PatternCounterRunner {

	private static PatternCounterService patternCounterService;

	public static void main(String[] args) {
		String inputs[] = getUserInputs();
		patternCounterService = new PatternCounterServiceImpl();
		Map<String, Integer> result = null;

		try {
			result = patternCounterService.findPatternFromFile(inputs[0], inputs[1]);
		} catch (Exception e) {
			System.err.println("Run time exception occured :" + e);
		}

		if (result != null) {
			printResults(result);
		}

	}

	private static void printResults(Map<String, Integer> result) {
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

	private static String[] getUserInputs() {
		String[] inputs = new String[2];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			inputs[i] = scanner.nextLine();
		}
		if (scanner != null) {
			scanner.close();
		}
		return inputs;
	}

}
