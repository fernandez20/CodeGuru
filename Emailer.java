import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailer {
  private String from = "do-not-reply@clubguru.edu";
  private final String USER = "fernandee";
  private final String PASS = "atomhacksV5/";
  private final String smtphost = "express-relay.jangosmtp.net";
  private Properties prop = new Properties();
  private Scanner console;
  Session sessionobj;
  
  
  public Emailer() {
    console = new Scanner(System.in);
    prop.put("mail.smtp.auth", true);
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", smtphost);
    prop.put("mail.smtp.port", "25");
    sessionobj = Session.getInstance(prop,
                                             new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USER, PASS);
      }
    });
  }
  
  public void sendMsg(String to, String message, String subject) {
    try {
      //Create MimeMessage object & set values
      Message messageobj = new MimeMessage(sessionobj);
      messageobj.setFrom(new InternetAddress(from));
      messageobj.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
      messageobj.setSubject(subject);
      messageobj.setText(message);
      //Now send the message
      Transport.send(messageobj);
      //System.out.println("Your email sent successfully....");
    } catch (MessagingException exp) {
      throw new RuntimeException(exp);
    }
  }
  
  public void email(String address) { }
    
  
  public void email(ArrayList<Member> recipients) {
    System.out.print("Enter the subject.");
    String sub = console.nextLine();
    System.out.print("Enter the message.");
    String msg = console.nextLine();
    for (Member m : recipients) {
      String mail = "Hi " + m.getName() + ", your club leader has sent you the following message.\n\n" + msg;
      sendMsg(m.getEmail(), mail, sub);
    }
  }
}