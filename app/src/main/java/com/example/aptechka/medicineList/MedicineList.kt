package com.example.aptechka.medicineList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.aptechka.R
import com.example.aptechka.database.MedicationDatabase
import com.example.aptechka.databinding.FragmentMedicineBinding
import com.example.aptechka.databinding.FragmentMedicineListBinding
import com.example.aptechka.medicine.MedicineAdapter
import com.example.aptechka.medicine.MedicineViewModel
import com.example.aptechka.medicine.MedicineViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [MedicineList.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicineList : Fragment() {

    private lateinit var binding: FragmentMedicineListBinding
    val adapter = MedicineListAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        val dao = MedicationDatabase.getInstance(application).getMedicationDatabaseDao()
        val viewModelFactory = MedicineListViewModelFactory(dao, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MedicineListViewModel::class.java)

//        val binding: FragmentMedicineBinding =
//            DataBindingUtil.inflate(inflater, R.layout.fragment_medicine, container, false);

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_medicine_list, container, false);
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.fabMedList.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_medicineList2_to_medicine2)
        }
        binding.fabBtn.setOnClickListener{
            view->
            Navigation.findNavController(view).navigate(R.id.action_medicineList2_to_chooseMedicineItemList)
        }
        viewModel.medList.observe(viewLifecycleOwner){
                data->adapter.data=data
        }
        //binding.medicineListRecyclerView.set
        binding.medicineListRecyclerView.adapter=adapter
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_medicine_list, container, false)
        return binding.root
    }
}