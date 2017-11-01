package com.tomtom.exercise.io.runner;

import java.util.Map;

import com.tomtom.exercise.io.IStandardInput;
import com.tomtom.exercise.io.IStandardOutput;

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

	public String[] getUserInputs() {
		if (this.standardInput != null) {
			return this.standardInput.getUserInputs();
		} else {
			return new String[2];
		}
	}

	public void printResult(Map<String, Integer> result) {
		if (this.standardOutput != null) {
			this.standardOutput.printOutput(result);
		}

	}

}
