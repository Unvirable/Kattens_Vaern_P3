package com.kattensvaern.database.models;

import com.kattensvaern.database.models.enums.*;

import java.time.LocalDate;

public class Cat {
    private int id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private CatType catType;
    private Shelter locatedIn;
    private String description;
    private Availability availability;

    public Cat(int id, String name, LocalDate birthday, Gender gender, CatType catType,
               Shelter locatedIn, String description, Availability availability){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.catType = catType;
        this.locatedIn = locatedIn;
        this.description = description;
        this.availability = availability;
    }

    public Cat(String name, LocalDate birthday, Gender gender, CatType catType,
               Shelter locatedIn, String description, Availability availability){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this. catType = catType;
        this.locatedIn = locatedIn;
        this.description = description;
        this.availability = availability;
    }

    //GETTERS
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public LocalDate getBirthday(){
        return birthday;
    }
    public Gender getGender(){return gender;}
    public CatType getCatType(){return catType;}
    public Shelter getLocatedIn(){
        return locatedIn;
    }
    public String getDescription(){
        return description;
    }
    public Availability getAvailability(){return availability;}

    public String getGenderLabel(){return gender.getLabel();}
    public String getCatTypeLabel(){return catType.getLabel();}
    public String getLocatedInLabel(){return locatedIn.getLabel();}
    public String GetAvailabilityLabel(){return availability.getLabel();}
}
