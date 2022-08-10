package com.example.medicine_locator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medicine_locator.data.Medicine;
import com.example.medicine_locator.data.MedicineDao;
import com.example.medicine_locator.data.MedicineDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText medNameEditText, medLocationEditText;
    private Button save_button, cancel_button;

    private Button search_button, add_button, edit_button, delete_button;
    // Create instance of dao to make changes on database
    MedicineDao medicineDao;
    Medicine medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect to database
        // Check data base size
        medicineDao = MedicineDatabase.getDBInstance(getApplicationContext()).medicineDao();
        List<Medicine> medicines = medicineDao.getAllMedicines();
        System.out.println(medicines.size());

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
                createNewMedicineRecord();
            }
        });


        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewMedicineRecord();
            }
        });


        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewMedicineRecord();
            }
        });

    }

    public void createNewMedicineRecord() {
        //todo
        dialogBuilder = new AlertDialog.Builder(this);
        final View addPopupView = getLayoutInflater().inflate(R.layout.activity_add, null);
        medNameEditText = (EditText) addPopupView.findViewById(R.id.medicine_name_input);
        medLocationEditText = (EditText) addPopupView.findViewById(R.id.medicine_location_input);

        save_button = (Button) addPopupView.findViewById(R.id.submit_button);
        cancel_button = (Button) addPopupView.findViewById(R.id.cancel_button);

        dialogBuilder.setView(addPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Define save actions
                String medicine_name = medNameEditText.getText().toString();
                String medicine_location = medLocationEditText.getText().toString();
                if (medicine_name.matches("") || medicine_location.matches("")) {
                    Toast.makeText(getApplicationContext(), "名称或位置不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                medicine = new Medicine(medicine_name, medicine_location);
                medicineDao.insertAll(medicine);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}