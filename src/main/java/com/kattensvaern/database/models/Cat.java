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



    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    public String getLocatedIn(){
        return locatedIn;
    }

    public String getDescription(){
        return description;
    }
}
