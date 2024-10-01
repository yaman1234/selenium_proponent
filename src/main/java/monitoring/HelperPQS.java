package monitoring;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;

import pageObjects.PQS_pageObjects;
import utilities.UtilBase;
import utilities.WebElementLib;

public class HelperPQS extends UtilBase{
	
	public HelperPQS() {
		logger = LogManager.getLogger(HelperPQS.class);
	}
	
	
//	login to PQC application, pqc_baseurl = "10.0.1.62:80";
	public boolean login_pqs(String baseurl, String username, String password) throws InterruptedException {
		boolean loginsuccess = false;

		String login_link = "http://" + username + ":" + password + "@" + baseurl;
		driver.get(login_link);
		Thread.sleep(3000);
		driver.get("http://" + baseurl);
		Thread.sleep(3000);

		if (WebElementLib.doesElementExist(pqc_po.caseQueue_link())) {
			logger.info("SUCCESS: PQS Login succesful");
			loginsuccess = true;
		} else {
			logger.info("WARNING: could not verify login ");
			loginsuccess = false;
		}
		return loginsuccess;
	}
	
//	CLICK OPEN QUEUE
	public boolean click_openQueue_link(String testname) {
		boolean status = false;
		WebElement element = pqs_po.nav_OpenQueue_link();
		try {
			element.click();
			wait.wait_element_present(pqs_po.openQueue_label());
			if (WebElementLib.doesElementExist(pqs_po.openQueue_label())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			testException(testname, e);
			status = false;
		}
		return status;
	}
	
	
//	CLICK CREATE SUPPLIER RFQ
	public boolean click_createSupplierRfq_link(String testname) {
		boolean status = false;
		WebElement element = pqs_po.nav_createSupplierRfq_link();
		try {
			element.click();
			wait.wait_element_disappear(pqs_po.loading());
			wait.wait_element_present(pqs_po.createSupplierRfq_label());
			if (WebElementLib.doesElementExist(pqs_po.createSupplierRfq_label())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			testException(testname, e);
			status = false;
		}
		return status;
	}
	
//	CLICK SEND RFQ TO SUPPLIERS
	public boolean click_sendRfq_link(String testname) {
		boolean status = false;
		WebElement element = pqs_po.nav_sendRfq_link();
		try {
			element.click();
			wait.wait_element_disappear(pqs_po.loading());
			
			if (driver.getCurrentUrl().contains("send-rfq")) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			testException(testname, e);
			status = false;
		}
		return status;
	}
	
//	CLICK SUPPLIER QUOTE QUEUE
	public boolean click_supplierQuoteQueue_link(String testname) {
		boolean status = false;
		WebElement element = pqs_po.nav_supplierQuoteQueue_link();
		try {
			element.click();
			wait.wait_element_disappear(pqs_po.loading());
			wait.wait_element_present(pqs_po.supplierQuoteQueue_label());
			if (WebElementLib.doesElementExist(pqs_po.supplierQuoteQueue_label())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			testException(testname, e);
			status = false;
		}
		return status;
	}
	
	
	
//	CLICK SEARCH
	public boolean click_search_link(String testname) {
		boolean status = false;
		WebElement element = pqs_po.nav_search_link();
		try {
			element.click();
			wait.wait_element_disappear(pqs_po.loading());
			wait.wait_element_present(pqs_po.search_label());
			if (WebElementLib.doesElementExist(pqs_po.search_label())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			testException(testname, e);
			status = false;
		}
		return status;
	}
	
//	CLICK BI REPORT
	public boolean click_BIreport_link(String testname) {
		boolean status = false;
		WebElement element = pqs_po.nav_BIreport_link();
		try {
			element.click();
			wait.wait_element_disappear(pqs_po.loading());
			wait.wait_element_present(pqs_po.BIreport_label());
			if (WebElementLib.doesElementExist(pqs_po.BIreport_label())) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception e) {
			testException(testname, e);
			status = false;
		}
		return status;
	}
}
