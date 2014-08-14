
package email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;




public class AutenticarEmail extends Authenticator{

    public AutenticarEmail() {
    }
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        //conta spammer
    //return new PasswordAuthentication("email sem @...", "senha");
        return new PasswordAuthentication("", "");
    }
}
