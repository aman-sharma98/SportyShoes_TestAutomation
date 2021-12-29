package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {

	DesiredCapabilities cap =new DesiredCapabilities();
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeTest
	public void ReportSetup() {
		report = new ExtentReports("ExtentReports.html"); 
	}

	@BeforeMethod
	public void setup(){

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Section7LEP2/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);			
	}
		@AfterMethod
		public void teardown() {
			driver.quit();
		}
		
		@AfterTest
		public void ReportTearDown() {
			report.flush();
			report.close();
		}

}