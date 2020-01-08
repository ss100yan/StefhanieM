package com.revature.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.revature.util.Calculator;
import com.revature.util.CalculatorImpl;

/*
 * TestNG (NG standing for "Next Generation") is a testing tool that can
 * be used to drive both unit and frontend tests (when used with
 * Selenium). It is a superset of JUnit and allows for more customization
 * of our test suites. For example, there are more annotations which allow
 * you to set up and tear down your test bed with more precision.
 */
public class CalculatorTest {

	//Here are our TestNG annotations:
	
	/*
	 * In TestNG, we have the ability to create test suites which are
	 * composed of several different packages/classes. This method
	 * will be executed before the suite of tests is run.
	 */
	
	Calculator add;
	Calculator subtract;
	
//	@BeforeSuite
//	public void beforeSuite() {}
	
	@BeforeClass
	public void beforeClass() {}
	
	/*
	 * This method will be executed before each individual test method:
	 */
	
	@BeforeMethod
	public void beforeMethod() {
//		add = (int x, int y) -> {return x + y;};
//		subtract = (int x, int y) -> {return x - y;};
	}
	
	/*
	 * In TestNG, you can also create custom groups of tests (even within
	 * a suite). This method will be run before the groups you specify.
	 */
	
//	@BeforeGroups
//	public void beforeGroups() {}
	
	@Test
	public void testAddition() {
//		Assert.assertEquals(CalculatorImpl.doMath(add, 3, 4), 7);
	}
	
	@Test
	public void testSubtraction() {
//		Assert.assertEquals(CalculatorImpl.doMath(subtract, 8, 3), 5);
	}
	
	/*
	 * This is how we disable a test:
	 */
	@Test(enabled=false)
	public void disabledTest() {}
	
//	@AfterGroups
//	public void afterGroups() {}
	
	@AfterMethod
	public void afterMethod() {}
	
	@AfterClass
	public void afterClass() {}
	
//	@AfterSuite
//	public void afterSuite() {}
}
