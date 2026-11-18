package com.kattensvaern.database.models.enums;

public enum Availability {
    LEDIG("Ledig"),
    RESERVERET("Reserveret"),
    ADOPTERET("Adopteret");

    private final String label;
    Availability(String label){this.label = label;}

    public String getLabel(){return label;}
}
