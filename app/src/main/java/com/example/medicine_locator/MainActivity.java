package com.example.medicine_locator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.medicine_locator.data.Medicine;
import com.example.medicine_locator.data.MedicineDao;
import com.example.medicine_locator.data.MedicineDatabase;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText medNameEditText, medLocationEditText;
    private Button save_button, cancel_button;

    private ImageButton search_button, add_button, edit_button;
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

        search_button = findViewById(R.id.search_button);
        add_button = findViewById(R.id.add_button);
        edit_button = findViewById(R.id.edit_button);

        search_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
        });


        add_button.setOnClickListener(view -> createNewMedicineRecord());


        edit_button.setOnClickListener(view -> TODO());

    }

    public void TODO() {
        Toast.makeText(getApplicationContext(), "未开发", Toast.LENGTH_SHORT).show();
    }

    public void createNewMedicineRecord() {
        //todo
        dialogBuilder = new AlertDialog.Builder(this);
        final View addPopupView = getLayoutInflater().inflate(R.layout.activity_add, null);
        medNameEditText = addPopupView.findViewById(R.id.medicine_name_input);
        medLocationEditText = addPopupView.findViewById(R.id.medicine_location_input);

        save_button = addPopupView.findViewById(R.id.submit_button);
        cancel_button = addPopupView.findViewById(R.id.cancel_button);

        dialogBuilder.setView(addPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        save_button.setOnClickListener(view -> {
            //Define save actions
            String medicine_name = medNameEditText.getText().toString();
            String medicine_location = medLocationEditText.getText().toString();
            if (medicine_name.matches("") || medicine_location.matches("")) {
                Toast.makeText(getApplicationContext(), "名称或位置不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            medicine = new Medicine(medicine_name, medicine_location);
            medicineDao.insertAll(medicine);
            Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        cancel_button.setOnClickListener(view -> dialog.dismiss());
    }

}