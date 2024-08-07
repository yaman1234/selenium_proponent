package monitoring;

import org.openqa.selenium.WebElement;

import utilities.UtilBase;
import utilities.WebElementLib;

public class HelperPQC extends UtilBase {

//	login to PQC application, pqc_baseurl = "10.0.1.62:80"; pqc_login_link = "http://" + pqc_username + ":" + pqc_password + "@" + pqc_baseurl;
	public boolean login_pqc(String pqc_login_link, String pqc_baseurl) throws InterruptedException {
		boolean loginsuccess = false;
		driver.get(pqc_login_link);
		Thread.sleep(3000);
		driver.get("http://" + pqc_baseurl);
		Thread.sleep(3000);

		if (WebElementLib.doesElementExist(pqc_po.caseQueue_link())) {
			logger.info("SUCCESS: PQC Login succesful");
			loginsuccess = true;
		} else {
			logger.info("WARNING: could not verify login ");
			loginsuccess = false;
		}
		return loginsuccess;
	}

	public boolean caseQueue_linkClick(String testname) {
		boolean status = false;
		WebElement element = pqc_po.caseQueue_link();
		try {
			element.click();
			wait.wait_element_present(pqc_po.assignToMe_button_cq());
			if (WebElementLib.doesElementExist(pqc_po.assignToMe_button_cq())) {
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

	
	public boolean myOpenRfq_linkClick(String testname) {
		boolean status = false;
		WebElement element = pqc_po.myOpenRfq_link();
		try {
			element.click();
			wait.wait_element_disappear(pqc_po.loading());
			wait.wait_element_present(pqc_po.cancelSelectedLines_button_mor());
			if (WebElementLib.doesElementExist(pqc_po.cancelSelectedLines_button_mor())) {
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
	
	public boolean myTrainingRfq_linkClick(String testname) {
		boolean status = false;
		WebElement element = pqc_po.myTrainingRfq_link();
		try {
			element.click();
			wait.wait_element_disappear(pqc_po.loading());
			wait.wait_element_present(pqc_po.reassign_button_mtr());
			if (WebElementLib.doesElementExist(pqc_po.reassign_button_mtr())) {
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
	
	public boolean myActiveQuotes_linkClick(String testname) {
		boolean status = false;
		WebElement element = pqc_po.myActiveQuotes_link();
		try {
			element.click();
			wait.wait_element_disappear(pqc_po.loading());
			wait.wait_element_present(pqc_po.maq_openFor());
			if (WebElementLib.doesElementExist(pqc_po.maq_openFor())) {
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
	
	public boolean globalSearch_linkClick(String testname) {
		boolean status = false;
		WebElement element = pqc_po.globalSearch_link();
		try {
			element.click();
			wait.wait_element_disappear(pqc_po.loading());
			wait.wait_element_present(pqc_po.gs_showClosed_label());
			if (WebElementLib.doesElementExist(pqc_po.gs_showClosed_label())) {
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
	
	public boolean createCustomerRfq_linkClick(String testname) {
		boolean status = false;
		WebElement element = pqc_po.createCustomerRFQ_link();
		try {
			element.click();
			wait.wait_element_disappear(pqc_po.loading());
			wait.wait_element_present(pqc_po.ccr_deleteAll_button());
			if (WebElementLib.doesElementExist(pqc_po.ccr_deleteAll_button())) {
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
