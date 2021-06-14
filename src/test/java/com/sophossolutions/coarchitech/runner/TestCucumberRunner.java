package com.sophossolutions.coarchitech.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.sophossolutions.coarchitech", monochrome = true, tags = "@MuchasCanciones")
public class TestCucumberRunner {

}
