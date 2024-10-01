package automated;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import monitoring.HelperPQC;
import monitoring.HelperPQS;
import utilities.UtilBase;

public class SystemSnapshot extends UtilBase {

//	PQC VARIABLES
	String pqc_username = "yamah022";
	String pqc_password = "1@work";
	String pqc_baseurl = "10.0.1.62:70";
	String pqs_baseurl = "10.0.1.62:71";
	String pqc_login_link = "http://" + pqc_username + ":" + pqc_password + "@" + pqc_baseurl;
	String pqs_login_link = "http://" + pqc_username + ":" + pqc_password + "@" + pqs_baseurl;

	
//	Extent Report
	String filename = "System Snapshot";

//	Helper Class
	HelperPQC cmd_pqc = new HelperPQC();
	HelperPQS cmd_pqs = new HelperPQS();

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
			if (cmd_pqc.login_pqc(pqc_baseurl, pqc_username, pqc_password)) {
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

	
	
	
	@Test(priority = 8)
	public void loginTest_PQS() throws InterruptedException {
		String testname = "PQS login test";
		test = extent.createTest(testname);
		try {
			if (cmd_pqs.login_pqs(pqs_baseurl, pqc_username, pqc_password)) {
				testPassed(testname);
			} else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}
	
	
	@Test(priority = 9)
	public void test_click_openQueue() {
		String testname = "Open Queue";
		test = extent.createTest(testname);
		try {
			if(cmd_pqs.click_openQueue_link(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}
	
	@Test(priority = 10)
	public void test_click_createSupplierRfq() {
		String testname = "create Supplier Rfq";
		test = extent.createTest(testname);
		try {
			if(cmd_pqs.click_createSupplierRfq_link(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}
	
	@Test(priority = 11)
	public void test_click_sendRfq() {
		String testname = "send rfq";
		test = extent.createTest(testname);
		try {
			if(cmd_pqs.click_sendRfq_link(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}
	
	@Test(priority = 12)
	public void test_click_supplierQuoteQueue() {
		String testname = "supplier quote queue";
		test = extent.createTest(testname);
		try {
			if(cmd_pqs.click_supplierQuoteQueue_link(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}
	
	@Test(priority = 13)
	public void test_click_search() {
		String testname = "search";
		test = extent.createTest(testname);
		try {
			if(cmd_pqs.click_search_link(testname)) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
		} catch (Exception e) {
			testException(testname, e);
		}
	}
	
	@Test(priority = 14)
	public void test_click_BIreport() {
		String testname = "BI Reports";
		test = extent.createTest(testname);
		try {
			if(cmd_pqs.click_BIreport_link(testname)) {
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
