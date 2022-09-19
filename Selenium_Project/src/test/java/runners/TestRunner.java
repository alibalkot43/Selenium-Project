package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumberHtmlReport",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "pretty"
        },
        features = "classpath:features",
        glue = {"steps"},
        monochrome=true
)

public class TestRunner {
}