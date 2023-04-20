package com.example.aptechka.chooseItemMedicineList

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.aptechka.R
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.ChooseMedicineItemListBinding

class ChooseMedicineItemList : Fragment() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = ChooseMedicineItemListViewModelFactory(dao, application)
        val viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(ChooseMedicineItemListViewModel::class.java)
        val binding: ChooseMedicineItemListBinding =
            DataBindingUtil.inflate(inflater, R.layout.choose_medicine_item_list, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        var test: ArrayList<String> = arrayListOf();
        val aa = ArrayAdapter(
            application, android.R.layout.simple_list_item_multiple_choice,
            test
        )
        viewModel.medicineList.observe(viewLifecycleOwner) { list ->
            list.forEach { el ->
                aa.add(el.name)//test.add((el.name.toString()))
            }
        }


        binding.listView.adapter = aa

        var curSelectedItem = ArrayList<String>()
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            curSelectedItem.add(selectedItem.toString())


        }
        binding.chooseBtn.setOnClickListener {
            curSelectedItem.forEach { item ->
                viewModel.insertMedicationList(binding.listName.text.toString(), item.toString())
                Log.i("WORK", "Work")
            }
            Navigation.findNavController(it).navigate(R.id.action_chooseMedicineItemList_to_medicineList2)
        }

        binding.listName.setOnClickListener {

        }
        return binding.root;
    }
}