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
import com.example.aptechka.R
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.ChooseMedicineItemListBinding

class ChooseMedicineItemList:Fragment() {

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
        //val args = EditMedicationArgs.fromBundle(requireArguments())

        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = ChooseMedicineItemListViewModelFactory(dao, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ChooseMedicineItemListViewModel::class.java)
        val binding: ChooseMedicineItemListBinding =
            DataBindingUtil.inflate(inflater, R.layout.choose_medicine_item_list, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel=viewModel
        Log.i("List",viewModel.medicineList?.value?.size.toString())
        val countries = arrayOf("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")
//        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_multiple_choice, countries
//        )
//        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
//            this, android.R.layout.simple_list_item_multiple_choice, arrayOf<String>("Рыжик", "Барсик", "Мурзик")
//        )
//        var arrayAdapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1, list
//        )
        //Log.i("GGWP",viewModel.medicineList?.get(1)?.name.toString())
        //t= arrayListOf<List>(viewModel.medicineList.value)
        //viewModel.medicineList.value?.stream()?.forEach()
        var test :ArrayList<String> = arrayListOf();
        //test.add("2")
        val aa = ArrayAdapter(application,android.R.layout.simple_list_item_multiple_choice,
            test)
        //viewModel.med.forEach{it->Log.i("Med", it.name.toString())}
        viewModel.medicineList.observe(viewLifecycleOwner){list->list.forEach{el->aa.add(el.name)//test.add((el.name.toString()))
//aa.add("228")
        }}
        //viewModel.medicineList?.value?.forEach{it->test.add(it.name.toString())}
        Log.i("LL",test.size.toString())



        //viewModel.medicineList.forEach()
//        viewModel.medicineList.observe(viewLifecycleOwner){
//                data->adapter.data=data
//        }
        //viewModel.medicineList.observe()

        binding.listView.adapter=aa

//        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
//            {
//                SparseBooleanArray selected=countriesList.getCheckedItemPositions();
//
//                String selectedItems="";
//                for(int i=0;i < countries.length;i++)
//                {
//                    if(selected.get(i))
//                        selectedItems+=countries[i]+",";
//                }
//                // установка текста элемента TextView
//                selection.setText("Выбрано: " + selectedItems);
//            }
//        }
        var curSelectedItem=ArrayList<String>()
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            curSelectedItem.add(selectedItem.toString())
        //val intent = Intent(this, BookDetailActivity::class.java)
            //binding.listName.text.append(selectedItem.toString())
        //startActivity(intent)

        }
        binding.chooseBtn.setOnClickListener{
            curSelectedItem.forEach{item->
                viewModel.insertMedicationList(binding.listName.text.toString(),item.toString())
                Log.i("WORK","Work")
            }
        }

        binding.listName.setOnClickListener{

            //viewModel.insertMedicationList()
        }
        return binding.root;
    }
}