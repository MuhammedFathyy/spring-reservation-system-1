package com.gradproject.yourspace.APIs;


import com.google.zxing.WriterException;
import com.gradproject.yourspace.Features.QRCodeGenerator;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendEmailService {

    @Autowired
    private SendGrid sendGrid;


    @Value("${sendgrid.from.email}")
    private String fromEmail;

    private String acceptanceContentMessage = "\n" +
            "Thank you for your interest in adding your coworking space to our website. " +
            "We appreciate your effort in providing the necessary information for consideration.\n" +
            "\n" +
            "We are pleased to inform you that your submission has been accepted, " +
            "and we will add your coworking space to our website. " +
            "However, we need some more information about the rooms in your Co-working space.\n" +
            "\n" +
            "To ensure that your listing is complete and accurate, " +
            "we would like to invite you to add the remaining information about your coworking space through our online platform." +
            "Please use the link provided below to access the platform and complete your listing:\n" +
            "\n" +
            "[Insert link to online platform]\n" +
            "\n" +
            "We encourage you to take the time to provide as much detail as possible about your coworking space. " +
            "This will help our users to make informed decisions when choosing a coworking space that meets their needs.\n" +
            "\n" +
            "If you have any questions or need assistance with completing your listing, " +
            "please do not hesitate to contact us. We are always happy to help.\n" +
            "\n" +
            "Thank you for choosing yourSpace.com to list your coworking space. We look forward to working with you.\n" +
            "\n" +
            "Best regards,\n" +
            "\n" +
            "YourSpaceTeam\n" +
            "\n" ;


    private String rejectionContentMessage = "\n" +
            "Thank you for your interest in adding your coworking space to our website. " +
                    "We appreciate your effort in providing the necessary information for consideration.\n" +
            "\n" +
            "After reviewing your submission, we regret to inform you that " +
                    "we are unable to add your coworking space to our website at this time. " +
                    "Unfortunately, the information you provided does not meet our requirements for inclusion.\n" +
            "\n" +
            "Please note that we require accurate and complete information to ensure the quality and reliability of our listings. " +
                    "We strive to provide our users with the most up-to-date and relevant information, " +
                    "and we are unable to make exceptions for incomplete or inaccurate submissions.\n" +
            "\n" +
            "We encourage you to review the submission guidelines on our website " +
                    "and to resubmit your request with accurate and complete information. " +
                    "We appreciate your interest in our website " +
                    "and hope that you will consider submitting your coworking space again in the future.\n" +
            "\n" +
            "Thank you for your understanding.\n" +
            "\n" +
            "Best regards,\n" +
            "\n" +
            "YourSpaceTeam\n" +
            "\n" ;

    public void sendEmail(String toEmail, String subject, String content, String encodedImage) throws IOException {
        Email from = new Email(fromEmail); // Create an email object for the sender email address
        Email to = new Email(toEmail); // Create an email object for the recipient email address
        Content emailContent = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, to, emailContent); // Create a Mail object to hold the email message

        Personalization personalization = new Personalization(); // Create a Personalization object to hold the recipient email address
        personalization.addTo(to); // Add the recipient email address to the Personalization object
        mail.addPersonalization(personalization); // Add the Personalization object to the Mail object
        if (encodedImage != null) {
            Attachments attachments = new Attachments();
            attachments.setContent(encodedImage);
            attachments.setType("image/png");
            attachments.setFilename("qrCode.png");
            attachments.setDisposition("attachment");
            attachments.setContentId("qrcode");
            mail.addAttachments(attachments);
        }

        //Convert the mail to JSON
        String json = mail.build();

        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(json);

        Response response = sendGrid.api(request);

        if (response.getStatusCode() >= 400) {
            throw new IOException("Unable to send email: " + response.getBody());
        }
    }

    public String getAcceptanceContentMessage() {
        return acceptanceContentMessage;
    }

    public String getRejectionContentMessage() {
        return rejectionContentMessage;
    }
}
