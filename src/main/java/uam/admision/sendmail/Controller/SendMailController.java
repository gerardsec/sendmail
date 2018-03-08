package uam.admision.sendmail.Controller;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uam.admision.sendmail.Model.DatosEntrada;
import uam.admision.sendmail.Model.Mail;
import org.slf4j.Logger;
import uam.admision.sendmail.Service.EmailService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class SendMailController {

    private static final Logger log = LoggerFactory.getLogger(SendMailController.class);
    private static String UPLOADED_FOLDER = "/Users/uamadm01/Data/files_sendmail/";
    String fileName;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/envio/enviaCorreo")
    public String enviaCorreoForma() {
        return "enviaCorreo";
    }

    @RequestMapping(value = "/envio/enviaCorreo", params = {"enviar"})
    public String enviaCorreo() {
        //log.info("Spring Mail - Sending Simple Email with JavaMailSender Example");
        for (int i = 0; i < 5; i++) {
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

    @RequestMapping(value = "/envio/archivoDatos")
    public String archivoDatos() {
        return "archivoDatos";
    }

    @RequestMapping(value = "/envio/archivoDatos", params = {"datos"})
    public String archivoDatosRecibe(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        fileName = file.getOriginalFilename();
        System.out.println(file.getName());
        log.warn("Archivo de datos:" + fileName);
        if (fileName.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Archivo vacío. Seleccione uno");
            return "redirect:/envio/archivoDatos";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "El archivo se guardó correctamente: " + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Error al guardar el archivo");
            e.printStackTrace();
        }
        //Conversión a CSV en un Array
        String stringFileName = UPLOADED_FOLDER + file.getOriginalFilename();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(stringFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<DatosEntrada> listaCorreo = new CsvToBeanBuilder(fileReader).withType(DatosEntrada.class).build().parse();
        //Muestra de datos
        for (int i = 0; i < listaCorreo.size() && i < 10; i++) {
            DatosEntrada datosEntrada = listaCorreo.get(i);
            System.out.println(datosEntrada.toString());
        }

        return "redirect:/envio/enviaCorreo";
    }
}
