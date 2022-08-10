package com.example.medicine_locator.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Medicine {
    @PrimaryKey(autoGenerate = true)
    //medicine basic information
    private String medicineName;
    private String medicineLocation;
    private int dum;

    public Medicine(String name, String location) {
        this.medicineName = name;
        this.medicineLocation = location;
    }

    public String getMedicineName() {
        return this.medicineName;
    }

    public String getMedicineLocation() {
        return this.medicineLocation;
    }

    public void setMedicineName(String name) {
        this.medicineName = name;
    }

    public void setMedicineLocation(String location) {
        this.medicineLocation = location;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "Name: " + medicineName + "\n" +
                "Location: " + medicineLocation + "\n";
    }
}
