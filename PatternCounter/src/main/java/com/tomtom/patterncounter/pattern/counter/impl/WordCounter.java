package com.tomtom.patterncounter.pattern.counter.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tomtom.patterncounter.pattern.counter.IPatternCounter;
import com.tomtom.patterncounter.utils.PatternCounterUtils;

public class WordCounter implements IPatternCounter {
	private static final Integer DIGIT_NBR = 1;

	@Override
	public Map<String, Integer> getCount(String file, String fileName) {
		return getWordCount(file, fileName);
	}

	private Map<String, Integer> getWordCount(String file, String fileName) {
		Map<String, Integer> resultMap = new LinkedHashMap<>();
		String[] data = PatternCounterUtils.convertStringToArray(file);
		if (data != null) {
			String k1 = PatternCounterUtils.PROGRAM_NAME + " " + fileName + " " + DIGIT_NBR;
			resultMap.put(k1, null);
			for (int i = 0; i < data.length; i++) {
				if (PatternCounterUtils.isNumeric(data[i])) {
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
