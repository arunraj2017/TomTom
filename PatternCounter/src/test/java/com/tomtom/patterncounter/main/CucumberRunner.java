package com.tomtom.patterncounter.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The main Cucumber runner for the test cases
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.tomtom.patterncounter" }, features = { "src/test/resources/features" }, format = {
		"json:target/cucumber-report/cucumber.json" })
public class CucumberRunner {

}
