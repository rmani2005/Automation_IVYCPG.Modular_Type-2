package org.ivymobility.com.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	public static void main(String[] args) {
		MAILSEND("1.6");
	}

	
	  public static String MAILSEND(String JARVERSION) {
	      // Recipient's email ID needs to be mentioned.
		   String to = "ravikumar.c@ivymobility.com";
	    /* String cc1 = "senthil.m@ivymobility.com";
	      String cc2 = "selva.d@ivymobility.com";
	      String cc3 = "shivaguru.r@ivymobility.com";
	      String cc4 = "gayathri.r@ivymobility.com"; */

	      // Sender's email ID needs to be mentioned
	      String from = "noreply_test@ivy-mobility.com";

	      final String username = "AKIAJ7JK4GFKZMYZSIZQ";//change accordingly
	      final String password = "AtHMgvcIN0Mr0cbEJUSaxjoY8VwbaEaW6q1Qdv24R25b";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "email-smtp.us-east-1.amazonaws.com";
	      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.EnableSSL.enable","true"); 
	      props.put("mail.smtp.port", "465");
	      props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	      props.setProperty("mail.smtp.socketFactory.fallback", "false");
	      props.setProperty("mail.smtp.socketFactory.port", "465");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(to));
	  /*       message.setRecipients(Message.RecipientType.CC,
	                 InternetAddress.parse(cc1));
	         message.setRecipients(Message.RecipientType.CC,
	                 InternetAddress.parse(cc2));
	         message.setRecipients(Message.RecipientType.CC,
	                 InternetAddress.parse(cc3));
	         message.setRecipients(Message.RecipientType.CC,
	                 InternetAddress.parse(cc4));*/
	         

	         // Set Subject: header field
	         message.setSubject("IvyCPG_Automation_Results - "+JARVERSION);

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();
	        
	         // Now set the actual message
	         messageBodyPart.setText("PFA for IVYCPG_Automation - "+JARVERSION+" Results \n\n "
	         		+ "\n NOTE: This is an Automated mail,dont reply...!");
	        

	         // Create a multipart message
	         Multipart multipart = new MimeMultipart("related");

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);
	         

	         // Part two is attachment
	         //TC Attachment
	         MimeBodyPart mb1 = new MimeBodyPart();
	 //      String filename = "D:/OFFICE/Selinium/CPG_Product_Automation/Automation_TC_WEB_V1.xls";
	         String filename = "D:\\Data\\f1\\f1\\test-output\\emailable-report.html";
	         DataSource source = new FileDataSource(filename);
	         mb1.setDataHandler(new DataHandler(source));
	         mb1.setFileName(filename);
	         multipart.addBodyPart(mb1);
	         
	         //FC Attachment
	         MimeBodyPart mb2 = new MimeBodyPart();
//	         String filename1 = "D:/OFFICE/Selinium/CPG_Product_Automation/Failcaseresults.xls";
	         String filename1 = "D:\\Data\\f1\\f1\\test-output\\html\\index.html";
	         DataSource source1 = new FileDataSource(filename1);
	         mb2.setDataHandler(new DataHandler(source1));
	         mb2.setFileName(filename1);
	         multipart.addBodyPart(mb2);
	         
	     //Applog Attachment
	         MimeBodyPart mb3 = new MimeBodyPart();
//	         String filename2 = "D:/OFFICE/Selinium/CPG_Product_Automation/Logs & Screenshots/Log/Applog.log";
	         String filename2 = "D:\\Data\\f1\\f1\\src\\com\\selenium\\logs\\IvyMobility.log";
	         DataSource source2 = new FileDataSource(filename2);
	         mb3.setDataHandler(new DataHandler(source2));
	         mb3.setFileName(filename2);
	         multipart.addBodyPart(mb3);
	         
	         //Errorlog Attachment
	         /*MimeBodyPart mb4 = new MimeBodyPart();
//	         String filename3 = "D:/OFFICE/Selinium/CPG_Product_Automation/Logs & Screenshots/Log/Errorlog.log";
	         String filename3 = "D:/Automation/CPG_Product_Automation-V2.0/Logs & Screenshots/Log/Errorlog.log";
	         DataSource source3 = new FileDataSource(filename3);
	         mb4.setDataHandler(new DataHandler(source3));
	         mb4.setFileName(filename3);
	         multipart.addBodyPart(mb4); */

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         try{
	         Transport.send(message);
	         System.out.println("Sent Mail successfully....");
	         String Result="Mail Sent Successfully....";
	         return Result;
	         }
	         catch (MessagingException e) {
	             throw new RuntimeException(e);
	          }
	         
	         
	  
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
}
