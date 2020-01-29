package com.revature.pageobjectmodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/*
 * When working with Selenium, we create what we refer to as a "Page
 * Object Model" (POM) for each web page we would like to write
 * automated scripts for. A POM serves as a repository of all of the
 * web elements that are present on a web page. This POM design
 * pattern makes it easier to test a web page as we don't have to
 * freshly grab a web element each time we want to access it.
 */
public class MercuryHome {

	//This is the title of the Mercury Tours home page:
	public final String title = "Welcome: Mercury Tours";
	
	/*
	 * Now let us create a repository of the web elements from the page
	 * that we'd like to create automated scripts for. In Selenium,
	 * there is a WebElement interface which we can use to grab web
	 * elements.
	 * 
	 * We can grab web elements in 8 different ways using Selenium. We
	 * can grab them by:
	 * 
	 * name
	 * id
	 * xpath:
	 *      *Xpath (XML Path Language) is a query language that is used
	 *      to select nodes in an XML document. It provides a lot of
	 *      power in terms of how we are able to select nodes.
	 * linkText
	 * partialLinkText
	 * tagName
	 * cssSelector
	 * className
	 */
	
	@FindBy(how=How.NAME, using="userName")
	public WebElement usernameBox;
	@FindBy(name="password")
	public WebElement paswordBox;
	@FindBy(name="login")
	public WebElement loginButton;
	@FindBy(xpath="//a[text()='SIGN-OFF']")
	public WebElement signOff;
	@FindBy(xpath="//a[text()='Home']")
	public WebElement homeLink;
	
	public MercuryHome(WebDriver driver) {
		
		/*
		 * In Selenium, we can use what is known as the PageFactory.
		 * It grabs all of the WebElements in this class that are
		 * annotated with @FindBy whenever we create an instance
		 * of this class.
		 * 
		 * The initElements method here takes a webdriver and uses
		 * that driver to initialize the WebElements annotated with
		 * @FindBy for each instance of this class.
		 */
		
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * A Page Object Model should also also include some methods which
	 * we can use to interact with our web page. Let's create a simple
	 * login method.
	 */
	
	public void loginToMercuryTours(String username, String password) {
		//The sendKeys method simulates typing input into a box, text
		//area, etc.
		this.usernameBox.sendKeys(username);
		this.paswordBox.sendKeys(password);
		//The click method simulates a click on this web element.
		this.loginButton.click();
	}
}
