package com.icbc.segmento.digital.test.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/back"},
		glue = {"com.icbc.segmento.digital.back.step"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/back/cucumber-reports.json"},
		monochrome = true,
		strict = true,
		dryRun = false,
		snippets = SnippetType.CAMELCASE,
		tags = {"@messagingOpMBR"})

public class TestRunnerBack {

}
