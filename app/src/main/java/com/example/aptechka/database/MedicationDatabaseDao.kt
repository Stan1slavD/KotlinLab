package com.example.aptechka.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MedicationDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(medicine: Medication)

    @Update
    fun update(medicine: Medication)

    @Delete
    fun delete(medicine: Medication)

    @Query("SELECT * FROM medication_table")
    fun getAll(): LiveData<List<Medication>>

    @Query("SELECT * FROM medication_table WHERE name LIKE :query")
    fun search(query: String): LiveData<List<Medication>>
}