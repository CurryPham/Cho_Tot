package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/choTot/features",
        glue = "choTot.stepDefinitions",
        //dryRun = true,
        monochrome = true,
        plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber_choTot.json"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@TestUI, @TestAPI"})





public class ChoTotTestRunner {
}
