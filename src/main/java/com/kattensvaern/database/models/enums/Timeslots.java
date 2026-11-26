package com.kattensvaern.database.models.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public enum Timeslots {
    MORGEN("09.00-10.00", LocalTime.of(9,0)),
    FORMIDDAG("11.00-12.00", LocalTime.of(11,0)),
    MIDDAG("13.00-14.00", LocalTime.of(13,0)),
    EFTERMIDDAG("15.00-16.00", LocalTime.of(15,0)),
    AFTEN("16.00-17.00", LocalTime.of(16,0));

    private final String label;
    private LocalTime start;

    Timeslots(String label, LocalTime start){
        this.label = label;
        this.start = start;
    }


    public String getLabel(){return label;}
    public LocalDateTime atDate(LocalDate date){
        return date.atTime(start);
    }
}
