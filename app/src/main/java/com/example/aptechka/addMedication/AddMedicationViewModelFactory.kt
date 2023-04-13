package com.example.aptechka.addMedication

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.database.MedicationDatabaseDao

class AddMedicationViewModelFactory(private val dao: MedicationDatabaseDao, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(AddMedicationViewModel::class.java)){
            return AddMedicationViewModel(dao, application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}