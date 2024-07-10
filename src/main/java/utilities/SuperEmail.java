package utilities;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

public class SuperEmail {
	
//	Default values
	String username = "yaman.maharjan@javra.com";
	String password = "!wertyu$@AQW";

//	Reads the txt file and returns as String
	public static String readFileAsString(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

//	send email using Html Tags (uses org.apache.commons.mail.HtmlEmail)
	public static void sendEmail(String username, String password, String to, String subject, String message) throws Exception {
		// Create an HtmlEmail object
		HtmlEmail email = new HtmlEmail();
		String host = "smtp.office365.com";
		int port = 587;
//		String username = ExcelRead.getData(19, 1, "variables");
//		String password = ExcelRead.getData(20, 1, "variables");
		// Set the email properties
		email.setHostName(host);
		email.setSmtpPort(port);
		email.setAuthentication(username, password);
		email.setStartTLSEnabled(true);

		// Set the email content
		email.setFrom(username);
		email.addTo(to);
		email.setSubject(subject);

		email.setMsg(message);

		// Send the email
		email.send();
		System.out.println("sendEmail--------------Email Sent");
	}

//	send email using Html Tags (uses org.apache.commons.mail.HtmlEmail)
	public static void sendEmailUsingFileContent(String username, String password, String to, String subject, String filePath) throws Exception {
		// Create an HtmlEmail object
		HtmlEmail email = new HtmlEmail();

		// Set the email properties
		email.setHostName("smtp.office365.com");
		email.setSmtpPort(587);
		email.setAuthentication(username, password);
		email.setStartTLSEnabled(true);

		// Set the email content
		email.setFrom(username);
		email.addTo(to);
		email.setSubject(subject);

//	      set the message from the txt file 
//	      use for ILS, PROCART and HtmlMsg
		String message = readFileAsString(filePath);

		email.setMsg(message);

//	      email.setMsg works for both normal text content and HTML content
//	      email.setHtmlMsg(content);

		// Send the email
		email.send();
		System.out.println("sendEmailUsingFileContent--------------Email Sent");
	}

	public static void sendEmailWithFileAttachment(String username, String password,  String to, String subject, String message, String attachmentPath) {
		try {
			// Create an HtmlEmail object
			HtmlEmail email = new HtmlEmail();

			// Set the email properties
			email.setHostName("smtp.office365.com");
			email.setSmtpPort(587);
			email.setAuthentication(username, password);
			email.setStartTLSEnabled(true);

			// Set the email content
			email.setFrom(username);
			email.addTo(to);
			email.setSubject(subject);
			email.setMsg(message);

			// Create an EmailAttachment object and add it to the email
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(attachmentPath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
//			attachment.setDescription("Attachment");
//			attachment.setName("RFQ.json");
			email.attach(attachment);

			// Send the email
			email.send();
			System.out.println("sendEmailWithFileAttachment--------------Email Sent");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
