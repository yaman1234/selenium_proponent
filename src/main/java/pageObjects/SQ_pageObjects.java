package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import utilities.WebElementLib;

public class SQ_pageObjects {

	/***************************** LOGIN PAGE ***************************/
	public WebElement username_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/div/form/input[1]");
	}

	public WebElement password_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/div/form/input[2]");
	}

	public WebElement submit_button() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/div/form/button");
	}

	/***************************** NAVBAR ***************************/
	public WebElement home_link() {
		return WebElementLib.findMyElement("linktext", "Home");
	}

	public WebElement caseEmails_link() {
		return WebElementLib.findMyElement("linktext", "Case Emails");
	}

	public WebElement reviewAnnotation_link() {
		return WebElementLib.findMyElement("linktext", "Review Annotation");
	}

	public WebElement settings_link() {
		return WebElementLib.findMyElement("linktext", "Settings");
	}

	public WebElement messages_link() {
		return WebElementLib.findMyElement("linktext", "Messages");
	}

	public WebElement mlModels_link() {
		return WebElementLib.findMyElement("linktext", "ML Models");
	}

	public WebElement signout_button() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/nav/div/div[2]/ul/li[7]/div");
	}

	/***************************** GLOBAL ELEMENTS ***************************/

	public WebElement table() {
		return WebElementLib.findMyElement("xpath", "//div[@class='ant-table-body']/table");
	}

	public WebElement noData_table() {
		return WebElementLib.findMyElement("xpath", "//div[@class='ant-empty ant-empty-normal']");
	}

	/***************************** Messages Tab ***************************/

	public WebElement caseNumber_messages_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id='case_number']");
	}

	public WebElement search_button() {
		return WebElementLib.findMyElement("xpath", "//button[@title='Search']");
	}

	public WebElement refresh_button() {
		return WebElementLib.findMyElement("xpath", "//button[@title='Refresh']");
	}

	public WebElement status_messages() {
		return WebElementLib.findMyElement("xpath", "//table/tbody/tr[2]/td[5]");
	}

	public WebElement pagination() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/div/div/div/div/ul");
	}

	public WebElement nextPage() {
		return WebElementLib.findMyElement("xpath", "//li[@title='Next Page']/button");
	}

	public WebElement fromDate_messages_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id='from_date']");
	}

	public WebElement toDate_messages_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id='to_date']");
	}
	
	public List<WebElement> liElements_messages(){
		return WebElementLib.findMyElements("xpath","//*[@id=\"root\"]/div/div/div/div/div/div/ul/li" );
	}

	public WebElement lastLiElement_messages(int liElementCount) {
		return WebElementLib.findMyElement("cssselector", "#root > div > div > div > div > div > div > ul > li:nth-child(" + liElementCount + ")");
	}
	/***************************** Case Emails Tab ***************************/
	public WebElement fromDate_caseEmails_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"from\"]");
	}

	public WebElement toDate_caseEmails_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"to\"]");
	}

	public WebElement caseNumber_caseEmails_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id='case_number']");
	}

	public List<WebElement> liElements_caseEmails(){
		return WebElementLib.findMyElements("xpath", "//*[@id=\"root\"]/div/div/div/div/div/div/div/ul/li");
	}
	
	public WebElement lastLiElement_caseEmails(int liElementCount) {
		return WebElementLib.findMyElement("cssselector", "#root > div > div > div > div > div > div > div > ul > li:nth-child(" + liElementCount + ")");
	}
	
	

	public WebElement caseNumber_caseEmails() {
		return WebElementLib.findMyElement("xpath", "//table/tbody/tr[2]/td[2]");
	}

	public WebElement customer_caseEmails() {
		return WebElementLib.findMyElement("xpath", "//table/tbody/tr[2]/td[3]");
	}

	public WebElement contact_caseEmails() {
		return WebElementLib.findMyElement("xpath", "//table/tbody/tr[2]/td[4]");
	}

	public WebElement caseType_caseEmails() {
		return WebElementLib.findMyElement("xpath", "//table/tbody/tr[2]/td[6]");
	}

	public WebElement status_caseEmails() {
		return WebElementLib.findMyElement("xpath", "//table/tbody/tr[2]/td[9]");
	}

	/*----------------------------- 	  -----------------------------*/

}
