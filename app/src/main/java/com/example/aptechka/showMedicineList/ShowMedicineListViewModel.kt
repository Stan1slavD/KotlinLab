package com.example.aptechka.showMedicineList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.MedicationDatabaseDao
import kotlinx.coroutines.*

class ShowMedicineListViewModel (
    val dao: MedicationDatabaseDao,
    application: Application,
    var name:String
) : AndroidViewModel(application){
    val medicineList =dao.getAllMedicationList()
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    init {
        medicineList.observeForever{list-> Log.i("List", medicineList.value?.size.toString())}
    }
}