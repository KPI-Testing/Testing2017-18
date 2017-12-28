import cucumber.api.CucumberOptions;

//import cucumber.api.junit.Cucumber;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "resources"
        ,glue={"steps"}
)
    public class StepsRunner {

    }
