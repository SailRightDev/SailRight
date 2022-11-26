package com.example.sailright.adapters

import android.content.Context
import android.util.Half.toFloat
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sailright.CheckListsFragmentDirections
import com.example.sailright.R
import com.example.sailright.boats.model.Boat

class CLitemAdapter(val dataset: List<Boat>) : RecyclerView.Adapter<CLitemAdapter.CLitemViewHolder>() {

    class CLitemViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewShortTitle: TextView = itemView.findViewById(R.id.cl_item_title)
        val textViewFullTitle: TextView = itemView.findViewById(R.id.cl_item_fulltitle)
        val textViewDesc: TextView = itemView.findViewById(R.id.cl_item_desc)
        val textViewLength: TextView = itemView.findViewById(R.id.cl_item_len)
        val textViewDraft: TextView = itemView.findViewById(R.id.cl_item_draft)
        val textViewDisp: TextView = itemView.findViewById(R.id.cl_item_disp)

        val imgView: ImageView = itemView.findViewById(R.id.cl_item_image)

        fun bind(item: Boat, listPos: Int) {

            val res = itemView.context.resources

            textViewShortTitle.text = res.getString(item.boat_title_resID)
            textViewFullTitle.text = res.getString(item.boat_fulltitle_resID)
            textViewDesc.text = res.getString(item.boat_desc_resID)

            val outValue: TypedValue = TypedValue()
            res.getValue(item.boat_len_resID, outValue, true)
            val boatLenFt: Float = outValue.float
            val boatLenM: Float = (boatLenFt * 0.3048).toFloat()
            res.getValue(item.boat_draft_resID, outValue, true)
            val boatDraftFt: Float = outValue.float
            val boatDraftM: Float = (boatDraftFt * 0.3048).toFloat()
            res.getValue(item.boat_disp_resID, outValue, true)
            val boatDispLB: Float = outValue.float
            val boatDispKG: Float = (boatDispLB * 0.453592).toFloat()

            val boatLenFtTrun = String.format("%.1f",boatLenFt)
            val boatLenMTrun = String.format("%.1f",boatLenM)
            textViewLength.text = "${boatLenFtTrun}ft (${boatLenMTrun}m)"

            val boatDraftFtTrun = String.format("%.1f",boatDraftFt)
            val boatDraftMTrun = String.format("%.1f",boatDraftM)
            textViewDraft.text = "${boatDraftFtTrun}ft (${boatDraftMTrun}m)"

            val boatDispLBTrun = String.format("%.1f",boatDispLB)
            val boatDispKGTrun = String.format("%.1f",boatDispKG)
            textViewDisp.text = "${boatDispLBTrun}lb (${boatDispKGTrun}kg)"

            imgView.setImageResource(item.imageResourceID)

            var myNavController: NavController? = null

            itemView.setOnClickListener(){

                val action = CheckListsFragmentDirections.actionCheckListsFragmentToCheckListFragment()
                action.boatNum = listPos

                itemView.findNavController().navigate(action)
            }

               // myNavController = Navigation.findNavController(itemView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CLitemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.cl_list_item, parent, false)

        return CLitemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CLitemViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}