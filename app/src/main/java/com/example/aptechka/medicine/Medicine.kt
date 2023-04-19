package com.example.aptechka.medicine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aptechka.R
import com.example.aptechka.addMedication.AddMedicationViewModel
import com.example.aptechka.addMedication.AddMedicationViewModelFactory
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.FragmentAddMedicationBinding
import com.example.aptechka.databinding.FragmentMedicineBinding

class Medicine : Fragment() {
    private lateinit var viewModel: MedicineViewModel
    val adapter = MedicineAdapter()
    private lateinit var binding: FragmentMedicineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = MedicineViewModelFactory(dao, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MedicineViewModel::class.java)

        val binding: FragmentMedicineBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_medicine, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

       // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicine, container, false);


        binding.fabMed.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_medicine2_to_medicineList2)
        }
        binding.fabBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_medicine2_to_addMedication)
        }// Inflate the layout for this fragment
        //binding.medicineRecyclerView.setLayoutManager( LinearLayoutManager(this.context));
        binding.medicineRecyclerView.adapter=adapter
        binding.lifecycleOwner = viewLifecycleOwner

//        binding.viewModel =
//        binding.viewModel = viewModel

        viewModel.medicineList.observe(viewLifecycleOwner){
             data->adapter.data=data
        }
//        val application = requireActivity().application
//        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
//        val viewModelFactory = MedicineViewModelFactory(dao, application)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MedicineViewModel::class.java)

        return binding.root;
        // return inflater.inflate(R.layout.fragment_medicine, container, false)
    }

}