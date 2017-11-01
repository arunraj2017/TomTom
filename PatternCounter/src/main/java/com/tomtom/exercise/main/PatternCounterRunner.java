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
 * 8. IO and core logic are loosely coupled. IO wired via Dependency Injection and Service class uses Factory
 ***/

package com.tomtom.exercise.main;

import java.util.Map;

import com.tomtom.exercise.io.impl.ConsoleOutput;
import com.tomtom.exercise.io.impl.KeyBoardInput;
import com.tomtom.exercise.io.runner.IORunner;
import com.tomtom.exercise.service.PatternCounterService;
import com.tomtom.exercise.service.impl.PatternCounterServiceImpl;

public class PatternCounterRunner {

	private static PatternCounterService patternCounterService;

	public static void main(String[] args) {

		IORunner io = new IORunner(new KeyBoardInput(), new ConsoleOutput());
		String inputs[] = io.getUserInputs();
		patternCounterService = new PatternCounterServiceImpl();
		Map<String, Integer> result = null;

		try {
			result = patternCounterService.findPatternFromFile(inputs[0], inputs[1]);
		} catch (Exception e) {
			System.err.println("Run time exception occured :" + e);
		}

		io.printResult(result);

	}

}
