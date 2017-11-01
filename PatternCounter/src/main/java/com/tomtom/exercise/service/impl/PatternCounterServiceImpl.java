package com.tomtom.exercise.service.impl;

import java.util.Map;

import com.tomtom.exercise.pattern.counter.IPatternCounter;
import com.tomtom.exercise.pattern.factory.PatternFactory;
import com.tomtom.exercise.service.PatternCounterService;
import com.tomtom.exercise.utils.PatternCounterUtils;

public class PatternCounterServiceImpl implements PatternCounterService {
	PatternFactory patternFactory = new PatternFactory();
	IPatternCounter patternCounter;

	@Override
	public Map<String, Integer> findPatternFromFile(String file, String patternType) throws Exception {
		Map<String, Integer> output = null;
		if (file == null || patternType == null) {
			return output;
		} else {
			patternCounter = patternFactory.getPatternCounter(patternType);
		}
		String[] values = PatternCounterUtils.getContentsFromFile(file);
		if (patternCounter != null) {
			output = patternCounter.getCount(values[0], values[1]);
		} else {
			throw new Exception("Pattern type entered is null or not a number");
		}

		return output;
	}

}
