package com.example.ImageSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public List <Integer> extractIds () {
        List<Image> images = imageRepository.findAll();
        return images.stream().map(image ->image.getId()).collect(Collectors.toList());
    }

    public List<Image> getAll() {
        List<Image> images = imageRepository.findAll();
        return images;
    }

    public Image addImage(@RequestBody Image image) {
        return imageRepository.save(image);
    }

    public boolean deleteImage(int id) {
        Image imageToDelete = imageRepository.findById(id).orElse(null);

        if(imageToDelete == null) {
            return false;
        }

        imageRepository.delete(imageToDelete);
        return true;
    }

    public List<Image> getImageByFaction(String faction){
        return imageRepository.findAll().stream().filter(image -> image.getFaction().equalsIgnoreCase(faction)).collect(Collectors.toList());

    }

}
