package com.revature.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.Calculator;

/*
 * JUnit is a testing framework for Java that allows us to unit test our
 * code. Note that a unit test entails testing a unit of software without
 * its dependencies. Unit testing is the most micro level of testing, and
 * applications typically have more unit tests than integration tests and
 * system tests.
 * 
 * JUnit is annotation-driven, so we need only annotate our methods in order
 * to write tests and set up test beds.
 */
public class CalculatorTest {

	public static Calculator c;
	
	/*
	 * The BeforeClass annotation denotes that this method will run once
	 * before all of the other methods in this class. In other words, you
	 * are setting up your test bed.
	 */
	@BeforeClass
	public static void setUp() {
		c = new Calculator();
	}
	
	/*
	 * The Before annotation specifies that this method will run once before
	 * each method that is annotated with @Test.
	 */
	@Before
	public void beforeEach() {
		
	}
	
	/*
	 * The Test annotation specifies that this method is actually a test.
	 * If you don't want a test to run, use the @Ignore annotation.
	 */
	@Ignore
	@Test
	public void aTest() {
		
	}
	
	/*
	 * In order to test functionality, I must use JUnit Assertions. There
	 * are several assertions available to us:
	 * 
	 * assertNotNull
	 * assertNull
	 * assertEquals
	 * assertNotEquals
	 */
	@Test
	public void testAddition() {
		Assert.assertNotNull(c);
		Assert.assertEquals(4, c.add(2, 2));
		Assert.assertNotEquals(5, c.add(2, 4));
	}
	
	/*
	 * The After annotation specifies that this method will run once after
	 * each method that is annotated with @Test.
	 */
	@After
	public void afterEach() {
	}
	
	/*
	 * The AfterClass annotation denotes that this method will run once
	 * after all of the other methods in this class. In other words, you
	 * are tearing down your test bed (e.g. closing streams and connections, etc.).
	 */
	@AfterClass
	public static void tearDown() {
		
	}
}
