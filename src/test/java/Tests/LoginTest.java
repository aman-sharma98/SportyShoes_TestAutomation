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

public class LoginTest extends Baseclass{

	
	@Parameters({"Email", "Password"})
	@Test
	public void NegativeLogin(String EmailVal, String PasswordVal) {
		
		test = report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(EmailVal, PasswordVal);
		login.ErrorCheck();
		report.endTest(test);
		Assert.assertTrue(true);
		
	}
	
	@Parameters({"Email", "CorrectPassword"})
	@Test
	public void positiveLogin(String EmailVal, String PasswordVal) {
		
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();
		login.Login(EmailVal, PasswordVal);
		login.ValidateLogin();
		report.endTest(test);
		Assert.assertTrue(true);
	}
	
}