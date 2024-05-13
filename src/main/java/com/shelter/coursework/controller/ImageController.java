package com.shelter.coursework.controller;

import com.shelter.coursework.service.AnimalService;
import com.shelter.coursework.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    AnimalService animalService;

    @GetMapping("/animal/image/{animalId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long animalId) {
        byte[] imageBytes = animalService.getAnimal(animalId).getPhoto().getData();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);
    }
}
