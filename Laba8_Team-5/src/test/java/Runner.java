import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "resources"
        ,glue={"src/test/steps"}
    )
    public class Runner {
    }
