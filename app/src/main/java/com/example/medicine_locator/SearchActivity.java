package com.example.medicine_locator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.medicine_locator.data.Medicine;
import com.example.medicine_locator.data.MedicineDao;
import com.example.medicine_locator.data.MedicineDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editSearch;
    String[] medNameList;
    String[] medLocationList;
    ArrayList<Medicine> arraylist = new ArrayList<>();

    // Create instance of dao to make changes on database
    MedicineDao medicineDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Connect to database
        medicineDao = MedicineDatabase.getDBInstance(getApplicationContext()).medicineDao();
        List<Medicine> medicines = medicineDao.getAllMedicines();

        int n = medicines.size();
        medNameList = new String[n];
        medLocationList = new String[n];
        for (int i=0;i<n;i++) {
            medNameList[i] = medicines.get(i).getMedicineName();
            medLocationList[i] = medicines.get(i).getMedicineLocation();
        }

        // Locate the ListView in listview_main.xml
        list = findViewById(R.id.listview);

        for (int i = 0; i < n; i++) {
            Medicine med = new Medicine(medNameList[i], medLocationList[i]);
            // Binds all strings into an array
            arraylist.add(med);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editSearch = findViewById(R.id.search);
        editSearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}