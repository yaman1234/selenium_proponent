package monitoring;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.DateOperations;
import utilities.TableData;
import utilities.UtilBase;

public class SQmonitoring extends UtilBase {

	HelperSQ cmd_sq = new HelperSQ();
	// Creating a list of lists to store the values
	List<List<Object>> datalist_messages = new ArrayList<>();
	List<List<Object>> datalist_caseEmails = new ArrayList<>();
	

	@BeforeClass
	public void beforeClass() {
//		logging
		logger = LogManager.getLogger(SQmonitoring.class);
		logger.info("start :: SQmonitoring");
	}

	@Test(priority = 1)
	public void monitoring_messages() throws InterruptedException {

		try {

//		String fromdate = "2024-07-01";
			String fromdate = DateOperations.getYesterdaysDate();
			String todate = DateOperations.getCurrentDate();

			cmd_sq.click_messages();
			Thread.sleep(6000);

			cmd_sq.enter_fromdate(fromdate);
			cmd_sq.enter_todate(todate);
			Thread.sleep(1000);
			cmd_sq.click_search();
			Thread.sleep(4000);

			int lastpage = cmd_sq.getLastPage("messages");
			logger.info("Last Page :: " + lastpage);

			listAllCases(lastpage, datalist_messages);

			logger.info("/*-----------------------------------------------------------------");
			logger.info("Total Cases 	:: " + cmd_sq.getTotalCases(datalist_messages));
			logger.info("NEW  			:: " + cmd_sq.getCountByStatus("messages",datalist_messages, "NEW"));
			logger.info("RECEIVED  		:: " + cmd_sq.getCountByStatus("messages",datalist_messages, "RECEIVED"));
			logger.info("PROCESSING  	:: " + cmd_sq.getCountByStatus("messages",datalist_messages, "PROCESSING"));
			logger.info("DUPLICATE 		:: " + cmd_sq.getCountByStatus("messages",datalist_messages, "DUPLICATE"));
			logger.info("IGNORED 		:: " + cmd_sq.getCountByStatus("messages",datalist_messages, "IGNORED"));
			logger.info("FAILED 		:: " + cmd_sq.getCountByStatus("messages",datalist_messages, "FAILED"));
			logger.info("NOT_IDENTIFIED :: " + cmd_sq.getCountByStatus("messages",datalist_messages, "NOT_IDENTIFIED"));
			logger.info("/*-----------------------------------------------------------------");

		} catch (Exception e) {
			logger.info("Exception Occured ::" + e);
		}

	}

	@Test(priority = 2)
	public void monitor_caseEmails() {

		try {
//			String fromdate = "2024-07-01";
			String fromdate = DateOperations.getYesterdaysDate();
			String todate = DateOperations.getCurrentDate();


			cmd_sq.click_caseEmails();
			Thread.sleep(8000);

			sq_po.fromDate_caseEmails_input().sendKeys(fromdate);
			sq_po.fromDate_caseEmails_input().sendKeys(Keys.ENTER);
			sq_po.toDate_caseEmails_input().sendKeys(todate);
			sq_po.fromDate_caseEmails_input().sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			sq_po.search_button().click();
			Thread.sleep(4000);

			int lastpage = cmd_sq.getLastPage("caseEmails");
			logger.info("Last Page :: " + lastpage);

			listAllCases(lastpage, datalist_caseEmails);

			logger.info("/*-----------------------------------------------------------------");
			logger.info("Total Cases 	:: " + cmd_sq.getTotalCases(datalist_caseEmails));
			logger.info("NEW			:: " + cmd_sq.getCountByStatus("caseemails", datalist_caseEmails, "NEW"));
			logger.info("RECEIVED  		:: " + cmd_sq.getCountByStatus("caseemails",datalist_caseEmails, "RECEIVED"));
			logger.info("IN PROGRESS  	:: " + cmd_sq.getCountByStatus("caseemails",datalist_caseEmails, "IN-PROGRESS"));
			logger.info("READY			:: " + cmd_sq.getCountByStatus("caseemails",datalist_caseEmails, "COMPLETED"));
			logger.info("COMPLETED 		:: " + cmd_sq.getCountByStatus("caseemails",datalist_caseEmails, "READY"));
			logger.info("FAILED 		:: " + cmd_sq.getCountByStatus("caseemails",datalist_caseEmails, "FAILED"));
			logger.info("CLOSED 		:: " + cmd_sq.getCountByStatus("caseemails",datalist_caseEmails, "CLOSED"));
			logger.info("/*-----------------------------------------------------------------");

		} catch (Exception e) {
			logger.error("Exception caught :: " + e);
		}

	}

	public void listAllCases(int lastpage, List<List<Object>> datalist) {
		try {
			WebElement tableElementInstance = null;

			for (int i = 1; i <= lastpage; i++) {
				logger.info("Page no :: " + i);

				tableElementInstance = sq_po.table();

				// print all rows of the current page
				printAllRowsOfPage(tableElementInstance, datalist);
				// click next page
				cmd_sq.click_nextpage();
				// Wait for 2 seconds for the next page to load
				Thread.sleep(3000);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info(e);

		}

	}

	public void printAllRowsOfPage(WebElement tableElement, List<List<Object>> datalist) {
		// Get row count
		int rowCount = TableData.getRowCount(tableElement) - 1;
		int colCount = TableData.getColumnCount(tableElement);
		logger.info("Rowcount :: " + rowCount + ", ColCount :: " + colCount);

		for (int i = 0; i < rowCount; i++) {
			List<String> rowData = TableData.getRowData(tableElement, (i + 1));
			// Adding objects to the list
			List<Object> currentCase = new ArrayList<>();

			for (int j = 0; j < colCount; j++) {
				currentCase.add(rowData.get(j));
			}
			datalist.add(currentCase);
			logger.info(currentCase.toString());
		}
	}

	@AfterClass
	public void afterClass() {
		logger.info("END :: SQmonitoring");
	}

}
