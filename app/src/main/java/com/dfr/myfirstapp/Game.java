package com.dfr.myfirstapp;

/**
 * Created by NACHZEHER on 13/02/2018.
 */

public class Game {

    private int id;
    private String name;
    private String description;
    private String image_path;

    public Game(int id, String name, String description, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_path = img;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return image_path;
    }

    public void setImg(String img) {
        this.image_path = img;
    }
}
