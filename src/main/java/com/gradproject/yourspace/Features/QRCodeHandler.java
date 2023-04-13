package com.gradproject.yourspace.Features;


import com.google.zxing.WriterException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Base64;


public class QRCodeHandler {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/templates/QRCode.png";

    public String getQRCode(Model model){


         String url;
        byte[] image = new byte[0];
        try {

            String token= QRCodeGenerator.getToken();

            String Consumed= QRCodeGenerator.consumeToken(token);

            //should be extracted by the front end and consume the token with consume function
             url= "www.yourspace.bookings/"+token;
            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(url,1000,1000);

            // Generate and Save Qr Code Image in static/image folder
            QRCodeGenerator.generateQRCodeImage(url,1000,1000,QR_CODE_IMAGE_PATH);
            model.addAttribute("url",url);
            System.out.println(url);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        } catch (InvalidJwtException ex) {
            throw new RuntimeException(ex);
        }

        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);


        model.addAttribute("qrcode",qrcode);

        System.out.println(model.getAttribute("qrcode"));

        return "qrcode";

    }
}
