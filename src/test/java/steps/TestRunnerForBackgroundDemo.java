package steps;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/features/BackgroundDemo",
        glue = {"StepsForBackground"},
        plugin = {"json:target/cucumber.json"}
)

public class TestRunnerForBackgroundDemo {
}
