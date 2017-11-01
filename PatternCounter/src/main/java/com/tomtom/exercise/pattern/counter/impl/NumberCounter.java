package com.tomtom.exercise.pattern.counter.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tomtom.exercise.pattern.counter.IPatternCounter;
import com.tomtom.exercise.utils.PatternCounterUtils;

/**
 * Number counter service that has the logic to split the input string, 
 * identify unique numbers and gives the count of distinct numbers
 * <br>
 * Limitations: Decimal numbers are counted as string
 *
 */
public class NumberCounter implements IPatternCounter {
	private static final Integer DIGIT_NBR = 2;

	@Override
	public Map<String, Integer> getCount(String file, String fileName) {
		Map<String, Integer> resultMap = new LinkedHashMap<>();
		String[] data = PatternCounterUtils.convertStringToArray(file);
		if (data != null) {
			String k1 = PatternCounterUtils.PROGRAM_NAME + " " + fileName + " " + DIGIT_NBR;
			resultMap.put(k1, null);
			for (int i = 0; i < data.length; i++) {
				if (!PatternCounterUtils.isNumeric(data[i])) {
					continue;
				} else {

					if (resultMap.get(data[i]) != null) {
						int count = resultMap.get(data[i]) + 1;
						resultMap.put(data[i], count);

					} else {
						resultMap.put(data[i], 1);
					}

				}

			}

		}

		return resultMap;
	}

}
