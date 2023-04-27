package com.gradproject.yourspace.service;

import com.gradproject.yourspace.dao.ImageDAO;
import com.gradproject.yourspace.dao.RoomDAO;
import com.gradproject.yourspace.dao.SpaceDAO;
import com.gradproject.yourspace.entity.Image;
import com.gradproject.yourspace.entity.Room;
import com.gradproject.yourspace.entity.Space;
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
    private SpaceDAO spaceDAO;
    private RoomDAO roomDAO;



    @Autowired
    public ImageServiceImpl(ImageDAO imageDAO, SpaceDAO spaceDAO, RoomDAO roomDAO) {
        this.imageDAO = imageDAO;
        this.spaceDAO = spaceDAO;
        this.roomDAO = roomDAO;
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
    public void uploadImage(MultipartFile file,int SpaceId,int roomId) throws IOException {
        System.out.println(file);
        Image image= new Image();
        image.setType(file.getContentType());
        image.setName(file.getOriginalFilename());
       image.setImageData((file.getBytes()));
       Space space = spaceDAO.findSpaceBySpaceId(SpaceId);
       Room room=roomDAO.getRoomByRoomId(roomId);
       if(space!=null){
           image.setSpace(space);
       }
       if(room!=null){
           image.setRoom(room);
       }
//        image.setImageId(0);
        imageDAO.save(image);

    }

    @Override
    @Transactional
    public List<byte[]> getImages() {
        List<Image> ComImages=imageDAO.findAll();
        List<byte[]> images = new ArrayList<>();
        for(int i=0; i< ComImages.size();i++){

            byte[] image= ComImages.get(i).getImageData();
           images.add(image);

        }
        return images;
    }

    @Override
    @Transactional
    public byte[] getImageById(int id) {
       Image image = imageDAO.findImagesByImageId(id);
       return image.getImageData();
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
        image.setImageData(file.getBytes());
        imageDAO.save(image);

    }


    @Transactional
    @Override
    public List<Image> getImagesBySpaceId(int spaceId) {
        return imageDAO.findImagesBySpaceId(spaceId);
    }

    @Transactional
    @Override
    public List<Image> getImageByRoomId(int roomId) {
        return imageDAO.findImageByRoomId(roomId);
    }
}
