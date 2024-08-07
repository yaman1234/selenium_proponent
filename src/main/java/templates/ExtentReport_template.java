package templates;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.UtilBase;
import utilities.WebElementLib;

public class ExtentReport_template extends UtilBase {

//	Reporting
	protected static ExtentReports extent;
	protected static ExtentTest test;
//	set file name
	String filename = "ExtentReport_template";

	@BeforeClass
	public void setup() {
		initialiseDriver();

		ExtentSparkReporter spark = new ExtentSparkReporter("testReports/" + filename + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		test = extent.createTest(filename);
	}
	
	@Test (priority = 1)
	public boolean pqcSmokeTest() {
		String testname = "pqc smoke test";
		try {
			test = extent.createTest(testname);

			driver.get("https://www.google.com");
			Thread.sleep(3000);

//			Run the Test
			if (WebElementLib.doesElementExist(sf_po.logout_link())) {
				testPassed(testname);
				logger.info("SUCCESS : loginTest_Salesforce");
				test.pass("loginTest_Salesforce");
				test.addScreenCaptureFromPath(capture("loginTest_Salesforce"), "loginTest_Salesforce ");
			} else if (WebElementLib.doesElementExist(sf_po.login_button())) {
				logger.info("WARNING : salesforceLogin_Fallback");
				test.addScreenCaptureFromPath(capture("loginTest_Salesforce"), "loginTest_Salesforce");
				Assert.assertTrue(false);
			}
			logger.info("END	 : loginTest_Salesforce	 ---------------------------------------");
			return true;
		} catch (Exception e) {
			logger.error("EXCEPTION: loginTest_Salesforce ");

			test.fail("loginTest_Salesforce");
			test.addScreenCaptureFromPath(capture("loginTest_Salesforce"), "loginTest_Salesforce");
			e.printStackTrace();
			Assert.assertTrue(false);
			return false;
		}
	}

	@AfterClass
	public void teardown() {
		extent.flush();
//		driver.close();
	}

}
