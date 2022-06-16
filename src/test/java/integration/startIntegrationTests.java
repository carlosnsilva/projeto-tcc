package integration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = {"pretty", "junit:src/test/resources/report/reporte-cucumber-test.xml"})
public class startIntegrationTests {
}
