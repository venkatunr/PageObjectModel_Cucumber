package runnerpack;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.RetryAcceptance;

import cucumber.api.CucumberOptions;

@ExtendedCucumberOptions(
        jsonReport = "target/1/cucumber.json",    //JSON normal report
        jsonUsageReport = "target/1/cucumber-usage.json", //here 81,82,83 to increase the running the test cases
        usageReport = true,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        overviewChartsReport = true,
        pdfPageSize = "A4 Landscape",
        toPDF = true,
        outputFolder = "target/1",
        retryCount = 0)

@CucumberOptions(tags= {"@Current"},
		features= {"E:\\BDD_Flipkart\\src\\test\\resources\\featurefiles\\multiselection.feature"},
				glue= {"stepdefination"},
				monochrome=true,
				dryRun=false,
						plugin = {
						        "html:target/1", "json:target/1/cucumber.json",
						        "pretty:target/1/cucumber-pretty.txt",
						        "usage:target/1/cucumber-usage.json",
								"junit:target/1/cucumber-results.xml" }
				)
 
@RunWith(ExtendedCucumber.class)
public class Runner_Class {
	public static int retries = 0;

    public Runner_Class() {

    }

    @RetryAcceptance
    public static boolean retryCheck(Throwable e) {
        // Does not allow re-run if error message contains "Configuration failed" phrase
        return !e.getMessage().contains("Configuration failed");
    }
}


