package test5tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import test5pages.CartPage;
import test5pages.CheckoutPage;
import test5pages.ConfirmationPage;
import test5pages.CustomerInfoPage;
import test5pages.LoginPage;
import test5pages.ProductPage;

public class BaseTests {
	
	WebDriver driver;
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	CustomerInfoPage customerInfoPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confirmationPage;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		this.productPage = new ProductPage(driver);
		this.cartPage = new CartPage(driver);
		this.customerInfoPage = new CustomerInfoPage(driver);
		this.checkoutPage = new CheckoutPage(driver);
		this.confirmationPage = new ConfirmationPage(driver);
		
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(2000);
	}
	
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		System.out.println("Kraj programa");
	}
	
}
