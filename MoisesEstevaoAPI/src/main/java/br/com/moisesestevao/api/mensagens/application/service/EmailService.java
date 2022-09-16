package br.com.moisesestevao.api.mensagens.application.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public Integer send(String from,String fromName, String subject, String text){
        String to="moisesestevao2004@hotmail.com";

        log.info("Trying to send email to "+to+" from "+from);

        var message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText("Mensagem enviada por: "+fromName+"\nEmail: "+from+"\n\n"+text);
        try{
            javaMailSender.send(message);
            log.info("Email sent to "+to+" from "+from);
            return 0;
        }catch (Exception e){
            log.error("Error occurred during your email to"+to+" from "+from);
            e.printStackTrace();
            return 1;
        }
    }
}
