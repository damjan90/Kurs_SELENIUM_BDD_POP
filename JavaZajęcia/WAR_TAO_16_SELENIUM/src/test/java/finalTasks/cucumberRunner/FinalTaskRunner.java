package finalTasks.cucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/featuresFinalTask", glue = "finalTasks", plugin = {"pretty","html:out"})
public class FinalTaskRunner {


}