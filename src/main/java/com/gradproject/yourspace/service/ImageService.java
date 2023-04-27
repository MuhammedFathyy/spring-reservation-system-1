package com.gradproject.yourspace.service;

import com.gradproject.yourspace.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public interface ImageService {

    public void uploadImage(MultipartFile file,int spaceId, int roomId) throws IOException;
    public List<byte[]> getImages();
    public byte[] getImageById(int id);
    public String deleteImageById(int id);
    public void updateImageById(int imageId, MultipartFile file) throws IOException;
   public List<Image> getImagesBySpaceId(int spaceId);

    public List<Image> getImageByRoomId(int spaceId);
}
