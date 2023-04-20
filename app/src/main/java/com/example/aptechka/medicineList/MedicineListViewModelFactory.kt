package com.example.aptechka.medicineList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.database.MedicationDatabaseDao
import com.example.aptechka.medicine.MedicineViewModel

class MedicineListViewModelFactory(private val dao: MedicationDatabaseDao, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(MedicineListViewModel::class.java)){
            return MedicineListViewModel(dao, application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}