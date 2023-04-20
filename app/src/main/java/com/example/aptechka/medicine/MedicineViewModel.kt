package com.example.aptechka.medicine

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.Medication
import com.example.aptechka.database.MedicationDatabaseDao
import kotlinx.coroutines.*

class MedicineViewModel(val dao: MedicationDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val medications = dao.getAll()
    private var medicationDataList = MutableLiveData<Medication?>()
    var medicineList = dao.getAll()
    var medSearchName = MutableLiveData<String>()

    fun getMedicationByName() {
        uiScope.launch {

            val medication = getMedicationByNameAsync();
            medicineList = medication
        }
    }

    suspend fun getMedicationByNameAsync() = withContext(Dispatchers.IO) {
        return@withContext dao.searchMedication(name = medSearchName.toString())
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
