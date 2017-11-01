

package com.tomtom.patterncounter.main;

import java.util.Map;

import com.tomtom.patterncounter.io.impl.ConsoleOutput;
import com.tomtom.patterncounter.io.impl.KeyBoardInput;
import com.tomtom.patterncounter.io.runner.IORunner;
import com.tomtom.patterncounter.service.PatternCounterService;
import com.tomtom.patterncounter.service.impl.PatternCounterServiceImpl;

/***
 * PatternCounterRunner
 * This is the main class to run the application
 * 
 * Assumptions used for running the code:
 * 1. Java Version needed is 1.8
 * 2. Input file contents are expected to be in a single line rather than multi lines
 * 3. Only whole numbers are considered as numbers not decimals
 * 4. If the file does not have minimum 3 words, none of the scenarios gets executed and returns empty
 * 5. For Scenario 3 (Phrases) if there are not enough words to make 3 consecutive words for the last phrase, then that line is skipped
 * 6. Cucumber is used as tool for BDD and Maven as build tool
 * 7. Run time exception with proper message is thrown if there occurs any exception scenarios
 * 8. IO and core logic are loosely coupled. IO wired via Dependency Injection and Service class uses Factory
 ***/
public class PatternCounterRunner {

	private static PatternCounterService patternCounterService;

	public static void main(String[] args) {

		/*inject Keyboard and console to IO runner*/
		IORunner io = new IORunner(new KeyBoardInput(), new ConsoleOutput());
		String inputs[] = io.getUserInputs();
		patternCounterService = new PatternCounterServiceImpl();
		Map<String, Integer> result = null;

		/*Service call to find and return the distinct pattern*/
		try {
			result = patternCounterService.findPatternFromFile(inputs[0], inputs[1]);
		} catch (Exception e) {
			System.err.println("Run time exception occured :" + e);
		}

		io.printResult(result);

	}

}
