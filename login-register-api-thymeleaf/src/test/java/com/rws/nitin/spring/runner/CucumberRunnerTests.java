package com.rws.nitin.spring.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = {"src/test/resources/features"}, glue = {"com.rws.nitin.spring.definations"})
public class CucumberRunnerTests {
}
