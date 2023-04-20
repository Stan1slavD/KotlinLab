package com.example.aptechka.medicineList

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechka.R
import com.example.aptechka.database.MedicationList

class MedicineListItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView = itemView.findViewById(R.id.nameList)

    val item_layout_list: androidx.constraintlayout.widget.ConstraintLayout =
        itemView.findViewById(R.id.item_layout_list)

    fun bind(item: MedicationList) {
        name.text = item.name.toString()
        item_layout_list.setOnClickListener {
            Log.i("NAME", name.text.toString())
            it.findNavController().navigate(
                MedicineListDirections.actionMedicineList2ToShowMedicineList(
                    requireNotNull(name.text.toString())

                )
            )
        }
    }
}
