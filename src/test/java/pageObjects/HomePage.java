package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Web elements in the the Aodocs Home Page
 *
 */

public class HomePage {

	protected WebDriver driver;

	/* Request Demo bttn */
	private By requestDemoBttn = By.linkText("Request a demo");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public By getRequestDemoBttn() {
		return requestDemoBttn;
	}

}


