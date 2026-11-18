package com.kattensvaern.database.models.enums;

public enum Gender {
    HAN("Han"),
    HUN("Hun");

    private final String label;
    Gender(String label){this.label = label;}

    public String getLabel(){return label;}
    }
