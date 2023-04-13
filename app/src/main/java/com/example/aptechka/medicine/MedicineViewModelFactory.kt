package com.example.aptechka.medicine

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.database.MedicationDatabaseDao

class MedicineViewModelFactory(private val dao: MedicationDatabaseDao, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(MedicineViewModel::class.java)){
            return MedicineViewModel(dao, application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}