package com.kattensvaern.database.models.enums;

public enum Shelter {
    BROENDBY("Brøndby"),
    RINGSTED("Ringsted"),
    BILLUND("Billund"),
    AALBORG("Aalborg"),
    RINGE("Ringe");

    private final String label;
    Shelter(String label){this.label = label;}

    public String getLabel(){return label;}
}
