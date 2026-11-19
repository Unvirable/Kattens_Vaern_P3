package com.kattensvaern.controller;

import com.kattensvaern.database.models.Cat;
import com.kattensvaern.service.BrowseCatsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

   @GetMapping("/api/findCatById")
   public Cat findCatById(@RequestParam int id){
        return browseCatsService.findCatById(id);
   }


    @PostMapping("/api/cats")
    public void createCat(@RequestBody Cat cat) {
        browseCatsService.createCat(cat);
    }

    @PutMapping("/api/cats/{id}")
    public void updateCat(@PathVariable int id, @RequestBody Cat cat) {
        cat.setId(id);
        browseCatsService.updateCat(cat);
    }

    @DeleteMapping("/api/cats/{id}")
    public void deleteCat(@PathVariable int id) {
        browseCatsService.deleteCat(id);
    }

}
