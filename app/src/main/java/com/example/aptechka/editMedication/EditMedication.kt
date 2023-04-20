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

class EditMedication : Fragment() {
    private lateinit var binding: FragmentEditMedicineBinding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = EditMedicationArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = EditMedicationViewModelFactory(dao, application, args.id)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(EditMedicationViewModel::class.java)
        val binding: FragmentEditMedicineBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_medicine, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        var  old:String=""
        viewModel.medName.observeForever{if(old.isEmpty()){old=viewModel.medName.value.toString()
        }}
        Log.i("BIND", binding.nameText.text.toString())
        binding.editMedicationBtn.setOnClickListener { view ->
            binding.apply {
                binding.editMedicationBtn.visibility = View.INVISIBLE
                binding.backBtn.visibility = View.INVISIBLE
                binding.applyChangesBtn.visibility = View.VISIBLE
                binding.canclelBtn.visibility = View.VISIBLE
                nameText.visibility = View.INVISIBLE
                formText.visibility = View.INVISIBLE
                countText.visibility = View.INVISIBLE
                dosageText.visibility = View.INVISIBLE
                commentText.visibility = View.INVISIBLE
                editName.visibility = View.VISIBLE
                editForm.visibility = View.VISIBLE
                editCount.visibility = View.VISIBLE
                editDosage.visibility = View.VISIBLE
                editComment.visibility = View.VISIBLE
            }
        }
        binding.apply {
            editMedicationBtn.visibility = View.VISIBLE
            editName.visibility = View.INVISIBLE
            editForm.visibility = View.INVISIBLE
            editCount.visibility = View.INVISIBLE
            editDosage.visibility = View.INVISIBLE
            editComment.visibility = View.INVISIBLE
        }
        binding.backBtn.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_editMedication_to_medicine2)
        }
        binding.canclelBtn.setOnClickListener{view ->
            Navigation.findNavController(view).navigate(R.id.action_editMedication_to_medicine2)}
        binding.delleteBtn.setOnClickListener { view ->
            viewModel.deleteMedicationById()
            viewModel.deleteMedicationByNameInList(binding.editName.text.toString())
            Navigation.findNavController(view).navigate(R.id.action_editMedication_to_medicine2)
        }
        binding.applyChangesBtn.setOnClickListener { view ->
            viewModel.updateMedication(
                binding.editName.text.toString(),
                binding.editForm.text.toString(),
                binding.editCount.text.toString(),
                binding.editDosage.text.toString(),
                binding.editComment.text.toString()
            )
            viewModel.updateMedicineList(binding.editName.text.toString(), old )
            Navigation.findNavController(view).navigate(R.id.action_editMedication_to_medicine2)

        }

        return binding.root;
    }

    private fun editMedication() {
        binding.apply {

        }
    }

    private fun hideText() {
        binding.apply {

        }
    }
}