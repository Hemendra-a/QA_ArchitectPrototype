package utils;

import Reader.PropertiesReader;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class EmailUtility {
//    private PropertiesReader prop;
//    public EmailUtility(PropertiesReader prop){
//        this.prop=prop;
//    }


    public void sendEmail(String projectName, String[] toRecipients, String[] ccRecipients, String user, String password, String exceptions, String teamType,String Id,String TicketId,String startDateTime,String endDateTime) {
        // SMTP server details
        String host = "smtp.gmail.com";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH_mm_ss");
        // Set mail properties
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From field
            message.setFrom(new InternetAddress(user));

            // Set To recipients if provided
            if (toRecipients != null && toRecipients.length > 0) {
                InternetAddress[] toAddresses = new InternetAddress[toRecipients.length];
                for (int i = 0; i < toRecipients.length; i++) {
                    toAddresses[i] = new InternetAddress(toRecipients[i]);
                }
                message.setRecipients(Message.RecipientType.TO, toAddresses);
            }

            // Set CC recipients if provided
            if (ccRecipients != null && ccRecipients.length > 0) {
                InternetAddress[] ccAddresses = new InternetAddress[ccRecipients.length];
                for (int i = 0; i < ccRecipients.length; i++) {
                    ccAddresses[i] = new InternetAddress(ccRecipients[i]);
                }
                message.setRecipients(Message.RecipientType.CC, ccAddresses);
            }

            // Set Subject
            message.setSubject("PB Bot: "+projectName + " - Exception Alert");

            // Create the message body (using HTML for formatting)
            MimeMultipart multipart = new MimeMultipart();

            // Text body part (with HTML content)
            MimeBodyPart textPart = new MimeBodyPart();

            // Determine email body based on team type
            String htmlContent;
            if ("PB".equalsIgnoreCase(teamType)) {
                // Email body for PB Team
//                htmlContent = "<html><body>" +
//                        "<p>Hi PB Team,</p>" +
//                        "<p>The Bot has stopped due to the following exception:</p>" +
//                        "<p><span style='background-color: yellow;'>" + exceptions + "</span></p>" +
//                        "<p>Require your immediate attention on the same.</p>" +
//                        "<p><b>Best Regards,<br>Krishna Yadav<br>+91 8318135826</b></p>" +
//                        "</body></html>";
                htmlContent = "<html><body>" +
                        "<p>Dear PB Team,</p>" +
                        "<p><b>Issue Alert:</b> The Bot has encountered an issue and stopped processing. Below are the details:</p>" +
                        "<table style='border: 1px solid black; border-collapse: collapse; width: 80%;'>" +
                        "<tr style='background-color: #f2f2f2;'>" +
                        "<th style='border: 1px solid black; padding: 8px;'>Parameter</th>" +
                        "<th style='border: 1px solid black; padding: 8px;'>Details</th>" +
                        "</tr>" +
                        "<tr>" +

                        "<td style='border: 1px solid black; padding: 8px;'>Ticket id</td>" +
                        "<td style='border: 1px solid black; padding: 8px; background-color: #fff3cd;'>" + TicketId + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>Insurer</td>" +
                        "<td style='border: 1px solid black; padding: 8px; background-color: #fff3cd;'>" + projectName + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>Exception</td>" +
                        "<td style='border: 1px solid black; padding: 8px; background-color: #fff3cd;'>" + exceptions + "</td>" +
                        "</tr>" +
                        "<tr>" +

                        "<td style='border: 1px solid black; padding: 8px;'>Start time</td>" +
                        "<td style='border: 1px solid black; padding: 8px; background-color: #fff3cd;'>" + startDateTime + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>End time</td>" +
                        "<td style='border: 1px solid black; padding: 8px; background-color: #fff3cd;'>" + endDateTime + "</td>" +
                        "</tr>"+

                        "</table>" +
                        "<p>Please review and address this issue at the earliest.</p>" +
                        "<p>If additional support is required, feel free to reach out to the development team.</p>" +
                        "<p><b>Best Regards,</b></p>" +
                        "<p>Development Team<br>" +
                        "</p>" +
                        "</body></html>";

            } else if ("Dev".equalsIgnoreCase(teamType)) {
                // Email body for Dev Team
//                htmlContent = "<html><body>" +
//                        "<p>Hi Dev Team,</p>" +
//                        "<p>The following exception occurred in the application:</p>" +
//                        "<p><span style='background-color: yellow;'>" + exceptions + "</span></p>" +
//                        "<p>Please investigate and resolve the issue at the earliest.</p>" +
//                        "<p><b>Best Regards,<br>Krishna Yadav<br>+91 8318135826</b></p>" +
//                        "</body></html>";
                htmlContent="<html><body>" +
                        "<p>Dear Development Team,</p>" +
                        "<p><b>Issue Alert:</b> An exception has been encountered in the application. Below are the details:</p>" +
                        "<table style='border: 1px solid black; border-collapse: collapse; width: 80%;'>" +
                        "<tr style='background-color: #f2f2f2;'>" +
                        "<th style='border: 1px solid black; padding: 8px;'>Parameter</th>" +
                        "<th style='border: 1px solid black; padding: 8px;'>Details</th>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>Exception</td>" +
                        "<td style='border: 1px solid black; padding: 8px; background-color: #fff3cd;'>" + exceptions + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>ID</td>" +
                        "<td style='border: 1px solid black; padding: 8px;'>["+Id+"]</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>Time of Issue</td>" +

                        "<td style='border: 1px solid black; padding: 8px;'>" + java.time.LocalDateTime.now().format(formatter) + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td style='border: 1px solid black; padding: 8px;'>Priority</td>" +
                        "<td style='border: 1px solid black; padding: 8px;'>High</td>" +
                        "</tr>" +
                        "</table>" +
                        "<p><b>Action Required:</b> Please investigate and resolve the issue at the earliest to ensure smooth functionality of the application.</p>" +
                        "<p>If you need further details or support, feel free to contact me directly.</p>" +
                        "<p><b>Best Regards,</b></p>" +
                        "<p>Development Team<br>" +
                        "</p>" +
                        "</body></html>";
            } else {
                throw new IllegalArgumentException("Invalid team type specified. Use 'PB' or 'Dev'.");
            }

            textPart.setContent(htmlContent, "text/html");
            multipart.addBodyPart(textPart);

            // Set the multipart content to the message
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException | IllegalArgumentException e) {
            System.out.println("Error occurred while sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to return specific exception details
    public static String getExceptionsBasedOnScenario(String exceptions) {
        String body;

        switch (exceptions) {
            case "SE1":
                body = "The portal is not loading or not landing on the login page";
                break;
            case "SE2":
                body = "Not able to login with User ID and Password";
                break;
            case "SE3":
                body = "Unable to retrieve the response through API";
                break;
            case "SE4":
                body = "Unable to find the elements";
                break;

            default:
                body = "Unknown exception occurred.";
                break;
        }

        return body;
    }



}