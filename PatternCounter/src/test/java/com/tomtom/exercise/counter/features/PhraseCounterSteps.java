package com.tomtom.exercise.counter.features;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import com.tomtom.exercise.pattern.counter.IPatternCounter;
import com.tomtom.exercise.pattern.counter.impl.PhraseCounter;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhraseCounterSteps {

	IPatternCounter patterncounter;
	Map<String, Integer> result = null;
	Map<String, Integer> expected = null;

	@Given("^phrase counter service is initialized$")
	public void phrease_counter_service_is_initialized() throws Throwable {
		this.patterncounter = new PhraseCounter();
		System.out.println("Pattern counter is initialized");
	}

	@When("^an input text of \"([^\"]*)\" and \"([^\"]*)\" is passed as input parameters$")
	public void an_input_text_of_and_is_passed_as_input_parameters(String arg1, String arg2) throws Throwable {
		System.out.println("text and file name is passed");
		result = patterncounter.getCount(arg1, arg2);
	}

	@Then("^check the result is as expected$")
	public void check_the_result_is_as_expected(DataTable arg1) throws Throwable {
		Map<String, Integer> expected = arg1.asMap(String.class, Integer.class);
		assertEquals(expected, result);
		System.out.println("Result is as expected. Test success");
	}

	@Then("^check the result is empty$")
	public void check_the_result_is_empty() throws Throwable {
		assertEquals(0, result.size());
		System.out.println("Empty result is returned as expected");
	}

	@Then("^check the result is below$")
	public void check_the_result_is_below(DataTable arg1) throws Throwable {
		this.expected = arg1.asMap(String.class, Integer.class);
		assertEquals(expected, result);
		System.out.println("The result is as expected");
	}

	@Then("^check the size is (\\d+)$")
	public void check_the_size_is(int arg1) throws Throwable {
		assertEquals(result.size(), arg1);
		System.out.println("Result size is as expected");
	}

	@Given("^make sure the initial result is null$")
	public void make_sure_the_initial_result_is_null() throws Throwable {
		this.result = null;
	}

	@Then("^check the size is (\\d+) and last two words are skipped$")
	public void check_the_size_is_and_last_two_words_are_skipped(int arg1) throws Throwable {
		assertEquals(this.result.size(), arg1);
		System.out.println("The result size is 2 as expected");
	}

}
