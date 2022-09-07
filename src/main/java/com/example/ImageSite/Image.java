package com.example.ImageSite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String faction;
    private String text;
    private Timestamp dateCreated;
//    private File image;

    public Image(){
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public Image(int id, String name, String faction, String text) {
        this.id = id;
        this.name = name;
        this.faction = faction;
        this.text = text;
        this.dateCreated = new Timestamp(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

//    public File getImage() {
//        return image;
//    }
//
//    public void setImage(File image) {
//        this.image = image;
//    }
}
