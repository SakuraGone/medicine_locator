package com.example.medicine_locator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.medicine_locator.data.Medicine;

import java.util.ArrayList;
import java.util.Map;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    Map<String, String> map;
    String[] medNameList;
    String[] medLocationList;
    ArrayList<Medicine> arraylist = new ArrayList<Medicine>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        medNameList = new String[]{"感冒灵", "布洛芬"};
        medLocationList = new String[]{"1楼2行3列", "2楼3行1列"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < medNameList.length; i++) {
            Medicine med = new Medicine(medNameList[i], medLocationList[i]);
            // Binds all strings into an array
            arraylist.add(med);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}