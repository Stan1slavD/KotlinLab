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

    @Query("SELECT * FROM medication_table")
    fun getAllMedication(): LiveData<List<Medication>>

    @Query("SELECT * FROM medication_table WHERE name LIKE :query")
    fun search(query: String): LiveData<List<Medication>>

    @Query("SELECT * FROM medication_table WHERE id=:id")
    fun getById(id: Int): Medication

    @Query("DELETE FROM medication_table WHERE id=:id")
    fun deleteById(id: Int)
//    @Query("INSERT INTO medication_list_table")
//    fun insertList(list:List<String>)
@Insert(onConflict = OnConflictStrategy.REPLACE)
fun insertMedicationList(medicineList: MedicationList)

@Query("SELECT * FROM medication_list_table GROUP BY name")
fun getAllList():LiveData<List<MedicationList>>
@Query("SELECT * FROM medication_table WHERE name=:name")
fun searchMedication(name:String):LiveData<List<Medication>>
}