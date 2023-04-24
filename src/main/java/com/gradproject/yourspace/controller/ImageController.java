package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageController {
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @GetMapping()
    public List<byte[]> getAllRatings(){
        return imageService.getImages();
    }
    @GetMapping("{imageId}")
    public ResponseEntity<?> getImage(@PathVariable int imageId){
        byte[] image= imageService.getImageById(imageId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }


    @DeleteMapping({"{imageId}"})
    public void deleteImage(@PathVariable int imageId){
        imageService.deleteImageById(imageId);
    }

    @PatchMapping({"{imageId}"})
    public void updateRating(@PathVariable int imageId, @RequestParam("image") MultipartFile file) throws IOException {
        imageService.updateImageById(imageId,file);
    }

    @PostMapping()
    public void addImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.uploadImage(file);
    }
}