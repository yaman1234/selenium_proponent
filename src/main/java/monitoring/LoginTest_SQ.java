package monitoring;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.SQ_pageObjects;
import utilities.UtilBase;
import utilities.WebElementLib;

public class LoginTest_SQ extends UtilBase {

//	variables
//	SMARTER QUOTING
	String sq_baseurl = "http://10.0.3.143";
	String sq_username = "kathmandu\\yamah022";
	String sq_password = "1@work";

	@BeforeClass
	public void beforeClass() {
//		logging
		log.info("@beforeClass");
	}

	@Test(priority = 1)
	public void LoginTest() {
		String testname = "Login Test";
		try {
			test = extent.createTest(testname);

			driver.get(sq_baseurl);
			Thread.sleep(3000);
//			login
			sq_po.username_input().sendKeys(sq_username);
			sq_po.password_input().sendKeys(sq_password);
			sq_po.submit_button().click();
			Thread.sleep(2000);

			if (WebElementLib.doesElementExist(sq_po.signout_button())) {
				testPassed(testname);
			} else {
				testFailed(testname);
			}

		} catch (Exception e) {
			e.printStackTrace();
			testFailed(testname);
			driver.quit();
		}

	}

	@AfterClass
	public void afterClass() {
		log.info("@afterclass");
	}

}
