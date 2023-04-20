package com.example.aptechka.medicineList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechka.R
import com.example.aptechka.database.MedicationList
import java.lang.reflect.Array.set

class MedicineListAdapter : RecyclerView.Adapter<MedicineListItemViewHolder>() {
    var data = listOf<MedicationList>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.item_medication_list, parent, false)
        return MedicineListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineListItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}