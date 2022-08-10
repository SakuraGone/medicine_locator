package com.example.medicine_locator.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Medicine {
    @PrimaryKey(autoGenerate = true)
    private int medicineId;

    //medicine basic information
    @ColumnInfo(name = "medicine_name")
    private String medicineName;
    @ColumnInfo(name = "medicine_location")
    private String medicineLocation;

    public Medicine() {
        this.medicineName = "";
        this.medicineLocation = "";
    }

    public Medicine(String name, String location) {
        this.medicineName = name;
        this.medicineLocation = location;
    }

    public int getMedicineId() { return this.medicineId; }

    public String getMedicineName() {
        return this.medicineName;
    }

    public String getMedicineLocation() {
        return this.medicineLocation;
    }

    public void setMedicineId(int id) { this.medicineId = id; }

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
