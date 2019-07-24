package service.impl;

import org.apache.log4j.Logger;
import service.MailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    public MailServiceImpl() {
    }

    @Override
    public void send(String email, String code) {

        try {
            final String username = "test123test178@gmail.com";
            final String password = "Svistylin123";
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test123test178@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear user please enter this code  " + code);
            Transport.send(message);
        } catch (AddressException e) {
            LOGGER.info("incorrect adress", e);
        } catch (MessagingException e) {
            LOGGER.info("Some problems happed", e);
        }
    }
}

