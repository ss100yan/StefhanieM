package com.revature.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*
 * In our feature file, we specified some tags in order to create
 * "groups". In order to specify which tags to run, we have the 
 * following syntax:
 * 
 * Excluding tags: tags={"not @tagname", .., ..}
 * Running tests that have all of the indicated tags specifically:
 * tags={"@tag1", "@tag2", .., ..}
 * Running tests that have either of the listed tags:
 * tags={"@tag1,@tag2,..,.."} 
 */
@RunWith(Cucumber.class)
@CucumberOptions(features= {"features/taggedcucumber.feature"},
				tags= {"not @smoke", "@stuff"},
				glue= {"com.revature.cucumber.GlueCode"}
		)
public class CucumberTestRunner {

	
}
