package com.example.aptechka.medicine

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
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
        viewModel = ViewModelProvider(this, viewModelFactory).get(MedicineViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicine, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        binding.fabMed.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_medicine2_to_medicineList2)
        }
        binding.fabBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_medicine2_to_addMedication)
        }
        binding.medicineRecyclerView.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.medicineList.observe(viewLifecycleOwner) { data ->
            adapter.data = data
        }



        binding.search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateSearch()
            }
        }
        )


        return binding.root;
    }

    private fun updateSearch() {

        val s = binding.search.text

        if (s?.length == 0) {
            adapter.data = viewModel.medicineList.value!!

        } else {

            adapter.data = viewModel.medicineList.value?.filter {
                it.name.toString().startsWith(s.toString(), true) || it.name.toString()
                    .contains(s.toString(), true)
            } as ArrayList
        }
        adapter.notifyDataSetChanged()
    }
}