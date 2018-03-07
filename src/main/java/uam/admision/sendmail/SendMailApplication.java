package uam.admision.sendmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uam.admision.sendmail.Model.Mail;
import uam.admision.sendmail.Service.EmailService;


    @SpringBootApplication
    public class SendMailApplication {

        public static void main(String[] args) {
            SpringApplication.run(SendMailApplication.class, args);
        }
    }



