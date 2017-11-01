package com.tomtom.exercise.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"com.tomtom.exercise"} ,features = { "src/test/resources/features"})
public class CucumberRunner {

}
