package com.gradproject.yourspace.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public interface ImageService {

    public void uploadImage(MultipartFile file) throws IOException;
    public List<byte[]> getImages();
    public byte[] getImageById(int id);
    public String deleteImageById(int id);
    public void updateImageById(int imageId, MultipartFile file) throws IOException;

}
