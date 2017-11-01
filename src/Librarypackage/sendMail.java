
package Librarypackage;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
//import sun.rmi.transport.Transport;

public class sendMail {

    public boolean sendMail(String from, String password, String Message, String to[]) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(from));
            // now get the address of recipients
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            // Now add all the toAddress element to mimeMessage
            for (int i = 0; i < toAddress.length; i++) {
                mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);
            }
            // add Subject
            mimeMessage.setSubject("Recover your Password");
            // set message to mimeMessage
            mimeMessage.setText(Message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Connection error!!!");
           // Logger.getLogger(RecoverDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
