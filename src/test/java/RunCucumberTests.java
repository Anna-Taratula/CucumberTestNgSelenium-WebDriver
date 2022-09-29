import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/cucumber/",
        glue = {"pages", "steps"},
        plugin = {"pretty"}
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
