package Tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SignupPage;


public class SignupTest extends Baseclass {

	
	@Parameters({"Email","CorrectPassword","FirstName","LastName","Age","Address"})
	@Test
	public void PositivesignupTest(String EmailVal,String PasswordVal,String FirstNameVal,String LastNameVal,String AgeVal,String AddressVal) {
		
		test = report.startTest("Positive Sign Up Test");
		SignupPage Signup = new SignupPage();
		Signup.signup(EmailVal, PasswordVal, FirstNameVal, LastNameVal, AgeVal, AddressVal);
		Signup.ValidateSignup();
		report.endTest(test);
		Assert.assertTrue(true);
		
	}
	
	@Parameters({"WrongEmail","CorrectPassword","FirstName","LastName","Age","Address"})
	@Test
	public void NegativeSignup(String EmailVal,String PasswordVal,String FirstNameVal,String LastNameVal,String AgeVal,String AddressVal) {
		
		test = report.startTest("Negative Sign Up Test");
		SignupPage Signup = new SignupPage();
		Signup.signup(EmailVal, PasswordVal, FirstNameVal, LastNameVal, AgeVal, AddressVal);
		Signup.ErrorCheckS();
		report.endTest(test);
		Assert.assertTrue(true);
	}
}