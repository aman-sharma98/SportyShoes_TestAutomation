package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Tests.Baseclass;

public class CompleteOrderandValidatePage {
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;

	//*************************WebElements**********************
	
	@FindBy(linkText="Home")
	WebElement Home;

	@FindBy(css="a[href*='cartadditem?id=107']")
	WebElement AddProduct;

	@FindBy(xpath="//*[contains(text(),'ABC Product')]")
	WebElement ProductName;

	@FindBy(linkText="Checkout Now")
	WebElement Checkoutbutton;

	@FindBy(linkText="Pay via secure Payment Gateway")
	WebElement PaymentLink;

	@FindBy(linkText="Click to complete checkout")
	WebElement CompleteCheckoutLink;
	
	@FindBy(linkText="Order History")
	WebElement OrderHistoryLink;
	
	@FindBy(xpath="//*[contains(text(),'ABC Product, 1 units @134.00 = 134.00')]")
	WebElement ProductNameinOrder;
	
	@FindBy(linkText="Logout")
	WebElement LogoutLink;
	
	
	public CompleteOrderandValidatePage() {
		PageFactory.initElements(driver, this);
	}

	
	public void AddProductandCheckout(String ExpectedProductName) {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Home));
		
		Home.click();
		test.log(LogStatus.PASS, "Clicking on Home", "Successfully clicked on Home");
		
		AddProduct.click();
		test.log(LogStatus.PASS, "Adding Product to cart", "Product Successfully Added to cart");
		
		Assert.assertEquals(ProductName.getText(), ExpectedProductName);
		
		Checkoutbutton.click();
		test.log(LogStatus.PASS, "Clicking Checkout button", "Successfully Clicked Checkout button");
		
		PaymentLink.click();
		test.log(LogStatus.PASS, "Clicking Payment link", "Successfully Clicked Payment link");
		
		CompleteCheckoutLink.click();
		test.log(LogStatus.PASS, "Completing Checkout", "Successfully Completed Checkout");
		
	}
	
	public void ValidateOrder(String ExpectedProductinOrderValue) {
		
		OrderHistoryLink.click();
		Assert.assertEquals(ProductNameinOrder.getText(), ExpectedProductinOrderValue);
		LogoutLink.click();
		test.log(LogStatus.PASS, "Completing Order Validation", "Order Validation Successfully Completed");
	
	}
    
}