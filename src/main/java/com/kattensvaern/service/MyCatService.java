
package com.kattensvaern.service;

import com.kattensvaern.database.DAO.CatDAO;
import com.kattensvaern.database.models.Cat;
import org.springframework.stereotype.Service;
import com.kattensvaern.database.models.MedicalRecord;

import java.util.List;


@Service
public class MyCatService {

    private final CatDAO catDAO;

    public MyCatService(CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    public List<Cat> getCatsByOwnerEmail(String email) {
        return catDAO.findCatsByOwnerEmail(email);
    }


    public List<MedicalRecord> getMedicalRecords(
            int catId, String email) {

        return catDAO.findMedicalRecordsByCatAndOwner(catId, email);
    }


}
