package com.example.aptechka.medicine

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechka.R
import com.example.aptechka.database.Medication


class MedicineItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.nameTextView)
    val form: TextView = itemView.findViewById(R.id.formTextView)
    val count: TextView = itemView.findViewById(R.id.countTextView)
    val dosage: TextView = itemView.findViewById(R.id.dosageTextView)
    val comment: TextView = itemView.findViewById(R.id.commentTextView)
    val item_layout: androidx.constraintlayout.widget.ConstraintLayout =
        itemView.findViewById(R.id.item_layout)

    fun bind(item: Medication) {
        name.text = item.name.toString();
        form.text = item.form.toString();
        count.text = item.quantity.toString();
        dosage.text = item.dosage.toString();
        comment.text = item.comment.toString();
        item_layout.setOnClickListener { view ->
            view.findNavController().navigate(
                MedicineDirections.actionMedicine2ToEditMedication(
                    requireNotNull(item.id)
                )
            )


        }
    }
}