package com.example.aptechka.medicine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.Medication
import com.example.aptechka.database.MedicationDatabaseDao
import kotlinx.coroutines.*

class MedicineViewModel (val dao: MedicationDatabaseDao, application: Application): AndroidViewModel(application){

    private var viewModelJob= Job()
    private val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)
    private val medications = dao.getAll()
    private var medicationDataList = MutableLiveData<Medication?>()
    val medicineList = dao.getAll()
//    init {
//        initMedicationDataList()
//    }

//    private fun initMedicationDataList(){
//        uiScope.launch {
//            medicationDataList.value = getMedicationFromDao()
//        }
//    }

//    private suspend fun getMedicationFromDao(): Medication? {
//        return withContext(Dispatchers.IO){
//
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
