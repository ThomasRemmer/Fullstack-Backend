package com.example.ImageSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Couldn't find requested image");
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/images/date/{date}")
    public ResponseEntity<List<Image>> getImageByFaction(@PathVariable String date) {
        List<Image> images = imageService.getImageByDate(date);
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }

    @GetMapping("images/name/{name}")
    public ResponseEntity<List<Image>> getImageByNameContains(@PathVariable String name) {
        List<Image> images = imageService.getImageByNameContains(name);
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }





}
