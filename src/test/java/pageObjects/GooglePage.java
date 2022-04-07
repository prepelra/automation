package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Web elements in the the Google Page
 *
 */
public class GooglePage {

	protected WebDriver driver;

	/* Search field */
	private By searchField = By.name("q");
	/* Aodocs link in Google results */
	private By aodocsLiknk = By.xpath("//cite[contains(.,\'https://www.aodocs.com\')]");
	/* Accept Cookies Bttn */
	private By acceptCookiesBttn = By.id("L2AGLb");
		
	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	public By getSearchField() {
		return searchField;
	}

	public By getAodocsLink() {
		return aodocsLiknk;
	}
	
	public By getAcceptCookiesBttn() {
		return acceptCookiesBttn;
		
	}

}
