package com.tomtom.patterncounter.io.impl;

import java.util.Scanner;

import com.tomtom.patterncounter.io.IStandardInput;
/**
 * The standard input that supports the keyboard
 * */

public class KeyBoardInput implements IStandardInput {

	@Override
	public String[] getUserInputs() {
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
