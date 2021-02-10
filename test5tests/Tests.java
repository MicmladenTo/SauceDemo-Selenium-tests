package test5tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTests {
	
	@Test (priority = 0)
	public void logInTest() throws InterruptedException {

		loginPage.inputUsername("standard_user");
		loginPage.inputPassword("secret_sauce");
		loginPage.clickLoginButton();
		Thread.sleep(2000);
		Assert.assertEquals(productPage.getProductsHeaderText(), "Products");
	}
	
	@Test (priority = 3)
	public void orderingTests() throws InterruptedException {
		
		logInTest();
		
		productPage.addFirstProductToCart();
		productPage.goToShoppingCart();
		
		Thread.sleep(2000);
		Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
		Assert.assertEquals(cartPage.getProductQuantity(), "1");
		Thread.sleep(2000);
		
		cartPage.checkOut();
		Thread.sleep(2000);
		customerInfoPage.fillIn("Mladen", "Tomic", "21000");
		customerInfoPage.submit();
		
		Thread.sleep(2000);
		Assert.assertEquals(checkoutPage.finishButtonText(), "FINISH");
		checkoutPage.finalizePurchase();
		
		Thread.sleep(2000);
		
		Assert.assertEquals(confirmationPage.orderConfirmationText(), confirmationPage.getAssertText());
	}	
}
