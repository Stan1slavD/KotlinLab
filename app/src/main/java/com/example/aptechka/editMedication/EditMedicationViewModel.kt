package com.example.aptechka.showMedication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.Medication
import com.example.aptechka.database.MedicationDatabaseDao
import kotlinx.coroutines.*

class EditMedicationViewModel(
    val dao: MedicationDatabaseDao,
    application: Application,
    id: Int) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    //private val medications = dao.getAll()
    //private var medicationDataList = MutableLiveData<Medication?>()

    val id = id
    val medName = MutableLiveData<String>()
    val form = MutableLiveData<String>()
    val count = MutableLiveData<String>()
    val dosage = MutableLiveData<String>()
    val comment = MutableLiveData<String>()

    init {
        getMedication()
    }

    fun getMedication() {
        Log.i("GG WP", "GET")
        //Log.i("GGWP ",medName.value.toString())
        uiScope.launch {

            withContext(Dispatchers.IO) {
                val medication = getMedicationAsync();
                medName.value = medication.name.toString()
                form.value = medication.form.toString()
                count.value = medication.quantity.toString()
                dosage.value = medication.dosage.toString()
                comment.value = medication.comment.toString()
            }

        }
    }

    suspend fun getMedicationAsync() = withContext(Dispatchers.IO) {
        return@withContext dao.getById(id)
    }
}