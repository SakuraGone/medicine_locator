package com.example.medicine_locator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medicine_locator.data.Medicine;
import com.example.medicine_locator.data.MedicineDao;
import com.example.medicine_locator.data.MedicineDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button search_button, add_button, edit_button, delete_button;
    // Create instance of dao to make changes on database
    MedicineDao medicineDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Connect to database
//        medicineDao = MedicineDatabase.getDBInstance(getApplicationContext()).medicineDao();
//        List<Medicine> medicines = medicineDao.getAllMedicines();
//        System.out.println(medicines.size());

        search_button = (Button) findViewById(R.id.search_button);
        add_button = (Button) findViewById(R.id.add_button);
        edit_button = (Button) findViewById(R.id.edit_button);
        delete_button = (Button) findViewById(R.id.delete_button);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });


        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySearch();
            }
        });


        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySearch();
            }
        });

    }

    public void openActivitySearch() {
        //todo
    }

}