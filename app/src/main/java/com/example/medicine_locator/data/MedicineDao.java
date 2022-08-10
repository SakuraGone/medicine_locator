package com.example.medicine_locator.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Medicine medicine);

    @Delete
    void delete(Medicine medicine);

    @Update
    void update(Medicine medicine);

    @Query("DELETE FROM medicine")
    void deleteAllRecord();

    @Query("SELECT * FROM medicine")
    List<Medicine> getAllMedicines();

}
