package com.tomtom.patterncounter.service.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import com.tomtom.patterncounter.service.PatternCounterService;
import com.tomtom.patterncounter.service.impl.PatternCounterServiceImpl;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceNumberCountSpec {

	PatternCounterService service;
	Map<String, Integer> output = null;

	@Given("^check service class is wired$")
	public void service_class_is_wired() {
		this.service = new PatternCounterServiceImpl();
		System.out.println("Service class is wired");
		assertNotNull(service);
	}

	@When("^user Enters file name as \"([^\"]*)\" and \"([^\"]*)\" as input pattern type$")
	public void user_Enters_file_name_as_and_as_input_pattern_type(String arg1, String arg2) throws Throwable {
		System.out.println("User entered the file name and pattern counter");
		output = service.findPatternFromFile(arg1, arg2);
	}

	@Then("^expect the following number count results$")
	public void expect_the_following_number_count_results(DataTable arg1) throws Throwable {
		Map<String, Integer> expected = arg1.asMap(String.class, Integer.class);
		assertEquals(expected, output);
		System.out.println("Service Returned result successfully");
	}

	@Then("^expect empty output$")
	public void expect_empty_output() throws Throwable {
		assertEquals(0, output.size());
		System.out.println("Service Returned empty as expected");
	}

}
