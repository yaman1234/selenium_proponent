package monitoring;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utilities.UtilBase;

public class HelperSQ extends UtilBase {
	
//	login to SQ application
	public void login_sq(String sq_baseurl, String sq_username, String sq_password) throws InterruptedException {
		driver.get(sq_baseurl);
		Thread.sleep(3000);
//		login
		sq_po.username_input().sendKeys(sq_username);
		sq_po.password_input().sendKeys(sq_password);
		sq_po.submit_button().click();
		Thread.sleep(2000);
	}
	
//	get the last page number
	public int getLastPage(String screen) throws InterruptedException {
		int lastpage = 0;
		
		
		if (screen.equals("messages")){
			List<WebElement> pageList = sq_po.liElements_messages();
			int liElementCount = pageList.size();

//			get the last li Element
			WebElement lastLiElement = sq_po.lastLiElement_messages(liElementCount);
			String liTitle = lastLiElement.getAttribute("title");
			logger.info("Title :: " + liTitle);

//			20/pages is not recognized by lastLiElement.getAttribute("title"). so used if method 
			if (liTitle.equals("Next Page")) {
				WebElement lastpageElement = sq_po.lastLiElement_messages(liElementCount-1);
				lastpage = Integer.parseInt(lastpageElement.getText());
				logger.info("Total Pages :: " + lastpage);
			} else {
//				Last page = n-2
				WebElement lastpageElement = sq_po.lastLiElement_messages(liElementCount-2);
				lastpage = Integer.parseInt(lastpageElement.getText());
			}

		}else if (screen.equals("caseEmails")) {
			List<WebElement> pageList = sq_po.liElements_caseEmails();
			int liElementCount = pageList.size();

//			get the last li Element
			WebElement lastLiElement = sq_po.lastLiElement_caseEmails(liElementCount);
			String liTitle = lastLiElement.getAttribute("title");
			logger.info("Title :: " + liTitle);

//			20/pages is not recognized by lastLiElement.getAttribute("title"). so used if method 
			if (liTitle.equals("Next Page")) {
				WebElement lastpageElement = sq_po.lastLiElement_caseEmails(liElementCount-1);
				lastpage = Integer.parseInt(lastpageElement.getText());
				logger.info("Total Pages :: " + lastpage);
			} else {
//				Last page = n-2
				WebElement lastpageElement = sq_po.lastLiElement_caseEmails(liElementCount-2);
				lastpage = Integer.parseInt(lastpageElement.getText());
			}

		}
		

		
		return lastpage;
	}
	
	
	
	
//	Get count of total cases
	public int getTotalCases(List<List<Object>> datalist) {
		int totalCases = datalist.size();
		return totalCases;
		
	}
	
//	get count of cases by status
	public int getCountByStatus(String screen, List<List<Object>> datalist, String status) {
		int count = 0;
		
		if(screen.equals("messages")) {
			for (List<Object> obj : datalist) {
				if (obj.get(4).equals(status)) {
					count++;
				}
			}
		}
		else {
			for (List<Object> obj : datalist) {
				if (obj.get(8).equals(status)) {
					count++;
				}
			}
		}
	
		return count;
	}

	
//	click to messages link navbar
	public void click_messages() {
		sq_po.messages_link().click();
	}
	
//	click to messages link navbar
	public void click_caseEmails() {
		sq_po.caseEmails_link().click();
	}
	
//enter from date 
	public void enter_fromdate(String fromdate) {
		sq_po.fromDate_messages_input().sendKeys(fromdate);
		sq_po.fromDate_messages_input().sendKeys(Keys.ENTER);
	}
//enter to date
	public void enter_todate(String todate) {
		sq_po.toDate_messages_input().sendKeys(todate);
		sq_po.toDate_messages_input().sendKeys(Keys.ENTER);
	}
//click search button
	public void click_search() {
		sq_po.search_button().click();
	}


//	click next page
	public void click_nextpage(){
		sq_po.nextPage().click();
	}
}
