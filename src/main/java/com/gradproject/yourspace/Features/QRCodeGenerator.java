package com.gradproject.yourspace.Features;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Service
public class QRCodeGenerator {


//    //create the image for QR Code and save it in the specified path
//    public static void generateQRCodeImage(String text, int width, int height, String filePath)
//            throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//
//    }

    //create the image in byte
    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFFFFC041 ) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

//    public static String getToken(Booking booking) throws IOException {
//
//        //for testing purpose
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonBooking = mapper.writeValueAsString(booking);
//        JwtBuilder builder = new DefaultJwtBuilder();
//        builder.claim("booking" , jsonBooking );
//        builder.signWith(SignatureAlgorithm.HS256,(new HmacKey("secretkeysecretkeysecretkeysecretkeysecretkeysecretkey".getBytes())));
//        return builder.compact();
//    }

    //will be used by the front end to encode the token
//    public static String consumeToken(String token) throws InvalidJwtException {
//        JwtConsumer consumer = new JwtConsumerBuilder().setVerificationKey(new HmacKey("secretkeysecretkeysecretkeysecretkeysecretkeysecretkey".getBytes())).build();
//        return consumer.processToClaims(token).toJson();
//    }


}
