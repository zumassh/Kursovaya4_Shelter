package com.shelter.coursework.service;

import com.shelter.coursework.entity.Image;
import com.shelter.coursework.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ImageService {
    @Autowired
    ImageRepo imageRepo;
    public void saveImage(Image image) {
        imageRepo.save(image);
    }

}
