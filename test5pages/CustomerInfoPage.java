package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerInfoPage {
	
	WebDriver driver;
	
	WebElement nameInput;
	WebElement lastNameInput;
	WebElement postalCodeInput;
	WebElement continueButton;
	
	
	
	public WebElement getContinueButton() {
		return driver.findElement(By.cssSelector("input[type='submit']"));
		
	}

	public WebElement getNameInput() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getLastNameInput() {
		return driver.findElement(By.id("last-name"));
	}

	public WebElement getPostalCodeInput() {
		return driver.findElement(By.id("postal-code"));
	}


	// konstruktor
	public CustomerInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//funkcije
	public void fillIn(String name, String lastName, String postalCode) {
		getNameInput().sendKeys(name);
		getLastNameInput().sendKeys(lastName);
		getPostalCodeInput().sendKeys(postalCode);
	}
	
	public void submit() {
		getContinueButton().click();
	}
}
