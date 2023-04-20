package com.example.aptechka.showMedicineList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.database.MedicationDatabaseDao

class ShowMedicineListViewModelFactory (private val dao: MedicationDatabaseDao, private val application: Application,private val name:String): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(ShowMedicineListViewModel::class.java)){
            return ShowMedicineListViewModel(dao, application, name) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}