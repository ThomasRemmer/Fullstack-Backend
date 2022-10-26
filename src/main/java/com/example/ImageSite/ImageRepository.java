package com.example.ImageSite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    //methods

    List<Image> findImageByDate(String date);

    List<Image> findImageByNameContainsIgnoreCase(String name);
}
