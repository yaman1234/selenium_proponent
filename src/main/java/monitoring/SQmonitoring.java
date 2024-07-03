package monitoring;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.UtilBase;

public class SQmonitoring extends UtilBase {

	
	@BeforeClass
	public void beforeClass() {
//		logging
		logger=LogManager.getLogger(SQmonitoring.class);
		logger.info("start :: SQmonitoring");
	}
	
	
	@Test(priority = 1)
	public void test1() {
	String testname = "test1";
		
		
		try {
			test = extent.createTest(testname);
			driver.get("https://www.google.com");
			logger.info("message from testcase 2");
			
			String title = driver.getTitle();
			
			if (title.equalsIgnoreCase("google")) {
				testPassed(testname);
			}else {
				testFailed(testname);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testFailed(testname);
		}
	}
	

	@AfterClass
	public void afterClass() {
		logger.info("END :: SQmonitoring");
	}
	
}
