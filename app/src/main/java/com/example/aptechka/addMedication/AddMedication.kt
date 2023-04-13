package com.example.aptechka.addMedication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.aptechka.R
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.FragmentAddMedicationBinding
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 * Use the [AddMedication.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddMedication : Fragment() {

    //private lateinit var binding: FragmentAddMedicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = AddMedicationViewModelFactory(dao, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AddMedicationViewModel::class.java)


       val binding:FragmentAddMedicationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_medication, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
//        viewModel.medName.observe(viewLifecycleOwner, Observer { med ->
//            binding.nameEditText.text = med.to
//        })
        binding.createFab.setOnClickListener {
            //Log.i("EZ", binding.nameEditText.text.toString())
            viewModel.onCreateMedication()
            //Navigation.findNavController(it).navigate(R.id.action_addMedication_to_medicine2)
        }
        binding.cancelFab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_addMedication_to_medicine2)
        }
        // Inflate the layout for this fragment
        return binding.root
        //return inflater.inflate(R.layout.add_fragment, container, false)
    }

}