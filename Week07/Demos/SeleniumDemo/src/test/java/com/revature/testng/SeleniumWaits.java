package com.revature.testng;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.pageobjectmodels.FindFlight;
import com.revature.pageobjectmodels.MercuryHome;

/*
 * When using Selenium to grab web elements from a web page, sometimes
 * these elements will not have been rendered yet, thus causing your
 * tests to fail. In order to ensure that all web elements on the page
 * have been rendered before we attempt to grab them, we can take
 * advantage of Selenium waits. There are three types of waits in
 * Selenium:
 * 
 * Implicit Waits
 * Explicit Waits
 * Fluent Waits
 */
public class SeleniumWaits {

	public static WebDriver driver;
	public final String URL = "http://newtours.demoaut.com";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		
		/*
		 * Let's first work with an implicit wait. An implicit wait
		 * defines a wait time for ALL interactions before Selenium
		 * decides that a web element does not exist.
		 * 
		 * Note that waits slow down your test suites, so you should only use
		 * them if you know you need them.
		 */
		
//		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void login() {
		/*
		 * Now let's explicitly wait for an element to be visible, etc.
		 * We'll use an Explicit Wait to do this!
		 * 
		 * Explicit waits are used on a per element(s) basis.
		 */
		
//		WebDriverWait wait = new WebDriverWait(driver, 2);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
		
		/*
		 * Now let's try a Fluent Wait! Fluent waits are similar to 
		 * Explicit waits except for the fact that we can now change
		 * the default 500ms poll/check time to a custom one of our
		 * choice with the pollingEvery method.
		 */
		
		FluentWait<WebDriver> fwait = new FluentWait<>(driver)
				.withTimeout(Duration.ofMillis(5000))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(NoSuchElementException.class);
		
		fwait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
		
		MercuryHome mh = new MercuryHome(driver);
		FindFlight ff = new FindFlight();
		mh.loginToMercuryTours("tropicana", "tropicana");
		Assert.assertEquals(driver.getTitle(), ff.title);
	}
	
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
