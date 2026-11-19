package com.kattensvaern.database.models.enums;

public enum CatType {
    INDE_UDE("Inde og Ude kat"),
    KUN_INDE("Kun inde kat"),
    KUN_UDE("Kun ude kat ");

    private final String label;
    CatType(String label){this.label = label;}

    public String getLabel(){return label;}
}

