package com.revature.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.revature.pageobjectmodels.FindFlight;
import com.revature.pageobjectmodels.MercuryHome;

public class MercuryToursLogin {

	public static WebDriver driver;
	public final String URL = "http://newtours.demoaut.com";
	
	//Setting up our test bed by choosing an implementation of our
	//WebDriver interface
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new EdgeDriver();
//		driver = new FirefoxDriver();
//		driver = new OperaDriver();
//		driver = new InternetExplorerDriver();
//		driver = new SafariDriver();
		//Navigate to the URL specified.
		driver.get(URL);
	}
	
	@Test(enabled=false)
	public void login() {
		MercuryHome mh = new MercuryHome(driver);
		FindFlight ff = new FindFlight();
		mh.loginToMercuryTours("bobbert", "bobbert");
		Assert.assertEquals(driver.getTitle(), ff.title);
		mh.signOff.click();
	}
	
	@Test(dependsOnMethods= {"login"}, enabled=false)
	public void crudeLogin() {
		MercuryHome mh = new MercuryHome(driver);
		FindFlight ff = new FindFlight();
		//You can use your driver to directly grab WebElements.
		driver.findElement(By.name("userName")).sendKeys("bobbert");
		driver.findElement(By.name("password")).sendKeys("bobbert");
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getTitle(), "Sign-on: Mercury Tours");
		mh.signOff.click();
	}
	
	/*
	 * We can specify which data provider we would like to use to feed
	 * data into this test using the "dataProvider" attribute.
	 */
	@Test(dataProvider="multiLogin")
	
	/*
	 * This specifies that we would like to pass the "username" and
	 * "password" parameters into this method from a data provider.
	 */
	@Parameters({"username", "password"})
	public void dataDrivenLogin(String username, String password) {
		MercuryHome mh = new MercuryHome(driver);
		FindFlight ff = new FindFlight();
		mh.loginToMercuryTours(username, password);
		Assert.assertEquals(driver.getTitle(), ff.title);
		mh.signOff.click();
	}
	
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Quit the driver, closing all associated windows.
		driver.quit();
	}
	
	/*
	 * TestNG also provides a way of running data-driven tests. We can
	 * take advantage of this by using the @DataProvider annotation.
	 * A data provider returns a two-dimensional array of data that is
	 * then passed to a @Test.
	 */
	@DataProvider(name="multiLogin")
	public Object[][] multiLoginDataProvider(){
		Object[][] credentials = new Object[][] {
			{"bobbert", "bobbert"},
			{"tropicana", "tropicana"},
			{"goodbye", "hello"},
			{"dogbert", "dogbert"}
		};
		
		return credentials;
	}
}
