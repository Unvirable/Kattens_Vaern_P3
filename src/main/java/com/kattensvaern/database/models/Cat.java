package com.kattensvaern.database.models;

import java.time.LocalDate;

public class Cat {
    private int id;
    private String name;
    private LocalDate birthday;
    private String gender;
    private String catType;
    private String locatedIn;
    private String description;
    private String available;

    public Cat(int id, String name, LocalDate birthday, String gender, String catType,
               String locatedIn, String description, String available){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.catType = catType;
        this.locatedIn = locatedIn;
        this.description = description;
        this.available = available;
    }

    public Cat(int id, String name, LocalDate birthday, String gender, String catType,
               String locatedIn, String description){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.catType = catType;
        this.locatedIn = locatedIn;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getCatType() {
        return catType;
    }

    public String getLocatedIn() {
        return locatedIn;
    }

    public String getDescription() {
        return description;
    }

    public String getAvailability() {
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCatType(String catType) {
        this.catType = catType;
    }

    public void setLocatedIn(String locatedIn) {
        this.locatedIn = locatedIn;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailability(String available) {
        this.available = available;
    }



}
