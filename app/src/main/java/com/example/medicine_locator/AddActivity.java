package com.example.medicine_locator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medicine_locator.data.Medicine;
import com.example.medicine_locator.data.MedicineDao;
import com.example.medicine_locator.data.MedicineDatabase;

import java.util.HashMap;

public class AddActivity extends AppCompatActivity {

    // Create instance of dao to make changes on database
    MedicineDao medicineDao;
    Medicine medicine;
    HashMap<String, String> med;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Connect to database
        medicineDao = MedicineDatabase.getDBInstance(getApplicationContext()).medicineDaoDao();
        medicine = new Medicine();

    }
}