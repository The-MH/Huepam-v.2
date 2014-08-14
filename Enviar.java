
package email;

import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Enviar {
    
    public void enviar_email(String remetente, String para, String assunto, String mensagem){
        try {
            
            Session mailSession = null;
            Properties props = null;
            Message message = null;
            
            //se a conta spammer for hotmail deixe: smtp.hotmail.com |gmail:smtp.gmail.com|e o mesmo com outros tipos de email 
            String smtp = "smtp.gmail.com";
            
            props = new Properties();
            props.put("mail.smtp.host", smtp);
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.auth", "true");
            
            props.put("mail.debug", "true");
            
            AutenticarEmail a1 = new AutenticarEmail();
            
            mailSession = Session.getInstance(props, a1);
            
            System.out.println("Conectou no e-mail!!!");
            
            Address de = new InternetAddress(remetente);
            Address [] para2 = InternetAddress.parse(para, false);
            message = new MimeMessage(mailSession);
            message.setFrom(de);
            message.setRecipients(Message.RecipientType.TO,para2);
            message.setSubject(assunto);
            message.setSentDate(Calendar.getInstance().getTime());
            message.setText(mensagem);
            
            System.out.println("Preparando para enviar...");
            Transport.send(message);
            System.out.println("Enviou!");
        } catch (MessagingException ex) {
            Logger.getLogger(Enviar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
