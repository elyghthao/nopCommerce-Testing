package testRunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//where folder holding the features are located, and glue doesn't have to be anything
@CucumberOptions(features = {"./features/nopcommerceFeatures"}, glue = "")
public class TestRunner {

}
