package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ContactPage;
import pageObjects.GooglePage;
import pageObjects.HomePage;
import selenium.driver.Browser;
import selenium.driver.WebDriverUtility;



public class RequestDemofFile {

	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void Hooks() {

		/*Browser is read from Maven parameter */
	    String browserMaven = System.getProperty("browser");
		driver = WebDriverUtility.getWebDriver(Browser.valueOf(browserMaven));
		
		//driver = WebDriverUtility.getWebDriver(Browser.CHROME);
		
		wait = new WebDriverWait(driver, 30);

	}

	@Given("I search {string} on Google")
	public void SearchingOnGoogle(String searchString)

	{

		GooglePage googlePage = new GooglePage(driver);
		
		driver.get("https://google.com");
		driver.findElement(googlePage.getAcceptCookiesBttn()).click();
		driver.findElement(googlePage.getSearchField()).sendKeys(searchString);
		driver.findElement(googlePage.getSearchField()).sendKeys(Keys.ENTER);
		

	}

	@And("I press on the Aodocs link")
	public void PressonAodocsLink()

	{
		GooglePage googlePage = new GooglePage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(googlePage.getAodocsLink()));
		driver.findElement(googlePage.getAodocsLink()).click();

	}

	@Then("Aodocs Home Page is opened")
	public void HomePageIsOpened()

	{

		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getRequestDemoBttn()));

	}

	@When("I click button Request a Demo")
	public void ClickRequestDemoBttn()

	{
		HomePage homePage = new HomePage(driver);
		driver.findElement(homePage.getRequestDemoBttn()).click();

	}

	@And("the Contact Form is opened")
	public void ContactFormIsOpened()

	{

		ContactPage contactPage = new ContactPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactPage.getfirstNameField()));

	}

	@And("^I fill First Name with \"([^\"]*)\"$")
	public void i_fill_first_name_with_something(String firstname) throws Throwable {
		ContactPage contactPage = new ContactPage(driver);
		driver.findElement(contactPage.getfirstNameField()).sendKeys(firstname);
	}

	@And("^I fill Last Name with \"([^\"]*)\"$")
	public void i_fill_last_name_with_something(String lastname) throws Throwable {
		ContactPage contactPage = new ContactPage(driver);
		driver.findElement(contactPage.getLastNameFieldd()).sendKeys(lastname);
	}

	@And("^I fill Email with \"([^\"]*)\"$")
	public void i_fill_email_with_something(String email) throws Throwable {
		ContactPage contactPage = new ContactPage(driver);
		driver.findElement(contactPage.getEmailField()).sendKeys(email);
	}

	@And("^I fill Company Name with \"([^\"]*)\"$")
	public void i_fill_company_name_with_something(String companyname) throws Throwable {
		ContactPage contactPage = new ContactPage(driver);
		driver.findElement(contactPage.getCompanyName()).sendKeys(companyname);
	}

	@And("^I select \"([^\"]*)\" from Company Size$")
	public void i_select_something_from_company_size(String companysize) throws Throwable {
		ContactPage contactPage = new ContactPage(driver);
		driver.findElement(contactPage.getCompanySizeDropDown())
				.findElement(By.xpath("//option[. = '" + companysize + "']")).click();

	}

	@Then("^\"([^\"]*)\" should appear under LastName$")
	public void something_should_under_lastname(String errorMessageLastname) throws Throwable {

		ContactPage contactPage = new ContactPage(driver);
		String actualString = driver.findElement(contactPage.getLastNameError()).getText();
		assertTrue(actualString.contains(errorMessageLastname));

	}

	@And("^\"([^\"]*)\" should appear under Mail$")
	public void something_should_appear_under_mail(String errorMessageMail) throws Throwable {

		ContactPage contactPage = new ContactPage(driver);
		String actualString = driver.findElement(contactPage.getMailError()).getText();
		assertTrue(actualString.contains(errorMessageMail));
	
	}


	@And("^\"([^\"]*)\" should appear under CompanyName$")
	public void something_should_appear_under_companyname(String errorCompanyName) throws Throwable {

		ContactPage contactPage = new ContactPage(driver);
		String actualString = driver.findElement(contactPage.getCompanyNameError()).getText();
		assertTrue(actualString.contains(errorCompanyName));
	}
	
	 @After
	    public void tearDown() {
	        driver.quit();
	    }

}
