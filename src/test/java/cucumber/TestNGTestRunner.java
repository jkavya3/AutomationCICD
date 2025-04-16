package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Cucumber depends on TestNg or Junit to run the feature file but it has all other features inbuilt
@CucumberOptions(features="src/test/java/cucumber",glue="FrameWorkDesign.StepDefinitions",monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
