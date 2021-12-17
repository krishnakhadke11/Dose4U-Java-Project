package com.Dose4U;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
class Email {
    public void send(String from, String password, String to, String sub, String msg) {
        // get Session
        Session session = getSession(from, password, "smtp.gmail.com", 587);
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            // send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private Session getSession(String username, String password, String smtpHost, int smtpPort) {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        return Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }


    public static void main(String[] args) {
        //from,password,to,subject,message
         Email mail=new Email();
        mail.send("reminder.dose4u@gmail.com","tdsslrrbmnrpikiy","krishnakhadke11@gmail.com","hello Krishna here!Testin","How r u?");
        //change from, password and to
    }
}
