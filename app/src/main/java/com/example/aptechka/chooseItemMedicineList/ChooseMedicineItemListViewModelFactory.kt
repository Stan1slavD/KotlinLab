package com.example.aptechka.chooseItemMedicineList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.database.MedicationDatabaseDao

class ChooseMedicineItemListViewModelFactory (private val dao: MedicationDatabaseDao, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(ChooseMedicineItemListViewModel::class.java)){
            return ChooseMedicineItemListViewModel(dao, application) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}