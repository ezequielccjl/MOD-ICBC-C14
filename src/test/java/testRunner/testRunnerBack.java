package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepDefinitions"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:resources/reports/report.html"},
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = {"@Post"})

public class testRunnerBack {
	
}
