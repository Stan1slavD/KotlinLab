package com.example.aptechka.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication_table")
data class Medication (
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "form") var form: String? = null,
    @ColumnInfo(name = "quantity") var quantity: Int? = null,
    @ColumnInfo(name = "dosage") var dosage: String? = null,
    @ColumnInfo(name = "comment") var comment: String? = null
)