

package main;

import email.Enviar;

public class Main {

 
    public static void main(String[] args) {
        String remetente;
        String para;
        String assunto;
        String mensagem;
        
        //enviar email em modo texto
        remetente="Fulano";
        para="email@email.com";
        assunto="assunto";
        mensagem = "mensagem";
        
        Enviar e1 = new Enviar();
        e1.enviar_email(remetente, para,assunto, mensagem);
    }
    
}
