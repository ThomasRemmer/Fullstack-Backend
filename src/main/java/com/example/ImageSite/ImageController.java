package com.example.ImageSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class ImageController {



    @Autowired
    ImageService imageService;
    @GetMapping("/images")
    public ResponseEntity<List<Image>> getImage() {
        List<Image> images = imageService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }

    @GetMapping("/image/ids")
    public ResponseEntity<List<Integer>> getImageIds () {
        List<Integer> imageIds = imageService.extractIds();
        return ResponseEntity.status(HttpStatus.OK).body(imageIds);
    }

    @PostMapping("/images")
    public ResponseEntity createImage(@RequestBody Image image) {
        imageService.addImage(image);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @DeleteMapping("/images/{id}")
    public ResponseEntity deleteImage(@PathVariable String id) {
        boolean isDeleted = imageService.deleteImage(parseInt(id));

        if (isDeleted == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldnt find requested image");
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }



//    @GetMapping("/image/{Id}")
//    public String getImageById(@PathVariable String Id) {
//
//        return "Looking for an image with an id of " + Id;
//    }

//    @GetMapping("image")
//    public String getImageByName(@RequestParam String name){
//        return name;
//    }

}
