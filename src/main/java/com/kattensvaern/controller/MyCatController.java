
package com.kattensvaern.controller;

import com.kattensvaern.database.models.Cat;
import com.kattensvaern.service.MyCatService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.kattensvaern.database.models.MedicalRecord;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
public class MyCatController {

    private final MyCatService myCatService;

    public MyCatController(MyCatService myCatService) {
        this.myCatService = myCatService;
    }

    @GetMapping("/api/mycats")
    public List<Cat> getMyCats(Authentication authentication) {

        if (authentication == null ||
                !authentication.isAuthenticated()) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "You must be logged in"
            );
        }

        String email = authentication.getName();

        return myCatService.getCatsByOwnerEmail(email);
    }


    @GetMapping("/api/mycats/{catId}/medical-records")
    public List<MedicalRecord> getMedicalRecords(
            @PathVariable int catId,
            Authentication authentication) {

        if (authentication == null ||
                !authentication.isAuthenticated()) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "You must be logged in"
            );
        }

        String email = authentication.getName();

        return myCatService.getMedicalRecords(catId, email);
    }


}
