package com.tomtom.patterncounter.io.runner;

import java.util.Map;

import com.tomtom.patterncounter.io.IStandardInput;
import com.tomtom.patterncounter.io.IStandardOutput;


/**
 * IORunner<br>
 * IORunner can take a standard input or standard output as constructor and execute it
 *
 */
public class IORunner {

	IStandardInput standardInput;
	IStandardOutput standardOutput;

	public IORunner(IStandardInput standardInput) {
		this.standardInput = standardInput;
	}

	public IORunner(IStandardOutput standardOutput) {
		this.standardOutput = standardOutput;
	}

	public IORunner(IStandardInput standardInput, IStandardOutput standardOutput) {
		this.standardInput = standardInput;
		this.standardOutput = standardOutput;
	}

	/**
	 * function to get the user inputs with given standard input specified
	 * @return String[] user inputs
	 */
	public String[] getUserInputs() {
		if (this.standardInput != null) {
			return this.standardInput.getUserInputs();
		} else {
			return new String[2];
		}
	}

	/**
	 * function to iterate over the given map and prints it in standard output specified
	 * @param result Map&lt;String,Integer&gt;- The unique item as key and count as number
	 */
	public void printResult(Map<String, Integer> result) {
		if (this.standardOutput != null) {
			this.standardOutput.printOutput(result);
		}

	}

}
