package uam.admision.sendmail.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uam.admision.sendmail.Model.Mail;

import javax.mail.SendFailedException;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setTo(mail.getTo());
        message.setFrom(mail.getFrom());
        System.out.println(mail.getFrom());
        System.out.println(mail.getTo());
        //log.warn("Enviando mail con send");
        try {
          //  log.warn("intentando mail con send");
            emailSender.send(message);
            log.warn("...enviado mail");
        }
        catch (MailSendException e){
            log.error("erorres mailsend:");
            e.printStackTrace();
        } catch (MailAuthenticationException f) {
            log.error("erorres authent:");
            f.printStackTrace();
        } catch (MailException g) {
            log.error("error en el formato del correo");
            g.printStackTrace();
        }

    }
}