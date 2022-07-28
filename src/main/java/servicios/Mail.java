package servicios;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    /*public static void main(String[] args) {
        enviarMail();
    }*/

    public void enviarMail(String nombre, String celular, String direccion, String correo,String descripcion) {
        final String username = "alexanderminaya064@gmail.com";
        final String password = "igoqqtxuhqhpeibt";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust","*");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(correo)
            );
            message.setSubject("Consultas y Reclamos en el Hotel Preinkai");
            message.setText("Hola amigo(a) " + nombre + " con residencia en " + direccion + ", su mensaje (" + descripcion + 
                    ") ha sido correctamente enviado, le responderemos en su celular " + celular + "\n¡Saludos! Atte. El Administrador");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
