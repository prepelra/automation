package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Web elements in the the Aodocs Home Page
 *
 */
public class ContactPage {

	protected WebDriver driver;

	/* First Name field */
	private By firstNameField = By.name("firstname");

	/* Second Name field */
	private By lastNameField = By.name("lastname");

	/* Email field */
	private By emailField = By.name("email");

	/* Company Name field */
	private By companyNameField = By.name("company");

	/* Company size dropwdown list */
	private By companySizeDropDown = By.name("company_size__c");
	
	/*First Name error message*/
	
	private By firstNameError = By.cssSelector(".hs_firstname .hs-error-msg");
	
	/*Last Name error message*/
	
	private By lastNameError = By.cssSelector(".hs_lastname .hs-error-msg");
	
	/*Mail error message*/
	
	private By mailError = By.cssSelector(".hs_email .hs-error-msg");
	
	/*Company Name error message*/
	
	private By companyNameError = By.cssSelector(".hs_company .hs-error-msg");
		
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}

	public By getfirstNameField() {
		return firstNameField;
	}

	public By getLastNameFieldd() {
		return lastNameField;
	}

	public By getEmailField() {
		return emailField;
	}

	public By getCompanyName() {
		return companyNameField;
	}

	public By getCompanySizeDropDown() {
		return companySizeDropDown;
	}
	
	public By getFirstNameError() {
		return firstNameError;
	}
	
	public By getLastNameError() {
		return lastNameError;
	}
	
	public By getMailError() {
		return mailError;
	}
	
	public By getCompanyNameError() {
		return companyNameError;
	}
	

}
