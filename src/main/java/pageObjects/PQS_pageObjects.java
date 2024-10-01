package pageObjects;

import org.openqa.selenium.WebElement;

import utilities.WebElementLib;

public class PQS_pageObjects {
	public WebElement loading() {
		return WebElementLib.findMyElement("xpath", "//i[@aria-label='icon: loading-3-quarters']");
	}

	/***************************** NAVBAR ***************************/
	public WebElement nav_OpenQueue_link() {
		return WebElementLib.findMyElement("xpath", "//a[normalize-space()='Open Queue']");
	}

	public WebElement nav_createSupplierRfq_link() {
		return WebElementLib.findMyElement("xpath", "//a[normalize-space()='Create Supplier RFQ']");
	}

	public WebElement nav_sendRfq_link() {
		return WebElementLib.findMyElement("xpath", "//a[normalize-space()='Send RFQ to Suppliers']");
	}

	public WebElement nav_supplierQuoteQueue_link() {
		return WebElementLib.findMyElement("xpath", "//a[normalize-space()='Supplier Quote Queue']");
	}

	public WebElement nav_search_link() {
		return WebElementLib.findMyElement("xpath", "//a[normalize-space()='Search']");
	}

	public WebElement nav_BIreport_link() {
		return WebElementLib.findMyElement("xpath", "//a[normalize-space()='BI Report']");
	}

	public WebElement nav_userProfile_link() {
		return WebElementLib.findMyElement("xpath", "//span[@class='username']");
	}

	/***************************** OPEN QUEUE ***************************/
	public WebElement openQueue_label() {
		return WebElementLib.findMyElement("xpath", "//h2[normalize-space()='Open Queue']");
	}

	/***************************** CREATE SUPPLIER RFQ ***************************/
	public WebElement createSupplierRfq_label() {
		return WebElementLib.findMyElement("xpath", "//h2[normalize-space()='Create Supplier RFQ']");
	}

	/*****************************
	 * SEND RFQ TO SUPPLIERS
	 ***************************/

	/***************************** SUPPLIER QUOTE QUEUE ***************************/
	public WebElement supplierQuoteQueue_label() {
		return WebElementLib.findMyElement("xpath", "//h2[normalize-space()='Supplier Quote Queue']");
	}

	/***************************** SEARCH ***************************/
	public WebElement search_label() {
		return WebElementLib.findMyElement("xpath", "//h2[normalize-space()='Search']");
	}

	/***************************** BI REPORT ***************************/
	public WebElement BIreport_label() {
		return WebElementLib.findMyElement("xpath", "//h2[normalize-space()='BI Reports']");
	}

}
