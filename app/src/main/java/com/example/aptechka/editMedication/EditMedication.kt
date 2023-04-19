package com.example.aptechka.showMedication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aptechka.R
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.FragmentEditMedicineBinding
import com.example.aptechka.medicine.MedicineViewModel
import com.example.aptechka.medicine.MedicineViewModelFactory

class EditMedication :Fragment() {
    private lateinit var binding: FragmentEditMedicineBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val args = Medici.fromBundle(requireArguments())
//
//    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        //val viewModelFactory = EditMedicationViewModelFactory(dao, application,id, name, form = )
        //val viewModel = ViewModelProvider(this, viewModelFactory).get(EditMedicationViewModel::class.java)
        val args=showMedicationArgs
        val binding: FragmentEditMedicineBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_medicine, container, false);
//        binding.deleteBtn.setOnClickListener{
//            view->
//            Log.i("Delete", "Delete")
//        }
        //val args=
//val args=
    binding.apply {

    }
//    binding.medId.text= args.id.toString()
//    binding.deleteBtn.setOnClickListener{
//        view->binding.editTextTextPersonName.visibility=View.VISIBLE
//        binding.medId.visibility=View.INVISIBLE
//
//    }

    //MedicineA.fromBundle(requireArguments())
//val args =
    //binding.medId.text=
//        binding.lifecycleOwner = viewLifecycleOwner
//        binding.viewModel = viewModel

        // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicine, container, false);


//        binding.fabMed.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_medicine2_to_medicineList2)
//        }
//        binding.fabBtn.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_medicine2_to_addMedication)
//        }// Inflate the layout for this fragment
//        //binding.medicineRecyclerView.setLayoutManager( LinearLayoutManager(this.context));
//        binding.medicineRecyclerView.adapter=adapter
//        binding.lifecycleOwner = viewLifecycleOwner
//
////        binding.viewModel =
////        binding.viewModel = viewModel
//
//        viewModel.medicineList.observe(viewLifecycleOwner){
//                data->adapter.data=data
//        }
//        val application = requireActivity().application
//        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
//        val viewModelFactory = MedicineViewModelFactory(dao, application)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MedicineViewModel::class.java)

        return binding.root;
        // return inflater.inflate(R.layout.fragment_medicine, container, false)
    }
    private fun editMedication(){
        binding.apply {

        }
    }

    private fun hideText(){
        binding.apply {

        }
    }
}