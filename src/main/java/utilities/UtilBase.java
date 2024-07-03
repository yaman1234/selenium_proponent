package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import monitoring.LoginTest_SQ;

public class UtilBase {

	// global driver(s) initialization, visible to child classes
	protected static WebDriver driver = null;
	protected static Actions actions = null;
	protected static JavascriptExecutor jsDriver = null;

//	logging
	protected static Logger logger = null;
//	Reporting
	protected static ExtentReports extent;
	protected static ExtentTest test;
	
	
//	global vairables
	protected String sf_case_global = "";
	
	
	
	public static void initialiseDriver() {
//		String browserName = ExcelRead.getData(1, 2, 0);
		String browserName = "chrome";
//		String path = System.getProperty("user.dir") + "\\browserDrivers\\";

		if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {				
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		Actions class is an ability provided by Selenium for handling keyboard and mouse events.
		actions = new Actions(driver);
//		JavaScriptExecutor is an interface that provides a mechanism to execute Javascript through selenium driver.
		jsDriver = (JavascriptExecutor) driver;
	}

	public static void initialiseDriverwithprofile(String userProfilePath){
		WebDriverManager.chromedriver().setup();
		  // Create a ChromeOptions object.
        ChromeOptions options = new ChromeOptions();

        // Set the path to the user profile directory.
        options.addArguments("user-data-dir=" + userProfilePath);
        // Launch Chrome with the configured options.
        driver = new ChromeDriver(options);
        jsDriver = (JavascriptExecutor) driver;
	}
	/**
	 * Captures screenshot of the current window of the browser driver
	 * 
	 * @param screenShotName
	 * @return
	 */
	protected String capture(String screenShotName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = "screenshots//" + screenShotName + System.currentTimeMillis() + ".png";

		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath));
		} catch (IOException e) {
			System.err.println("Error occurred saving screenshot!!");
			e.printStackTrace();
		}
//		return screenshotPath;						
		/* change return statement to below statement if you are not using email report	*/	
		
		return new File (screenshotPath).getAbsolutePath();
		
	}
	
	
	public void testPassed(String testname) {
		test.pass("PASS :: " + testname);
		test.addScreenCaptureFromPath(capture(testname));
		logger.info("PASS :: " + testname);
		Assert.assertTrue(true);
	}

	public void testFailed(String testname) {
		test.fail("FAIL :: " + testname);
		test.addScreenCaptureFromPath(capture(testname));
		logger.info("FAIL :: " + testname);
		Assert.assertTrue(false);
	}
	
	
	@BeforeSuite
	public void setup() {
		logger=LogManager.getLogger(UtilBase.class);
		logger.info("Start :: @Beforesuite, Initailizing the browser");
//		Extent Report setup
		ExtentSparkReporter spark = new ExtentSparkReporter("testReports/monitoring.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

		initialiseDriver();
		
		
	}
	
	@AfterSuite
	public void teardown() {
		logger=LogManager.getLogger(UtilBase.class);
		extent.flush();
//		 driver.quit();
		logger.info("@Aftersuite, Closing the browser");
		logger.info("--------------------");
	}
	
}