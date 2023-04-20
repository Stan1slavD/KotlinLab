package com.example.aptechka.chooseItemMedicineList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.MedicationDatabaseDao
import com.example.aptechka.database.MedicationList
import kotlinx.coroutines.*

class ChooseMedicineItemListViewModel(
    val dao: MedicationDatabaseDao,
    application: Application,
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var medicineList = dao.getAllMedication()
    val medName = MutableLiveData<String>()
    val form = MutableLiveData<String>()
    val count = MutableLiveData<String>()
    val dosage = MutableLiveData<String>()
    val comment = MutableLiveData<String>()

    init {
        medicineList.observeForever { list -> Log.i("List", list.size.toString()) }

    }

    fun insertMedicationList(listName: String, medicationName: String) {
        uiScope.launch {

            withContext(Dispatchers.IO) {
                dao.insertMedicationList(
                    MedicationList(
                        //id = 0,
                        name = requireNotNull(listName),
                        medicationName = requireNotNull(medicationName)
                    )
                )
            }

        }
    }

    private fun getAllMedication() {
        uiScope.launch {
            medicineList = getAllMedicationAsync()
        }
        Log.i("MedSize", medicineList.value?.size.toString())
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    suspend fun getAllMedicationAsync() = withContext(Dispatchers.IO) {
        // Log.i("MEdNameAsync",medName.value.toString())
        return@withContext dao.getAllMedication()
    }
}