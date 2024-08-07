package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.UtilBase;

public class template extends UtilBase{
	
	

	@BeforeClass
	public void setup() {
		initialiseDriver();
		logger = LogManager.getLogger(template.class);
		logger.info("Initializing the browser");
	}
	
	
	@Test(priority = 1)
	public void test1() {
		driver.get("https://www.google.com");
		
	}
	
	@AfterClass
	public void teardown() {
		 driver.quit();
         logger.info("Closing the browser");
	}
}
