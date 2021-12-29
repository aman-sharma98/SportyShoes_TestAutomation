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

public class LoginPage {
	
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;
	
	//=====WebElement=====
	
	@FindBy(linkText="Login/Signup")
	WebElement LoginLink;
	
	@FindBy(name="email_id")
	WebElement EmailId;
	
	@FindBy(name="pwd")
	WebElement Password;
	
	@FindBy(css="button")
	WebElement LoginButton;
	
	@FindBy(id="msg_box")
	WebElement Error;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	
	}
	
	//=====Methods=====
	
	public void Login(String Email, String Pwd) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Clicked on Login Link");
		
		EmailId.sendKeys(Email);
		test.log(LogStatus.PASS, "Enter Email "+Email, "Successfully Entered Email");
		
		Password.sendKeys(Pwd);
		test.log(LogStatus.PASS, "Enter Password "+Pwd, "Successfully Entered Password");
		
		LoginButton.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Clicked on Login Button");
		
	}
	
	public void ValidateLogin() {
		
		String ExpectedURL_l = "http://localhost:8080/Section7LEP2/dashboard";
		String ActualURL_l = driver.getCurrentUrl();

		SoftAssert soft_l = new SoftAssert();
		soft_l.assertEquals(ActualURL_l, ExpectedURL_l);
		soft_l.assertAll();
		test.log(LogStatus.PASS, "Validating Login", "Successfully Validated Login");
		
	}

	public void ErrorCheck() {
		
		String ExpectedURL = "http://localhost:8080/Section7LEP2/loginaction";
		String ActualURL = driver.getCurrentUrl();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ActualURL, ExpectedURL);
		soft.assertAll();
		test.log(LogStatus.PASS, "Checking for Negative Login", "Successfully Checked Negative Login");
		
	}
	
}