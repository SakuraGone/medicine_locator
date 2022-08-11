package com.example.medicine_locator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    List<Medicine> medicines;
    ArrayList<Medicine> arraylist = new ArrayList<>();

    // Create instance of dao to make changes on database
    MedicineDao medicineDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Connect to database
        medicineDao = MedicineDatabase.getDBInstance(getApplicationContext()).medicineDao();
        medicines = medicineDao.getAllMedicines();

        // Locate the ListView in listview_main.xml
        list = findViewById(R.id.listview);

        for (int i = 0; i < medicines.size(); i++) {
            // Binds all strings into an array
            arraylist.add(medicines.get(i));
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder adb=new AlertDialog.Builder(SearchActivity.this);
                adb.setTitle("删除数据");
                adb.setMessage("确定要删除[" + medicines.get(position).getMedicineName() + "]的数据吗?");
                final int positionToRemove = position;
                adb.setNegativeButton("取消", null);
                adb.setPositiveButton("确定", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        medicineDao.delete(medicines.get(position));
                        arraylist.remove(medicines.get(position));
                        adapter.notifyDataSetChanged();
                    }});
                adb.show();
                return false;
            }
        });

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