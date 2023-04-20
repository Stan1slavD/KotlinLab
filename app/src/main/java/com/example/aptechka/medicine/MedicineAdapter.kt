package com.example.aptechka.medicine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechka.R
import com.example.aptechka.database.Medication

class MedicineAdapter : RecyclerView.Adapter<MedicineItemViewHolder>() {
    var data = listOf<Medication>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.item_medication, parent, false)
        return MedicineItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: MedicineItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

}
