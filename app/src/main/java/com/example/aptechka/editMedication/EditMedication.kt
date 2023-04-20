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
import androidx.navigation.Navigation
import com.example.aptechka.R
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.FragmentEditMedicineBinding
import com.example.aptechka.editMedication.EditMedicationViewModel

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
        val args =EditMedicationArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = EditMedicationViewModelFactory(dao, application,args.id)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(EditMedicationViewModel::class.java)
        val binding: FragmentEditMedicineBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_medicine, container, false);
    binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel=viewModel
    Log.i("BIND", binding.nameText.text.toString())
    binding.editMedicationBtn.setOnClickListener{
        view->binding.apply {
        binding.editMedicationBtn.visibility=View.INVISIBLE
        binding.backBtn.visibility=View.INVISIBLE
        binding.applyChangesBtn.visibility=View.VISIBLE
        binding.canclelBtn.visibility=View.VISIBLE
        nameText.visibility=View.INVISIBLE
        formText.visibility=View.INVISIBLE
        countText.visibility=View.INVISIBLE
        dosageText.visibility=View.INVISIBLE
        commentText.visibility=View.INVISIBLE
        editName.visibility=View.VISIBLE
        editForm.visibility=View.VISIBLE
        editCount.visibility=View.VISIBLE
        editDosage.visibility=View.VISIBLE
        editComment.visibility=View.VISIBLE
    }
    }
    binding.apply {
        editMedicationBtn.visibility=View.VISIBLE
        //canclelBtn.visibility=View.VISIBLE
//        backBtn.visibility=View.VISIBLE
//        nameText.visibility=View.VISIBLE
//        formText.visibility=View.VISIBLE
//        countText.visibility=View.VISIBLE
//        dosageText.visibility=View.VISIBLE
//        commentText.visibility=View.VISIBLE
        editName.visibility=View.INVISIBLE
        editForm.visibility=View.INVISIBLE
        editCount.visibility=View.INVISIBLE
        editDosage.visibility=View.INVISIBLE
        editComment.visibility=View.INVISIBLE
    }

    binding.delleteBtn.setOnClickListener{
        view->
        viewModel.deleteMedicationById()
        Navigation.findNavController(view).navigate(R.id.action_editMedication_to_medicine2)
    }
    binding.applyChangesBtn.setOnClickListener{
        view->viewModel.updateMedication(binding.editName.text.toString(),binding.editForm.text.toString(), binding.editCount.text.toString(), binding.editDosage.text.toString(), binding.editComment.text.toString() )
    }
//    binding.medId.text= args.id.toString()
//    binding.deleteBtn.setOnClickListener{
//        view->binding.editTextTextPersonName.visibility=View.VISIBLE
//        binding.medId.visibility=View.INVISIBLE
//
//    }

    //MedicineA.fromBundle(requireArguments())

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