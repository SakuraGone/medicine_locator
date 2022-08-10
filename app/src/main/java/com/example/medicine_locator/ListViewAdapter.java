package com.example.medicine_locator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.medicine_locator.data.Medicine;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    //Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Medicine> medicineList = null;
    private ArrayList<Medicine> arrayList;

    private static class ViewHolder {
        TextView name;
        TextView location;
    }

    public ListViewAdapter(Context context, List<Medicine> medicineList) {
        mContext = context;
        this.medicineList = medicineList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(medicineList);
    }

    @Override
    public int getCount() {
        return medicineList.size();
    }

    @Override
    public Object getItem(int position) {
        return medicineList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = view.findViewById(R.id.medicine_name);
            holder.location = view.findViewById(R.id.medicine_location);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set results into TextViews
        holder.name.setText(medicineList.get(position).getMedicineName());
        holder.location.setText(medicineList.get(position).getMedicineLocation());
        return view;
    }

    // Filter Class for searching
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        medicineList.clear();
        if (charText.length() == 0) {
            medicineList.addAll(arrayList);
        } else {
            for (Medicine med : arrayList) {
                if (med.getMedicineName().contains(charText)) {
                    medicineList.add(med);
                }
            }
        }
        notifyDataSetChanged();
    }
}
