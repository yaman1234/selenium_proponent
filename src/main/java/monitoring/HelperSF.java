package monitoring;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import tests.FlowTest;
import utilities.TableData;
import utilities.UtilBase;
import utilities.WebElementLib;

public class HelperSF extends UtilBase {

//	SALESFORCE VARIABLES
	String sf_url = "https://kapcoglobal--esbox.sandbox.lightning.force.com/lightning/o/Case/list?filterName=00B8M000000RNCrUAO";
	String username = "apil.koirala@javra.com.esbox";
	String password = "V2_naS9V@QjnJCx";

	
	public HelperSF() {
		logger = LogManager.getLogger(HelperSF.class);
	}
	
//	login to sf with existing chrome profile, to try and skip the OTP
	public boolean login_sf(String sf_url, String username, String password) {
		boolean status = false;
		try {
			Thread.sleep(2000);
			driver.get(sf_url);
			Thread.sleep(5000);

			if (WebElementLib.doesElementExist(sf_po.logout_link())) {
				logger.info("SUCCESS: Logged in to SF ");
				status = true;
			} else {
				logger.info("WARNING : Auto Log in to SF FAILED");
				status = login_sf_fallback(username, password);
			}
		} catch (Exception e) {
			logger.info("EXCEPTION occured : " + e);
		}
		return status;
	}

//	Login to SF by entering the username and password
	public boolean login_sf_fallback(String username, String password) {
		boolean status = false;
		try {
			sf_po.username_input().clear();
			sf_po.username_input().sendKeys(username);
			sf_po.password_input().clear();
			sf_po.password_input().sendKeys(password);
			sf_po.login_button().click();
			Thread.sleep(3000);

			if (WebElementLib.doesElementExist(sf_po.logout_link())) {
				logger.info("SUCCESS: Log in to SF, with fallback method");
				status = true;
			} else {
				logger.info("ERROR: Log in to SF, with fallback method");
				status = false;
			}

		} catch (Exception e) {
			logger.info("EXCEPTION occured : Log in to SF, with fallback method " + e);
		}
		return status;
	}

//	Find the case number in SF by searching with the timestamp in subject
	public String findCase_sf(String expected_subject) {
		String casenumber = "";

		try {
			Thread.sleep(8000);
			WebElement table = sf_po.table();
//			List<String> rowdata = TableData.getRowData(table, 1);

//			search top 10 row
			for (int i = 1; i < 10; i++) {
//				Index of subject and casenumber could be changed depending upon the column count of SF cases screen template
				String subject = TableData.getCellText(table, i, 9);

				if (subject.equals(expected_subject)) {
					casenumber = TableData.getCellText(table, i, 2);
					break;
				}
			}
		} catch (Exception e) {
			logger.info("EXCEPTION occured :: " + e);
		}
		return casenumber;
	}
	
	
//	Search by the Case Number in the Salesforce 
	public void searchCase_sf(String casenumber) {
		boolean status = false;
		int maxCount = 3;

		for (int i = 1; i <= maxCount; i++) {
//			search with case number 
			try {
				sf_po.search_input().clear();
				sf_po.search_input().sendKeys(casenumber);
				Thread.sleep(1000);
				sf_po.search_input().sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				int rowCount = TableData.getRowCount(sf_po.table());
//				logger.info("searchCaseNumber_salesforce rowCount: " + rowCount);
//				used 2 because of an extra <tr> exists 
				if (rowCount == 2) {
					logger.info("PASS : Search with case number, case found");
					status = true;
					break;
				}
			} catch (Exception e) {
				logger.info("ERROR: search with case number failed");
				e.printStackTrace();
			}
		}
		if (!status) {
			logger.info("ERROR: searchCaseNumber_salesforce, Case not found");
		}

	}
	

}
