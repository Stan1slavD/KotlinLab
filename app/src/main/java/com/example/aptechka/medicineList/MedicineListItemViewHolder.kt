package com.example.aptechka.medicineList

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.aptechka.R
import com.example.aptechka.database.MedicationList

class MedicineListItemViewHolder (val itemView: View): RecyclerView.ViewHolder(itemView) {

       val name: TextView = itemView.findViewById(R.id.nameList)
//    val form: TextView = itemView.findViewById(R.id.formTextView)
//    val count: TextView = itemView.findViewById(R.id.countTextView)
//    val dosage: TextView = itemView.findViewById(R.id.dosageTextView)
//    val comment: TextView = itemView.findViewById(R.id.commentTextView)
    val item_layout_list: androidx.constraintlayout.widget.ConstraintLayout =
        itemView.findViewById(R.id.item_layout_list)

    fun bind(item: MedicationList) {
        name.text=item.name.toString()
//        name.text = item.name.toString();
//        form.text = item.form.toString();
//        count.text = item.quantity.toString();
//        dosage.text = item.dosage.toString();
//        comment.text = item.comment.toString();
//        item_layout.setOnClickListener { view ->
//            Log.i("Sniper","Pudge")
//            Log.i("ID",item.id.toString() )
//            val bundle = Bundle()
//            bundle.putString("id", "value1")
//            bundle.putInt("arg2", 2)
//            //view.findNavController().navigate(R.id.action_medicine2_to_editMedication, item.id)
//            //Navigation.findNavController(this.itemView).navigate(R.id.action_medicine2_to_editMedication, bundle)
//            //Navigation.navigate(RoomsFragmentDirections.actionRoomsFragmentToMaterialEditorFragment(roomId = item.roomId))
//            //view.findNavController().navigate()
////            view.findNavController().navigate(
////                .actionGameFragmentToGameWonFragment(numQuestions, questionIndex))
//            view.findNavController().navigate(
//                MedicineDirections.actionMedicine2ToEditMedication(
//                requireNotNull( item.id)))
//

            //.actionRoomsFragmentToMaterialEditorFragment(roomId = item.roomId))
        item_layout_list.setOnClickListener{
            Log.i("NAME", name.text.toString())
            it.findNavController().navigate(MedicineListDirections.actionMedicineList2ToShowMedicineList(
                requireNotNull(name.text.toString())

            ))
        }
        }
    }
