package com.tomtom.patterncounter.pattern.counter.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tomtom.patterncounter.pattern.counter.IPatternCounter;
import com.tomtom.patterncounter.utils.PatternCounterUtils;

/**
 * Phrase Counter can get distinct count of combination of 3 consecutive words
 * <br>
 * Note: If the word count is less than 3 then that line is omitted 
 */
public class PhraseCounter implements IPatternCounter {
	private static final Integer DIGIT_NBR = 3;

	@Override
	public Map<String, Integer> getCount(String file, String fileName) {
		Map<String, Integer> resultMap = new LinkedHashMap<>();
		String[] data = PatternCounterUtils.convertStringToArray(file);
		if (data != null) {
			String k1 = PatternCounterUtils.PROGRAM_NAME + " " + fileName + " " + DIGIT_NBR;
			resultMap.put(k1, null);
			for (int i = 0; i < data.length - 2; i++) {
				if (isPhrasePossible(data, i)) {
					String tempString = getKeyForPhrase(data, i);
					if (resultMap.get(tempString) != null) {
						int count = resultMap.get(tempString) + 1;
						resultMap.put(tempString, count);
					} else {
						resultMap.put(tempString, 1);
					}
				}
			}

		}
		return resultMap;
	}

	private String getKeyForPhrase(String[] data, int i) {
		return data[i] + " " + data[i + 1] + " " + data[i + 2];
	}

	private boolean isPhrasePossible(String[] data, int start) {
		return (data.length >= start + 2);
	}

}
