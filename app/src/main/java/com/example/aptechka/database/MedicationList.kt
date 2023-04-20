package com.example.aptechka.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication_list_table")
data class MedicationList(
    @PrimaryKey(autoGenerate = true) var listId: Int? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name="medicationName") var medicationName: String? =null
)