package com.tomtom.exercise.service;

import java.util.Map;


public interface PatternCounterService {

	Map<String, Integer> findPatternFromFile(String file, String patternType) throws Exception;

}
