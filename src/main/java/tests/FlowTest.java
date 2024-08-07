package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import monitoring.HelperSF;
import monitoring.SQmonitoring;
import utilities.UtilBase;

public class FlowTest extends UtilBase {

//	SALESFORCE VARIABLES
	String sf_url = "https://kapcoglobal--esbox.sandbox.lightning.force.com/lightning/o/Case/list?filterName=00B8M000000RNCrUAO";
	String username_sf = "apil.koirala@javra.com.esbox";
	String password_sf = "V2_naS9V@QjnJCx";

	HelperSF cmd_sf = new HelperSF();

	@BeforeClass
	public void setup() {
//		logging
		logger = LogManager.getLogger(FlowTest.class);
		logger.info("start :: FlowTest");
		logger.info("Initializing the browser with profile");
		initialiseDriverwithprofile();
	}

	

	@Test(priority = 1)
	public void search_SF() {
		String expectedSubject = "Quote Request automated: 1122334";
		try {
//			login to salesforce
			cmd_sf.login_sf(sf_url, username_sf, password_sf);
			Thread.sleep(4000);
//			Find the casenumber by matching the expectedSubject
			String casenumber = cmd_sf.findCase_sf(expectedSubject);
			logger.info("casenumber :: " + casenumber);
//			Search the casenumber
			cmd_sf.searchCase_sf(casenumber);
//			print the case details
			
			
			
			
			
		} catch (Exception e) {
			logger.info("EXCEPTION OCCURED : " + e);
		}
	}

	@AfterClass
	public void teardown() {
//		logger.info("Closing the browser");
//		driver.quit();
	}
}
