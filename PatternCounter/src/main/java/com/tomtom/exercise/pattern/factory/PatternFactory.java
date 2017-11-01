package com.tomtom.exercise.pattern.factory;

import com.tomtom.exercise.pattern.counter.IPatternCounter;
import com.tomtom.exercise.pattern.counter.impl.NumberCounter;
import com.tomtom.exercise.pattern.counter.impl.PhraseCounter;
import com.tomtom.exercise.pattern.counter.impl.WordCounter;
import com.tomtom.exercise.utils.PatternCounterUtils;

public class PatternFactory {

	public IPatternCounter getPatternCounter(String type) {
		IPatternCounter patternCounter = null;
		if ((type == null) && PatternCounterUtils.isNumeric(type)) {
			return patternCounter;
		} else {
			type = type.trim();
			if (type.equals("1")) {
				patternCounter = new WordCounter();
			} else if (type.equals("2")) {
				patternCounter = new NumberCounter();
			} else if (type.equals("3")) {
				patternCounter = new PhraseCounter();
			}
		}
		return patternCounter;
	}
}
