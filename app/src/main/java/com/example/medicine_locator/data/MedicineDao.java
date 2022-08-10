package com.example.medicine_locator.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MedicineDao {
    @Insert
    void insertAll(Medicine medicine);

    @Delete
    void delete(Medicine medicine);

    @Update
    void update(Medicine medicine);

    @Query("DELETE FROM Medicine")
    void deleteAllRecord();
}
