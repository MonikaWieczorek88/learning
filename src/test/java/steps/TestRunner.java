package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/FeatureWithTags",
        glue = {"steps"},
        tags = "@smoke or @regression",
        plugin = {"pretty"}
)

public class TestRunner {


}

