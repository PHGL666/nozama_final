package TestRunner;

import org.junit.runner.RunWith;

import StepDefinition.CLI001N;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue="StepDefinition"
		)
public class Runner {

}

