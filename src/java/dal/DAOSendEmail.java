/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author This PC
 */
public class DAOSendEmail {

    public void send(String m, String sub, String messg) {

        final String user = "swpgroup2@gmail.com";

        final String pass = "A123456@";

        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.host", "gmail");

        props.put("mail.user", "quocthhe150051@fpt.edu.vn");

        props.put("mail.password", "quoc1910");

        props.put("mail.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

            @Override

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(user, pass);

            }

        });

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(m));

            message.setSubject(sub);

            message.setText(messg);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }
    private static Random generator = new Random();

    public String RanCode() {

        String ALPHA_NUMERIC = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public String RegisterNoti() {
        return "We send you an email confirmation code";
    }
}
