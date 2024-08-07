package pageObjects;

import org.openqa.selenium.WebElement;

import utilities.WebElementLib;

public class PQC_pageObjects {
	
//	loading
	public WebElement loading() {
		return WebElementLib.findMyElement("xpath", "//span[@aria-label='loading']//*[name()='svg']");
	}
	

	/***************************** NAVBAR ***************************/
	public WebElement caseQueue_link() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/header/nav/ul/li[1]/span/span/a");
	}

	public WebElement myOpenRfq_link() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/header/nav/ul/li[2]/span/span/a");
	}

	public WebElement myTrainingRfq_link() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/header/nav/ul/li[3]/span/span/a");
	}

	public WebElement myActiveQuotes_link() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/header/nav/ul/li[4]/span/span/a");
	}

	public WebElement globalSearch_link() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/header/nav/ul/li[5]/span/span/a");
	}

	public WebElement createCustomerRFQ_link() {
		return WebElementLib.findMyElement("xpath", "//*[@id='root']/div/div/div/header/nav/ul/li[6]/span/span/a");
	}



	/************* PROCESSED CUSTOMER RFQ ***************************/
	public WebElement customerNumber_input_main() {
		return WebElementLib.findMyElement("id", "CustomerCode");
	}

	public WebElement customerName_input_main() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"CustomerName\"]");
	}

	public WebElement contactName_input_main() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"contactName\"]");
	}

	public WebElement contactEmail_input_main() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"contactEmail\"]");
	}

	public WebElement selectAll_checkbox() {
		return WebElementLib.findMyElement("xpath", "//*[@id='processed-customer-screen']/div[6]/table/thead/tr/td[2]/div/label");
	}

	public WebElement quoteAll_checkbox() {
		return WebElementLib.findMyElement("xpath", "//*[@id='processed-customer-screen']/div[6]/table/thead/tr/td[3]/div/label");
	}

	public WebElement noQuoteAll_checkbox() {
		return WebElementLib.findMyElement("xpath", "//*[@id='s31']");
	}

	public WebElement validate_button() {
		return WebElementLib.findMyElement("xpath", "//*[@id='processed-customer-screen']/div[5]/div/div[1]/button[9]");
	}
	
	
//	SEND QUOTE TO CUSTOMER MODAL
	
	public WebElement emailRecepient_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"emailAddr\"]");
	}
	
	public WebElement sendQuote_button() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"quoteSubmit\"]/div[3]/button[2]");
	}
	
	
	/*********************     Cases Queue      ************************/
	
	public WebElement assignToMe_button_cq() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Assign to me']");
	}
	
	public WebElement assignToOthers_button_cq() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Assign to others']");
	}

	/*********************     my open rfq      ************************/
	public WebElement reassignMyRfq_button_mor() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Reassign my RFQs']");
	}
	
	public WebElement cancelSelectedLines_button_mor() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Cancel Selected Lines']");
	}
	
	
	/*********************     MY TRAINING RFQs      ************************/
	public WebElement reassign_button_mtr() {
		return WebElementLib.findMyElement("xpath", "//span[normalize-space()='Reassign']");
	}
	
	
	/*********************     MY ACTIVE QUOTES      ************************/
	public WebElement maq_statusFilter() {
		return WebElementLib.findMyElement("xpath", "//div[@class='status-filter']");
	}
	
	public WebElement maq_openFor() {
		return WebElementLib.findMyElement("xpath", "//div[@class='status-filter no-border']");
	}

	/************* 	GLOBAL SEARCH PAGE ELEMENTS ***************************/
	public WebElement gs_showClosed_label() {
		return WebElementLib.findMyElement("xpath", "//label[normalize-space()='Show Closed']");
	}
	
	public WebElement search_button() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"root\"]/div/div/div/main/div/div[1]/form/div[1]/div[5]/button");
	}

	public WebElement caseNumber_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"root\"]/div/div/div/main/div/div[1]/form/div[2]/div[1]/div[6]/div[2]/div/div/input");
	}

	public WebElement rfqNumber_input() {
		return WebElementLib.findMyElement("xpath", "//*[@id=\"root\"]/div/div/div/main/div/div[1]/form/div[2]/div[1]/div[5]/div[2]/div/div/input");
	}

	public WebElement table_table() {
		return WebElementLib.findMyElement("xpath", "//table");
	}
	
	/************* 		CREATE CUSTOMER RFQ		 ********************/
	public WebElement ccr_deleteAll_button() {
		return WebElementLib.findMyElement("xpath", "//div[@class='ant-col ant-col-8']//button[2]");
	}
	public WebElement ccr_createRfq_button() {
		return WebElementLib.findMyElement("xpath", "//button[@ant-click-animating-without-extra-node='false']//span[@aria-label='check']//*[name()='svg']");
	}
}
