package com.kattensvaern.service;

import com.kattensvaern.database.DAO.CatDAO;
import com.kattensvaern.database.models.Cat;
import org.springframework.stereotype.Service;
import java.util.List;

//Talks with CatDAO
@Service
public class BrowseCatsService {
    private final CatDAO catDAO;

    public BrowseCatsService(CatDAO catDAO){
        this.catDAO = catDAO;
    }

    public List<Cat> getAllCats(){
        return catDAO.getAllCats();
    }

    public Cat findCatById(int id){
        return catDAO.findCatById(id);
    }

}
