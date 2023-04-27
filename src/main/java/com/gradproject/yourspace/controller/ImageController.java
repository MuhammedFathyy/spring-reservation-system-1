package com.gradproject.yourspace.controller;

import com.gradproject.yourspace.dto.ImageDTO;
import com.gradproject.yourspace.service.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/images")
public class ImageController {
    private ImageService imageService;
    private ModelMapper modelMapper;

    public ImageController(ImageService imageService, ModelMapper modelMapper) {
        this.imageService = imageService;
        this.modelMapper = modelMapper;
    }

    @Autowired



    @GetMapping()
    public List<byte[]> getAllImages(){
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
    public void addImage(@RequestParam("image") MultipartFile file,@RequestParam("spaceId") int SpaceId,@RequestParam("roomId")int roomId) throws IOException {
        imageService.uploadImage(file,SpaceId,roomId);
    }

    @GetMapping("space/{spaceId}")
    public List<ImageDTO> getImagesBySpaceId(@PathVariable int spaceId){

        return imageService.getImagesBySpaceId(spaceId)
                .stream().map(image->modelMapper.map(image, ImageDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("room/{roomId}")
    public List<ImageDTO> getImagesByRoomId(@PathVariable int roomId){
        return imageService.getImageByRoomId(roomId)
                .stream().map(image->modelMapper.map(image, ImageDTO.class))
                .collect(Collectors.toList());
    }
}
