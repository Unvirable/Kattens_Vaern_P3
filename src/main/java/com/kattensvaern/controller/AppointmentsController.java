package com.kattensvaern.controller;

import com.kattensvaern.database.models.Appointment;
import com.kattensvaern.database.models.enums.Timeslots;
import com.kattensvaern.service.AppointmentsService;
import com.kattensvaern.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AppointmentsController {
    private final AppointmentsService appointmentsService;
    private final ProfileService profileService;

    private record BookingRequest(int catId, LocalDate date, Timeslots slot){}
    public record SlotResponse(String slot, String label){}

    public AppointmentsController(AppointmentsService appointmentsService, ProfileService profileService){
        this.appointmentsService = appointmentsService;
        this.profileService = profileService;
    }

    @PostMapping("/api/createAppointment")
    public void createAppointment(@RequestBody BookingRequest request, Authentication authentication){
        int userId = profileService.findUserByEmail(authentication.getName());
        appointmentsService.bookAppointments(userId, request.catId(), request.date(), request.slot());
    }

    @GetMapping("/api/getTimeslotsForCat")
    public List<SlotResponse> getAvailableTimeslotsForCat(@RequestParam int catId, @RequestParam String date){
        return appointmentsService.getAvailableTimeslots(catId, LocalDate.parse(date)).stream()
                .map(s -> new SlotResponse(s.name(), s.getLabel())).toList();
    }

    @GetMapping("/api/getAppointments")
    public List<Appointment> getAllAppointments(){return appointmentsService.getAllAppointments();}
}
