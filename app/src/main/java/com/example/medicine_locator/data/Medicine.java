package com.example.medicine_locator.data;

public class Medicine {
    //medicine basic information
    private String medicineName;
    private String medicineLocation;

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
}
