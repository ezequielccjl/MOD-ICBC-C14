package com.icbc.segmento.digital.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/mobile"},
		glue = {"com.icbc.segmento.digital.front.mobile", "com.icbc.segmento.digital.front.hooks"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:\", \"json:target/front/cucumber-reports.json"},
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = {"@LoginNuevo-Mobile-04"})

public class TestRunnerMobile {

}
