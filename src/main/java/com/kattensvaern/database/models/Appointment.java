package com.kattensvaern.database.models;

import com.kattensvaern.database.models.enums.Shelter;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private int userId;
    private int catId;
    private LocalDateTime appointmentTime;


    public Appointment(int userId, int catId,  LocalDateTime appointmentTime ){
        this.userId = userId;
        this.catId = catId;
        this.appointmentTime = appointmentTime;
    }
    public Appointment(int userId, int catId,  LocalDateTime appointmentTime, int appointmentId){
        this(userId, catId, appointmentTime);
        this.appointmentId = appointmentId;
    }

    public int getUserId(){return userId;}
    public int getCatId() {return catId;}
    public LocalDateTime getAppointmentTime() {return appointmentTime;}
}
