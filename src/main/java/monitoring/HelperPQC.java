package monitoring;

import utilities.UtilBase;
import utilities.WebElementLib;

public class HelperPQC extends UtilBase{

	
//	login to SQ application
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
	
	
}
