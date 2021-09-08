package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/HooksDemo",
        glue = {"StepsForHooks"},
        plugin = {"pretty", "junit:target/JUnitReports/report.xml",
        "json:target/JSONReports/report.json",
        "html:target/HtmlReports"},
        monochrome = true
)

public class TestRunnerForHooks {


}


