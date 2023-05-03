package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public interface ImageService {

    public void uploadImage(MultipartFile file,int spaceId, int roomId,int userId) throws IOException;
    public List<byte[]> getImages();
    public byte[] getImageById(int id);
    public String deleteImageById(int id);
    public void updateImageById(int imageId, MultipartFile file) throws IOException;
   public Image getImagesBySpaceId(int spaceId, int index);

    public Image getImageByRoomId(int spaceId,int index);

   public  Image getImageByUserId(int userId);


    public void deleteImageByRoomId(int roomId);

   public void deleteImageByUsrId(int userId);

   public void deleteImageBySpaceId(int spaceId);


}
