package com.tomtom.exercise.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PatternCounterUtils {

	public static final String PROGRAM_NAME = "PatternCounter";

	public static String[] getContentsFromFile(String filePath) throws Exception {
		if (filePath == null) {
			throw new Exception("Exception Occured while reading the file. File name not speicfied");
		} else {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			try {
				StringBuilder sb = new StringBuilder();

				File file = new File(filePath);
				Scanner scanner = new Scanner(file);

				while (scanner.hasNextLine()) {
					sb.append(scanner.nextLine());
				}
				if (scanner != null) {
					scanner.close();
				}
				String[] response = new String[2];
				response[0] = sb.toString();
				response[1] = file.getName();
				return response;
			} catch (IOException e) {
				throw new Exception("Exception Occured while reading the file." + e.getMessage());
			} finally {
				br.close();
			}

		}

	}

	public static boolean isNumeric(String string) {
		return string.chars().allMatch(Character::isDigit);
	}

	public static String[] convertStringToArray(String str) {
		String[] stringArr = null;
		if (str == null || str.length() > 0) {
			stringArr = str.split(" ");
			if (stringArr.length < 3) {
				stringArr = null;
			}
		}
		return stringArr;

	}

}
