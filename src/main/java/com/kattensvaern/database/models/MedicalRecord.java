
package com.kattensvaern.database.models;

import java.time.LocalDate;

public class MedicalRecord {

    private int id;
    private int catId;
    private String recordType;
    private String description;
    private LocalDate nextDueDate;

    public MedicalRecord(int id, int catId, String recordType,
                         String description, LocalDate nextDueDate) {

        this.id = id;
        this.catId = catId;
        this.recordType = recordType;
        this.description = description;
        this.nextDueDate = nextDueDate;
    }

    public int getId() {
        return id;
    }

    public int getCatId() {
        return catId;
    }

    public String getRecordType() {
        return recordType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }
}
