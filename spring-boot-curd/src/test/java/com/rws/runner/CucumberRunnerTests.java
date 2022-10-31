package com.rws.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/SpringBootCucumberTest.feature"}, plugin = {"pretty",
        "json:target/cucumber-report.json"}, glue = {"com.rws.definitions"}, tags = "@SendProductDetails")
public class CucumberRunnerTests {
}



