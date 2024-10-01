package automated;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExcelRead;
import utilities.SuperEmail;

public class SendEmails {
//	VARIABLES USED FOR SENDING EMAIL
	protected static String expected_subject;
	static ExtentTest test, precondition;

//	Default values	
	String username_yaman = "yaman.maharjan@javra.com";
	String password_yaman = "Maharjan15772";

	String username_test = "javra.proponent@outlook.com";
	String password_test = "QUx*$WRfhg2j62";

//	EMAIL VARIABLES
	String to_esbox = "support@f9ya21ztyjdgxkc2qww8ub2mztcoxgpplv2c4lijqzc1dgvac.8m-mifuae.cs225.case.sandbox.salesforce.com";
	String to_sandy = "support@1ldrexti4r7nerq9kguybppid0t01nldqok5u0sa6cfwyl84pk.8h-4i4uuaa.cs220.case.sandbox.salesforce.com";
	String to_javraproj = "support@2rle760nav379fnelfbp2cy6n0guqfv92bhpj9gelckd2e4jxh.8i-qejhuau.cs221.case.sandbox.salesforce.com";
	String to_uat = "support@15hkz8kdu85kjra2tm4u5czi9doj35q1vqyjil5eboitbvxrxm.ru-1keddmak.usa490s.case.sandbox.salesforce.com";

	String filePath = System.getProperty("user.dir") + "\\testdata\\sample\\sample_ILS.txt";
	String attachmentPath = System.getProperty("user.dir") + "\\testdata\\sample\\RFQ.json";

	String ils_subject = "RFQ - From Guangdong Heritop Technology Entry Code:38QH-MAFO-RPEN";
//	String subject_rfq = "Test Email for RFQ";
//	String message_rfq = "Please provide quote for the PN: a5210-9p";

	String subject = "Test customer number";
	String message = "quote from the attachment";

	/*
	 * CHOOSE SalesForce environment String salesforce = to_esbox; String salesforce
	 * = to_sandy;
	 */
//	salesforce setup
	String salesforce = to_esbox;

	@Test(priority = 1)
	public void sendEmailForClassification() throws Exception {
//		sendProcart(username_yaman, password_yaman, salesforce);
//		sendILS(username_yaman, password_yaman, salesforce);
//		sendPortal(username_yaman, password_yaman, salesforce);

		
//		sendRfq(username_yaman, password_yaman, salesforce, "dfar");
//		sendRfq(username_yaman, password_yaman, salesforce, "phyCheReport");
//		sendRfq(username_yaman, password_yaman, salesforce, "cureDate");
//		sendRfqAttachmentsEmails(username_yaman, password_yaman, salesforce, "rfq");
		sendRfq(username_yaman, password_yaman, salesforce, "rfq");
//		sendRfq(username_test, password_test, salesforce, "chainEmails"ss);
//		sendRfqAttachments(username_yaman, password_yaman, salesforce);
//		sendPurchaseOrder(username_test, password_test, salesforce);
//		sendOrderStatus(username_yaman, password_yaman, salesforce);
//		sendReferral(username_yaman, password_yaman, salesforce);

	}

	public void sendRfqAttachmentsEmails(String username, String password, String salesforce, String sheet) {
		String sheetname = sheet;
		int count = ExcelRead.getRowCount(sheetname);
		for (int i = 1; i <= count; i++) {
//			String file_name = ExcelRead.getData(i, 0, "rfqAttachment");
//			String file_directory = ExcelRead.getData(1, 1, "rfq");
			String subject = ExcelRead.getData(i, 0, sheetname);
			String description = ExcelRead.getData(i, 1, sheetname);
			String attachment = ExcelRead.getData(i, 2, sheetname);
			System.out.println(i);
			System.out.println(attachment);
			SuperEmail.sendEmailWithFileAttachment(username, password, salesforce, subject, description, attachment);
//			break;
		}
	}

	public void sendRfq(String username, String password, String salesforce, String sheet) throws Exception {
		String sheetname = sheet;
		int count = ExcelRead.getRowCount(sheetname);
		System.out.println(count);
//		send RFQ email
		for (int i = 1; i <= count; i++) {
			String subject = ExcelRead.getData(i, 0, sheetname);
			String description = ExcelRead.getData(i, 1, sheetname);
			System.out.println(i);
			SuperEmail.sendEmail(username, password, salesforce, subject, description);
//			break;
		}
	}

	public void sendProcart(String username, String password, String salesforce) throws Exception {

		int count = ExcelRead.getRowCount("procart");
//		send RFQ email
		for (int i = 1; i <= count; i++) {
			String subject = ExcelRead.getData(i, 0, "procart");
			String description = ExcelRead.getData(i, 1, "procart");
			System.out.println(subject);
			SuperEmail.sendEmail(username, password, salesforce, subject, description);
//			break;
		}
	}

	public void sendILS(String username, String password, String salesforce) throws Exception {
		String sheetname = "ils";
		int count = ExcelRead.getRowCount(sheetname);
//		send RFQ email
		for (int i = 1; i <= count; i++) {
			String subject = ExcelRead.getData(i, 0, sheetname);
			String description = ExcelRead.getData(i, 1, sheetname);
			SuperEmail.sendEmail(username, password, salesforce, subject, description);
			System.out.println(subject);
//			break;
		}
	}

	public void sendPortal(String username, String password, String salesforce) {

		// send RFQ emails with attachment
		int count = ExcelRead.getRowCount("portal");
		for (int i = 1; i <= count; i++) {
			String file_name = ExcelRead.getData(i, 0, "portal");
			String file_directory = ExcelRead.getData(i, 1, "portal");
			String subject = "Portal Test(): " + ExcelRead.getData(i, 2, "portal");
			String description = "Please quote from the attachment";
			String attachment = file_directory + file_name;
			System.out.println(subject);
			SuperEmail.sendEmailWithFileAttachment(username, password, salesforce, subject, description, attachment);
//			break;
		}
	}

	public void sendRfqAttachments(String username, String password, String salesforce) {
		// send RFQ emails with attachment
		int count = ExcelRead.getRowCount("rfqAttachment");
		for (int i = 1; i <= count; i++) {
			String file_name = ExcelRead.getData(i, 0, "rfqAttachment");
			String file_directory = ExcelRead.getData(1, 1, "rfqAttachment");
			String subject = ExcelRead.getData(i, 2, "rfqAttachment");
			String description = "Please quote from the attachment";
			String attachment = file_directory + file_name;
			System.out.println(subject);
			SuperEmail.sendEmailWithFileAttachment(username, password, salesforce, subject, description, attachment);
//			break;
		}
	}

	public void sendPurchaseOrder(String username, String password, String salesforce) throws Exception {
//		int count = ExcelRead.getRowCount("purchaseOrder");
		for (int i = 1; i <= 3; i++) {
			String subject = ExcelRead.getData(i, 0, "purchaseOrder");
			String description = ExcelRead.getData(i, 1, "purchaseOrder");
			System.out.println(i);
			SuperEmail.sendEmail(username, password, salesforce, subject, description);
//			break;
		}
	}

	public void sendReferral(String username, String password, String salesforce) throws Exception {
		int count = ExcelRead.getRowCount("referral");
		for (int i = 1; i <= count; i++) {
			String subject = ExcelRead.getData(i, 0, "referral");
			String description = ExcelRead.getData(i, 1, "referral");
			System.out.println(i);
			SuperEmail.sendEmail(username, password, salesforce, subject, description);
//			break;

		}
	}

	public void sendOrderStatus(String username, String password, String salesforce) throws Exception {
		int count = ExcelRead.getRowCount("orderStatus");
		for (int i = 1; i <= 5; i++) {
			String subject = ExcelRead.getData(i, 0, "orderStatus");
			String description = ExcelRead.getData(i, 1, "orderStatus");
			System.out.println(i);
			SuperEmail.sendEmail(username, password, salesforce, subject, description);
//			break;
		}
	}

}
