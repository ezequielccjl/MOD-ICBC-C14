package com.icbc.segmento.digital.front.step;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/front"},
		glue = {"com.icbc.segmento.digital/front/step"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:\", \"json:target/front/cucumber-reports.json"},
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = {"@Transferencia-SinAgregarDestinatario"})

public class TestRunnerFront {
	
	/*
	@AfterClass
	public static void cleanDriver() {
		BasePage.closeBrowser();
	}
	*/
	
}
