/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.SpringLayout;

/**
 *
 * @author Allan
 */
public class Controlator {

    

    public boolean IsEmailSended(Email email) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.port", "587");
            properties.setProperty("mail.smtp.user", email.getUserEmail());
            properties.setProperty("mail.smtp.auth", "true");

            Session section = Session.getDefaultInstance(properties, null);
            BodyPart text = new MimeBodyPart();
            text.setText(email.getMessage());
            BodyPart adjunct = new MimeBodyPart();
            if (!email.getFilePath().equals("")) {
                adjunct.setDataHandler(new DataHandler(new FileDataSource(email.getFilePath())));
                adjunct.setFileName(email.getFileName());
            }
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(text);
            if (!email.getFileName().equals("")) {
                m.addBodyPart(adjunct);
            }
            MimeMessage message = new MimeMessage(section);
            message.setFrom(new InternetAddress(email.getUserEmail()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getDestination()));
            message.setSubject(email.getIssue());
            message.setContent(m);

            Transport transport = section.getTransport("smtp");
            transport.connect(email.getUserEmail(), email.getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;

        } catch (Exception e) {
            System.err.println("Error "+e);
            return false;
        }

    }
}
