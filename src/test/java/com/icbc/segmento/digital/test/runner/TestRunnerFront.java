package com.icbc.segmento.digital.test.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.icbc.segmento.digital.front.pom.BasePage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/front"},
		glue = {"com.icbc.segmento.digital.front.step"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/front/cucumber-reports.json"},
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = {""})

public class TestRunnerFront {
	
	@AfterClass
	public static void cleanDriver() {
		BasePage.closeBrowser();
	}
	
}
