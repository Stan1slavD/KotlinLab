package com.example.aptechka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.example.aptechka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //replaceFragment(Medicine())

//        binding.bottomNavigationView.setOnItemSelectedListener {
//
//            when(it.itemId){
//
//                R.id.medicineList -> {
//                    Navigation.findNavController(binding.root).navigate(R.id.action_medicine2_to_medicineList2)
//
//                }//replaceFragment(binding.root)
//                R.id.medicine ->{
//                    Navigation.findNavController(binding.root).navigate(R.id.action_medicineList2_to_medicine2)
//
//                }// replaceFragment(binding.root)
//
//                else ->{
//
//
//                }
//
//            }
//
//            true
//
//        }


    }

    //private fun replaceFragment(fragment : Fragment){
    private fun replaceFragment(view : View){

        Navigation.findNavController(view).navigate(R.id.action_medicine2_to_addMedication)

//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.navHostFragment,fragment)
//        fragmentTransaction.commit()


    }
}