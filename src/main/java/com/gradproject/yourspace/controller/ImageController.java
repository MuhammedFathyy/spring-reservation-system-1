package com.gradproject.yourspace.controller;

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

    @PatchMapping({"{imageId}"})
    public void updateRating(@PathVariable int imageId, @RequestParam("image") MultipartFile file) throws IOException {
        imageService.updateImageById(imageId,file);
    }
    @DeleteMapping({"{userId}"})
    public void deleteImageByUser(@PathVariable int userId){
        imageService.deleteImageByUsrId(userId);
    }


    @DeleteMapping({"{spaceId}"})
    public void deleteImageBySpace(@PathVariable int spaceId){
        imageService.deleteImageBySpaceId(spaceId);
    }

    @DeleteMapping({"{roomId}"})
    public void deleteImageByRoom(@PathVariable int roomId){
        imageService.deleteImageByRoomId(roomId);
    }


    @PostMapping()
    public void addImage(@RequestParam("image") MultipartFile file,@RequestParam("spaceId") int SpaceId,@RequestParam("roomId")int roomId,@RequestParam("userId") int userId) throws IOException {
        imageService.uploadImage(file,SpaceId,roomId,userId);
    }

    @GetMapping("space/{spaceId}/{index}")
    public ResponseEntity<?> getImagesBySpaceId(@PathVariable int spaceId,@PathVariable int index){

        byte[] image= imageService.getImagesBySpaceId(spaceId,index).getImageData();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);

    }

    @GetMapping("room/{roomId}/{index}")
    public ResponseEntity<?> getImagesByRoomId(@PathVariable int roomId,@PathVariable int index){
        byte[] image =imageService.getImageByRoomId(roomId,index).getImageData() ;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<?> getImageByUserId(@PathVariable int userId){
        byte[] image =imageService.getImageByUserId(userId).getImageData() ;
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
