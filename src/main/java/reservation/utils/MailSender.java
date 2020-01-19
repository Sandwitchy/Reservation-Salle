package reservation.utils;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
    private String username = "xinjeyslyerx@gmail.com";
    private String password = "slyerx6798";
    private String destinataire;
    private String nom;
    private String salle;
    private String description;
    private String horaire;

    public MailSender(String destinataire, String nom, String description, String salle, String horaire){
        this.destinataire = destinataire;
        this.nom = nom;
        this.description = description;
        this.salle = salle;
        this.horaire = horaire;
    }
    public void envoyer() {
        // Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
        });
        try {
            // Etape 2 : Création de l'objet Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xinjeyslyerx@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.destinataire));
            message.setSubject("Rendez vous en salle " + this.salle);
            message.setText("Bonjour, \n"
            +"Vous êtes conviez à la réunion : \n"
                            +"Organisateur : " + nom + "\n"
                            +"Horaire : " + horaire + "\n"
                            +"Salle : " + salle + "\n"
                            +"Description : " + description + "\n"
            );
            // Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } }
}
