package uam.admision.sendmail.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uam.admision.sendmail.Model.Mail;
import org.slf4j.Logger;
import uam.admision.sendmail.Service.EmailService;



@Controller
public class SendMailController {

    @Autowired
    private EmailService emailService;

    private static final Logger log = LoggerFactory.getLogger(SendMailController.class);

    @RequestMapping(value = {"/","index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/envio/enviaCorreo")
    public String muestraPedidos() {
        return "enviaCorreo";
    }
    @RequestMapping(value = "/envio/enviaCorreo", params = {"enviar"})
    public String enviaCorreo() {
        //log.info("Spring Mail - Sending Simple Email with JavaMailSender Example");
        for(int i=0; i < 5; i++) {
            try {
                Mail mail = new Mail();
                mail.setFrom("no-reply@memorynotfound.com");
                mail.setTo("info@memorynotfound.com");
                mail.setSubject("Sending Simple Email with JavaMailSender Example");
                mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

                emailService.sendSimpleMessage(mail);
            } catch (Exception e) {
                log.error("Error al enviar mail");
                e.printStackTrace();
            }
        }
        return "enviaCorreo";
    }
}
