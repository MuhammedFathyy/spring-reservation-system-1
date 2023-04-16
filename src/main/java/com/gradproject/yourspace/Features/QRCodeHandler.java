package com.gradproject.yourspace.Features;


import com.google.zxing.WriterException;
import com.gradproject.yourspace.entity.Booking;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;



@Service
public class QRCodeHandler {

    public String getQRCode(Booking booking){
        String url;
        byte[] image = new byte[0];
        try {

            String token= QRCodeGenerator.getToken(booking);
            String Consumed= QRCodeGenerator.consumeToken(token);
            //should be extracted by the front end and consume the token with consume function
             url= "http://localhost:8080/api/bookings"+token;
            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(url,1000,1000);


        } catch (WriterException | IOException e) {
            e.printStackTrace();
        } catch (InvalidJwtException ex) {
            throw new RuntimeException(ex);
        }
        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);

        return qrcode;

    }
}
