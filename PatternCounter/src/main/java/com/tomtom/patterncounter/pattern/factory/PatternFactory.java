package com.tomtom.patterncounter.pattern.factory;

import com.tomtom.patterncounter.pattern.counter.IPatternCounter;
import com.tomtom.patterncounter.pattern.counter.impl.NumberCounter;
import com.tomtom.patterncounter.pattern.counter.impl.PhraseCounter;
import com.tomtom.patterncounter.pattern.counter.impl.WordCounter;
import com.tomtom.patterncounter.utils.PatternCounterUtils;

/**
 * Factory class that can return an instance of {@linkplain IPatternCounter}
 * with respect to type of the pattern matcher
 *
 */
public class PatternFactory {

	/**
	 * Return an instance of {@linkplain IPatternCounter}
	 * @param type - type of pattern counter
	 * @return {@linkplain IPatternCounter} instance
	 * <br>
	 * Presently supported pattern counters with type are:
	 * <br>
	 * type = 1 => {@link WordCounter}<br>
	 * type = 2 => {@link NumberCounter}<br>
	 * type = 3 => {@link PhraseCounter}<br>
	 * 
	 */
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
