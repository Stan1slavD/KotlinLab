package com.example.aptechka.addMedication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.aptechka.database.Medication
import com.example.aptechka.database.MedicationDatabaseDao
import kotlinx.coroutines.*

class AddMedicationViewModel(val dao: MedicationDatabaseDao, application: Application) :
    AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val medName = MutableLiveData<String>()
    val form = MutableLiveData<String>()
    val count = MutableLiveData<String>()
    val dosage = MutableLiveData<String>()
    val comment = MutableLiveData<String>()


    private var medicationDataList = MutableLiveData<Medication?>()

    fun onCreateMedication() {
        Log.i("GG WP", "Pudge")
        Log.i("GGWP ", medName.value.toString())
        uiScope.launch {

            withContext(Dispatchers.IO) {
                dao.insert(
                    Medication(
                        //id = 0,
                        name = requireNotNull(medName.value),
                        form = requireNotNull(form.value),
                        quantity = requireNotNull(count.value).toInt(),
                        dosage = requireNotNull(dosage.value),
                        comment = requireNotNull(comment.value)
                    )
                )
            }

        }
    }

    private suspend fun insert(newMedication: Medication) {
        withContext(Dispatchers.IO) {
            dao.insert(newMedication)
        }
    }
}