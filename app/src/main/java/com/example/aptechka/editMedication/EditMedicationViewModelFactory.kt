package com.example.aptechka.showMedication

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.database.MedicationDatabaseDao
import com.example.aptechka.editMedication.EditMedicationViewModel

//
//class editMedicationViewModelFactory {
//}

class EditMedicationViewModelFactory(private val dao: MedicationDatabaseDao, private val application: Application, private val id:Int): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(EditMedicationViewModel::class.java)){
            return EditMedicationViewModel(dao, application, id) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}