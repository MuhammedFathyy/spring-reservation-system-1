package com.gradproject.yourspace.Features;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.gradproject.yourspace.dto.BookingDTO;
import com.gradproject.yourspace.service.BookingService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;


@Component
public class QRCodeGenerator {

    private static BookingService bookingService;

    @Autowired
    public QRCodeGenerator(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    //create the image for QR Code and save it in the specified path
    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

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

    public static String getToken() throws IOException {

        //for testing purpose
        ObjectMapper mapper = new ObjectMapper();
        List<BookingDTO> booking =bookingService.getBookingsHistory(2);
        BookingDTO book=booking.get(0);

        String jsonBooking = mapper.writeValueAsString(book);
        JwtBuilder builder = new DefaultJwtBuilder();
        builder.claim("booking" , jsonBooking );
        builder.signWith(SignatureAlgorithm.HS256,(new HmacKey("secretkeysecretkeysecretkeysecretkeysecretkeysecretkey".getBytes())));
        return builder.compact();
    }
    public static String consumeToken(String token) throws InvalidJwtException {
        JwtConsumer consumer = new JwtConsumerBuilder().setVerificationKey(new HmacKey("secretkeysecretkeysecretkeysecretkeysecretkeysecretkey".getBytes())).build();
        return consumer.processToClaims(token).toJson();
    }


}
