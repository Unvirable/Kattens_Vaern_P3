package com.kattensvaern.service;

import com.kattensvaern.database.DAO.AppointmentsDAO;
import com.kattensvaern.database.models.Appointment;
import com.kattensvaern.database.models.enums.Timeslots;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;


@Service
public class AppointmentsService {
    private static final int minDaysBeforeApp = 1;
    private static final int maxDaysBeforeApp = 14;
    private final AppointmentsDAO appointmentsDAO;

    public AppointmentsService(AppointmentsDAO appointmentsDAO) {
        this.appointmentsDAO = appointmentsDAO;
    }

    public boolean isDateBookable(LocalDate date){
        LocalDate today = LocalDate.now();
        boolean isWeekdayValid = date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
        boolean isDateValid = !date.isBefore(today.plusDays(minDaysBeforeApp)) && !date.isAfter(today.plusDays(maxDaysBeforeApp));

        return isWeekdayValid && isDateValid;
    }

    public List<Timeslots> getAvailableTimeslots(int catId, LocalDate date){
        if(!isDateBookable(date) || appointmentsDAO.isCatBooked(catId, date)){
            return List.of();
        }
        return List.of(Timeslots.values());
    }

    public void bookAppointments(int userId, int catId, LocalDate date, Timeslots timeslot){
        if(!isDateBookable(date)){
            throw new IllegalArgumentException("Der kan ikke bookes på den valgte dato");
        }
        if(appointmentsDAO.isCatBooked(catId, date)){
            throw new IllegalArgumentException("Den valgte kat er allerede booket den dag.");
        }
        appointmentsDAO.createAppointment(userId, catId, timeslot.atDate(date));

    }

    public List<Appointment> getAllAppointments(){return appointmentsDAO.getAllAppointments();}
    
}
