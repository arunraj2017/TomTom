
package com.tomtom.patterncounter.service.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.tomtom.patterncounter.service.PatternCounterService;
import com.tomtom.patterncounter.service.impl.PatternCounterServiceImpl;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceWordCountSpec {

	PatternCounterService service;
	Map<String, Integer> output = null;

	@Given("^service class is wired$")
	public void service_class_is_wired() {
		this.service = new PatternCounterServiceImpl();
		System.out.println("Service class is wired");
		assertNotNull(service);
	}

	@When("^user enters \"([^\"]*)\" as filename and \"([^\"]*)\" as pattern type$")
	public void user_enters_as_filename_and_as_pattern_type(String arg1, String arg2) throws Throwable {
		System.out.println("User entered file name and type of pattern counter");
		output = service.findPatternFromFile(arg1, arg2);
	}

	@Then("^expect the following results$")
	public void expect_the_following_results(DataTable arg1) throws Throwable {
		Map<String, Integer> expected = arg1.asMap(String.class, Integer.class);
		assertEquals(expected, output);
		System.out.println("Service Returned result successfully");

	}

	@Then("^expect empty result$")
	public void expect_empty_result() throws Throwable {
		assertTrue(output.isEmpty());
		System.out.println("Service Returned empty map as expected");
	}

}
