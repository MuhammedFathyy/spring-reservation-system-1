package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.ImageDAO;
import com.gradproject.yourspace.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageDAO imageDAO;


    @Autowired

    public ImageServiceImpl(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    public static byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }



    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }



    @Override
    @Transactional
    public void uploadImage(MultipartFile file) throws IOException {

        System.out.println(file);
        Image image= new Image();
        image.setType(file.getContentType());
        image.setName(file.getOriginalFilename());
       image.setImageDate((file.getBytes()));
        image.setImageId(0);
        imageDAO.save(image);

    }

    @Override
    @Transactional
    public List<byte[]> getImages() {
        List<Image> ComImages=imageDAO.findAll();
        List<byte[]> images = new ArrayList<>();
        for(int i=0; i< ComImages.size();i++){

            byte[] image= decompressImage(ComImages.get(i).getImageDate());
           images.add(image);

        }
        return images;
    }

    @Override
    @Transactional
    public byte[] getImageById(int id) {
       Image image = imageDAO.findImagesByImageId(id);
       return image.getImageDate();
    }

    @Override
    @Transactional
    public String deleteImageById(int id) {
        Image image = imageDAO.findImagesByImageId(id);
        if(image==null){
            return "there is no image with this id";
        }
        else {
            imageDAO.deleteById(id);
            return "image deleted successfully";
        }


    }


    @Override
    @Transactional
    public void updateImageById(int imageId,MultipartFile file) throws IOException {

        Image image=imageDAO.findImagesByImageId(imageId);
        image.setImageDate(file.getBytes());
        imageDAO.save(image);

    }
}
