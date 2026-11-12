package com.kattensvaern.model;

public class Cat {
    private int id;
    private String name;
    private int age;
    private String city;
    private String description;

    public Cat(){

    }

    public Cat(int id, String name, int age, String city, String description){
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.description = description;
    }
    public Cat(String name, int age, String city, String description){
        this.name = name;
        this.age = age;
        this.city = city;
        this.description = description;
    }



    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getCity(){
        return city;
    }

    public String getDescription(){
        return description;
    }
}
