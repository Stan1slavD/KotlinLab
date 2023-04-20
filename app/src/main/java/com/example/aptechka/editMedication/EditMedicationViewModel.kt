package com.example.aptechka.editMedication

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
    var id: Int
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var medName = MutableLiveData<String>()
    var form = MutableLiveData<String>()
    var count = MutableLiveData<String>()
    var dosage = MutableLiveData<String>()
    var comment = MutableLiveData<String>()

    init {
        getMedication()

        //Thread.sleep(5_000)
        Log.i("MEdName", medName.value.toString())
    }

    private fun getMedication() {
        uiScope.launch {

            val medication = getMedicationAsync();
            medName.value = medication.name.toString()
            form.value = medication.form.toString()
            count.value = medication.quantity.toString()
            dosage.value = medication.dosage.toString()
            comment.value = medication.comment.toString()
            Log.i("MEdNameLaunch", medName.value.toString())

        }
    }

    fun deleteMedicationById() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                dao.deleteById(id)
            }
        }
    }
    fun deleteMedicationByNameInList(name: String){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                dao.deleteByNameList(name)
            }
        }
    }
    fun updateMedicineList(newName:String, oldName:String){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                dao.updateList(newName, oldName)
            }
        }
    }
    fun updateMedication(
        name: String,
        form: String,
        count: String,
        dosage: String,
        comment: String
    ) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                dao.update(
                    Medication(
                        id = id,
                        name = name,
                        form = form,
                        quantity = count.toInt(),
                        dosage = dosage,
                        comment = comment
                    )
                )
            }
        }
    }

    suspend fun getMedicationAsync() = withContext(Dispatchers.IO) {
        Log.i("MEdNameAsync", medName.value.toString())
        return@withContext dao.getById(id)
    }

}