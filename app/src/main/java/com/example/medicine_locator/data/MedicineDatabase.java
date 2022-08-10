package com.example.medicine_locator.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Medicine.class}, version = 1)
public abstract class MedicineDatabase extends RoomDatabase{
    public abstract MedicineDao medicineDao();

    private static MedicineDatabase medicineDatabase_db;

    public static MedicineDatabase getDBInstance(Context context) {
        if(medicineDatabase_db == null) {
            medicineDatabase_db = Room.databaseBuilder(context.getApplicationContext(), MedicineDatabase.class,
                    "medicine_db").allowMainThreadQueries().build();
        }
        return medicineDatabase_db;
    }
}
