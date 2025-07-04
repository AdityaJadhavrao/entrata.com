package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/resources/cucumberFeatures",
        glue = {"stepDefinitions"},
        plugin = {"pretty"},
        tags="@Regression"
)
public class Runner {
}
