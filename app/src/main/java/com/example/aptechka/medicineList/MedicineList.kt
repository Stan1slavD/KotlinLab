package com.example.aptechka.medicineList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.aptechka.R
import com.example.aptechka.databinding.FragmentMedicineListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MedicineList.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicineList : Fragment() {

    private lateinit var binding: FragmentMedicineListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_medicine_list, container, false);
        binding.fabMedList.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_medicineList2_to_medicine2)
        }
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_medicine_list, container, false)
        return binding.root
    }
}