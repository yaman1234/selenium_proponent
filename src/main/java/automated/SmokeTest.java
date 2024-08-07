package automated;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.UtilBase;

public class SmokeTest extends UtilBase {
	@BeforeClass
	public void setup() {
		initialiseDriver();
		logger = LogManager.getLogger(SmokeTest.class);
		logger.info("Initializing the browser");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("testReports/SmokeTest.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		test = extent.createTest("PQC smoke test");
	}
	
	
	@Test(priority = 1)
	public void testmain() {
		driver.get("https://www.google.com");
		
	}
	
	@AfterClass
	public void teardown() {
		 driver.quit();
         logger.info("Closing the browser");
	}
}
