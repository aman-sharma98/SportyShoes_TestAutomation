package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.CompleteOrderandValidatePage;

public class CompleteOrderandValidateTest extends Baseclass{
	
	@Parameters({"Email", "CorrectPassword", "ExpectedProduct","ExpectedProductinOrder"})
	@Test
	public void CompleteOrderandValidate(String EmailVal, String PasswordVal, String ExpectedProductVal, String ExpectedProductinOrderVal) {
		
		test = report.startTest("Adding Product to cart, Checkout and order Validation");
		LoginPage login = new LoginPage();
		login.Login(EmailVal, PasswordVal);
		
		CompleteOrderandValidatePage Add = new CompleteOrderandValidatePage();
		Add.AddProductandCheckout(ExpectedProductVal);
		
		Add.ValidateOrder(ExpectedProductinOrderVal);
		
		report.endTest(test);
		Assert.assertTrue(true);
	}
	
}