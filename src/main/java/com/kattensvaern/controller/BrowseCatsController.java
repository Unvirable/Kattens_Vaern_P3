package com.kattensvaern.controller;

import com.kattensvaern.database.models.Cat;
import com.kattensvaern.database.models.CatImage;
import com.kattensvaern.service.BrowseCatsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        try {
            if (cat == null ||
                    cat.getName() == null || cat.getName().isBlank() ||
                    cat.getBirthday() == null ||
                    cat.getGender() == null ||
                    cat.getCatType() == null ||
                    cat.getLocatedIn() == null ||
                    cat.getAvailability() == null) {

                System.out.println("ERROR: Invalid cat information");
                return;
            }

            browseCatsService.createCat(cat);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to create cat");
            e.printStackTrace();
        }
    }

    @PutMapping("/api/cats/{id}")
    public void updateCat(@PathVariable int id, @RequestBody Cat cat) {
        try {
            if (id <= 0 ||
                    cat == null ||
                    cat.getName() == null || cat.getName().isBlank() ||
                    cat.getBirthday() == null ||
                    cat.getGender() == null ||
                    cat.getCatType() == null ||
                    cat.getLocatedIn() == null ||
                    cat.getAvailability() == null) {

                System.out.println("ERROR: Invalid cat information");
                return;
            }

            cat.setId(id);
            browseCatsService.updateCat(cat);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to update cat");
            e.printStackTrace();
        }
    }

    @DeleteMapping("/api/cats/{id}")
    public void deleteCat(@PathVariable int id) {
        try {
            if (id <= 0) {
                System.out.println("ERROR: Invalid cat ID");
                return;
            }

            browseCatsService.deleteCat(id);

        } catch (Exception e) {
            System.out.println("ERROR: Failed to delete cat");
            e.printStackTrace();
        }
    }

    @GetMapping("/api/getCatImage")
    public ResponseEntity<byte[]> getCatImage(@RequestParam int id){
        CatImage img = browseCatsService.getCatImage(id);

        if(img == null){return ResponseEntity.notFound().build();}

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(img.contentType())).body((img.data()));
        }
}
