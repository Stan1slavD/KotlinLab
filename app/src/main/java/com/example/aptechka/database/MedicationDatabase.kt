package com.example.aptechka.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Medication::class], version = 1, exportSchema = false)
abstract class MedicationDatabase:RoomDatabase() {
    companion object{
        @Volatile
        private var INSTANCE: MedicationDatabase? = null
        fun getInstance(context: Context):MedicationDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance= Room.databaseBuilder(context.applicationContext, MedicationDatabase::class.java, "medication_db").build()
                    INSTANCE = instance
                }
                return instance

            }
        }
    }

abstract fun getMedicationDatabaseDao(): MedicationDatabaseDao
}