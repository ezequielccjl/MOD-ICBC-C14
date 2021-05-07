package testRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitionsBack"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:resources/reports/report.html"},
		monochrome = true,
		strict = true,
		dryRun = false)

public class testRunnerBack {
		
}
