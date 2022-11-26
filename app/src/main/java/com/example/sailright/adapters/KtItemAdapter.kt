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
import com.example.sailright.KnotListFragmentDirections
import com.example.sailright.R
import com.example.sailright.boats.model.Boat
import com.example.sailright.boats.model.Knot

class KtItemAdapter(val dataset: List<Knot>) : RecyclerView.Adapter<KtItemAdapter.KtItemViewHolder>() {

    class KtItemViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewTitle: TextView = itemView.findViewById(R.id.kt_item_title)
        val textViewUses: TextView = itemView.findViewById(R.id.kt_item_uses)

        val imgView: ImageView = itemView.findViewById(R.id.kt_item_image)

        fun bind(item: Knot, listPos: Int) {

            val res = itemView.context.resources

            textViewTitle.text = res.getString(item.knot_title_resID)
            textViewUses.text = res.getString(item.knot_uses_resID)

            imgView.setImageResource(item.imageResourceID)

            var myNavController: NavController? = null

            itemView.setOnClickListener(){

                //val action = CheckListsFragmentDirections.actionCheckListsFragmentToCheckListFragment()
                val action = KnotListFragmentDirections.actionKnotListFragmentToKnotDetailFragment()
                action.knotNum = listPos

                itemView.findNavController().navigate(action)
            }

            // myNavController = Navigation.findNavController(itemView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KtItemAdapter.KtItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.knot_list_item, parent, false)

        return KtItemAdapter.KtItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: KtItemAdapter.KtItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}