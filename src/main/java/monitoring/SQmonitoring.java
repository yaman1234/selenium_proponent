package monitoring;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.TableData;
import utilities.UtilBase;

public class SQmonitoring extends UtilBase {

	@BeforeClass
	public void beforeClass() {
//		logging
		log.info("start :: SQmonitoring");
	}

	@Test(priority = 1)
	public void test1() throws InterruptedException {
		String testname = "SQ monitor";

		String fromdate = "2024-07-01";
		String todate = getCurrentDate();

		printCases(testname, fromdate, todate);
		
//		need to handle 
//		when no data is found by search
//		pagination
//		findElments returns List getTotalLiPagination gives total no of li elements
			List<WebElement> pageList = driver.findElements(By.xpath("//*[@id='root']/div/div/div/div/div/div/ul/li"));
			int totalLi = pageList.size();
			log.info("pageList size" + totalLi);
//			get the last li Element
			WebElement lastLiElement = driver
					.findElement(By.cssSelector("#root > div > div > div > div > div > div > div > ul > li:nth-child(" + (totalLi) + ")"));

			String liTitle = lastLiElement.getAttribute("title");
//			20/pages is not recognized by lastLiElement.getAttribute("title"). so used if method 
			if (liTitle.equals("Next Page")) {
				WebElement lastPage = driver
						.findElement(By.cssSelector("#root > div > div > div > div > div > div > div > ul > li:nth-child(" + (totalLi - 1) + ")"));
				int count = Integer.parseInt(lastPage.getText());
				System.out.println("Total no of pages:" + count);

				for (int counter = 1; counter <= count; counter++) {
					sq_po.nextPage().click();
					Thread.sleep(4000);
				}

			} else {
//				Last page = n-2
				WebElement lastLiElement2 = driver
						.findElement(By.cssSelector("#root > div > div > div > div > div > div > div > ul > li:nth-child(" + (totalLi - 2) + ")"));

				int count = Integer.parseInt(lastLiElement2.getText());
				System.out.println("Total no of pages: " + count);

				for (int counter = 1; counter <= count; counter++) {
					sq_po.nextPage().click();
//					driver.findElement(By.xpath("//li[@title='Next Page']")).click();
					Thread.sleep(4000);
				}

			}
			
//			System.out.println("Total rows of data: " + colData.size());
//		list all datas
		
	}

	public void printCases(String testname, String fromdate, String todate) {
		try {
			test = extent.createTest(testname);

			sq_po.messages_link().click();
			Thread.sleep(2000);

			sq_po.fromDate_input().sendKeys(fromdate);
			sq_po.fromDate_input().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			sq_po.toDate_input().sendKeys(todate);
			sq_po.toDate_input().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			sq_po.search_button().click();
			Thread.sleep(3000);

//			get row count

			WebElement tableElement = sq_po.table();

			int rowcount = TableData.getRowCount(tableElement);
			log.info("Rowcount :: " + rowcount);

			// Creating a list of lists
			List<List<Object>> datalist = new ArrayList<>();
	

			for (int i = 0; i < rowcount; i++) {
				List<String> rowData = TableData.getRowData(tableElement, i);
				// Adding objects to the list
				List<Object> case1 = new ArrayList<>();
				case1.add(rowData.get(0));
				case1.add(rowData.get(1));
				case1.add(rowData.get(2));
				case1.add(rowData.get(3));
				case1.add(rowData.get(4));
				datalist.add(case1);
				log.info(datalist.get(i).toString());
			}

//			count number of status
			int count = 0;
			for (List<Object> obj : datalist) {
				if (obj.get(4).equals("IGNORED")) {
					count++;
				}

			}
			log.info("count by status :: " + count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			testFailed(testname);
		}
	}
	
	public static String getCurrentDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return today.format(formatter);
	}

	@AfterClass
	public void afterClass() {
		log.info("END :: SQmonitoring");
	}

}
