package com.example.aptechka.medicineList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.Medication
import com.example.aptechka.database.MedicationDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MedicineListViewModel (val dao: MedicationDatabaseDao, application: Application): AndroidViewModel(application){
    private var viewModelJob= Job()
    private val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)
    private val medications = dao.getAll()
    private var medicationDataList = MutableLiveData<Medication?>()
    val medList = dao.getAllList()




    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}