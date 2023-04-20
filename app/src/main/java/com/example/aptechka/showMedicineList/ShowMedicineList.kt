package com.example.aptechka.showMedicineList

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import com.example.aptechka.databinding.FragmentShowMdicineListBinding


class ShowMedicineList : Fragment(){
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = ShowMedicineListArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = ShowMedicineListViewModelFactory(dao, application, args.nameList)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(
            ShowMedicineListViewModel::class.java)
        val binding: FragmentShowMdicineListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_show_mdicine_list, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel=viewModel

        var test :ArrayList<String> = arrayListOf();
        val aa = ArrayAdapter(application,android.R.layout.simple_list_item_1,
            test)
        viewModel.medicineList.observe(viewLifecycleOwner){list->list.forEach{el->
            if(el.name.equals(args.nameList)){
                aa.add(el.medicationName)
            }

        }}
        binding.nameListTextView.text=args.nameList
        binding.backBtn.setOnClickListener{
            view->
            Navigation.findNavController(view).navigate(R.id.action_showMedicineList_to_medicineList2)
        }
        binding.listListView.adapter=aa

            return binding.root;
    }
}