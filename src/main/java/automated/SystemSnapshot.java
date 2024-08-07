package automated;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import monitoring.HelperPQC;
import utilities.UtilBase;

public class SystemSnapshot extends UtilBase {

//	PQC VARIABLES
	String pqc_username = "yamah022";
	String pqc_password = "1@work";
	String pqc_baseurl = "10.0.1.62:80";
	String pqc_login_link = "http://" + pqc_username + ":" + pqc_password + "@" + pqc_baseurl;

//	Extent Report
	String filename = "System Snapshot";

	HelperPQC cmd_pqc = new HelperPQC();
//	screenshot path
	String path = "screenshots//" + System.currentTimeMillis() + "//PQC//";

	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger(SystemSnapshot.class);
		logger.info("Initializing the browser");

		initialiseDriver();

//		Extent Report
		ExtentSparkReporter spark = new ExtentSparkReporter("testReports/" + filename + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		String testname = "login test";
		test = extent.createTest(testname);
		try {
			if (cmd_pqc.login_pqc(pqc_login_link, pqc_baseurl)) {
				testPassed(testname);
			} else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@Test(priority = 2)
	public void casesQueueTest() {
		String testname = "case queue";
		test = extent.createTest(testname);
		try {
			if (cmd_pqc.caseQueue_linkClick(testname)) {
				testPassed(testname);
			} else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@Test(priority = 3)
	public void myOpenRfqTest() {
		String testname = "my open rfq";
		test = extent.createTest(testname);
		try {
			if (cmd_pqc.myOpenRfq_linkClick(testname)) {
				testPassed(testname);
			} else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@Test(priority = 4)
	public void myTrainingRfqTest() {
		String testname = "my training rfq";
		test = extent.createTest(testname);
		try {
			if(cmd_pqc.myTrainingRfq_linkClick(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
			
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@Test(priority = 5)
	public void myActiveQuotesTest() {
		String testname = "my active quotes";
		test = extent.createTest(testname);
		try {
			if(cmd_pqc.myActiveQuotes_linkClick(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@Test(priority = 6)
	public void globalSearchTest() {
		String testname = "global search";
		test = extent.createTest(testname);
		try {
			if(cmd_pqc.globalSearch_linkClick(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@Test(priority = 7)
	public void createCustomerRFQTest() {
		String testname = "create customer rfq";
		test = extent.createTest(testname);
		try {
			if(cmd_pqc.createCustomerRfq_linkClick(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}

	@AfterClass
	public void teardown() {
		extent.flush();
//		 driver.quit();
		logger.info("Closing the browser");
	}

}
