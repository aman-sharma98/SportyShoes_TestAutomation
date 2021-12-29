package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Tests.Baseclass;

public class SignupPage {
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;


	//*************************WebElements**********************
	@FindBy(linkText="Login/Signup")
	WebElement loginsignup;
	
	@FindBy(linkText="Not a member? Signup")
	WebElement SignupLink;
	
	@FindBy(css="input[name='email_id']")
	WebElement EmailId;
	
	@FindBy(css="input[name='pwd']")
	WebElement Password;
	
	@FindBy(css="input[name='pwd2']")
	WebElement ConfirmPassword;
	
	@FindBy(css="input[name='fname']")
	WebElement FirstName;
	
	@FindBy(css="input[name='lname']")
	WebElement LastName;
	
	@FindBy(css="input[name='age']")
	WebElement Age;
	
	@FindBy(css="input[name='address']")
	WebElement Address;
	
	@FindBy(css="button")
	WebElement SignupButton;
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

	public void signup(String EmailVal,String PasswordVal,String FirstNameVal,String LastNameVal,String AgeVal,String AddressVal) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(loginsignup));
		
		loginsignup.click();
		test.log(LogStatus.PASS, "Click on Login/Signup Button", "Clicked on Login/Signup Button");
		
		SignupLink.click();
		test.log(LogStatus.PASS, "Click on Signup Link", "Clicked on Signup Link");
		
		EmailId.sendKeys(EmailVal);
		test.log(LogStatus.PASS, "Enter Email "+EmailVal, "Successfully Entered Email");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password "+PasswordVal, "Successfully Entered Password");
		
		ConfirmPassword.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Passowd again "+PasswordVal, "Successfully Entered Password Again");
		
		FirstName.sendKeys(FirstNameVal);
		test.log(LogStatus.PASS, "Enter First name "+FirstNameVal, "Successfully Entered First name");
		
		LastName.sendKeys(LastNameVal);
		test.log(LogStatus.PASS, "Entered Last name "+LastNameVal, "Successfully Entered Last name");
		
		Age.sendKeys(AgeVal);
		test.log(LogStatus.PASS, "Enter Age "+AgeVal, "Successfully Entered Age");
		
		Address.sendKeys(AddressVal);
		test.log(LogStatus.PASS, "Enter Address "+AddressVal, "Successfully Entered Address");
		
		SignupButton.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Clicked on Login Button");
		
	}
	
	public void ValidateSignup() {
		
		String ExpectedURL_S = "http://localhost:8080/Section7LEP2/registerconfirm";
		String ActualURL_S = driver.getCurrentUrl();

		SoftAssert soft_S = new SoftAssert();
		soft_S.assertEquals(ActualURL_S, ExpectedURL_S);
		soft_S.assertAll();
		test.log(LogStatus.PASS, "Validating Signup", "Successfully Validated Signup");
		
	}
	
	public void ErrorCheckS() {
		
		String ExpectedURL = "http://localhost:8080/Section7LEP2/registerconfirm";
		String ActualURL = driver.getCurrentUrl();

		SoftAssert soft = new SoftAssert();
		soft.assertNotEquals(ActualURL, ExpectedURL);
		soft.assertAll();
		test.log(LogStatus.PASS, "Checking Negative Signup", "Successfully Checked Negative Signup");
	}

}