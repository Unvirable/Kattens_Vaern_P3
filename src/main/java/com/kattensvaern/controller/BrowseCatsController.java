package com.kattensvaern.controller;

import com.kattensvaern.model.Cat;
import com.kattensvaern.service.BrowseCatsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Talks with BrowseCatService.
@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://127.0.0.1:5500"})
public class BrowseCatsController {

   private final BrowseCatsService browseCatsService;

    public BrowseCatsController(BrowseCatsService browseCatsService) {
        this.browseCatsService = browseCatsService;
    }

    @GetMapping("/api/getCats")
    public List<Cat> getCats(){
        return browseCatsService.getAllCats();
    }
}
