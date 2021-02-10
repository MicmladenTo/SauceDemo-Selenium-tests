package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
	WebDriver driver;
	WebElement productsHeaderText;
	WebElement firstProduct;
	WebElement shoppingCart;
	
	

	public WebElement getShoppingCart() {
		return driver.findElement(By.id("shopping_cart_container")); 
	}

	public String getProductsHeaderText() {
		return driver.findElement(By.className("product_label")).getText();
	}
	
	public WebElement getFirstProduct() {
		return driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
	}
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addFirstProductToCart() {
		getFirstProduct().click();
	}
	
	public void goToShoppingCart() {
		getShoppingCart().click();
	}
	
}
