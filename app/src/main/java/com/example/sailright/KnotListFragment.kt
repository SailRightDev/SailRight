package com.example.sailright

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.sailright.adapters.CLitemAdapter
import com.example.sailright.adapters.KtItemAdapter
import com.example.sailright.boats.model.AppViewModel

class KnotListFragment : Fragment() {

    private val sharedViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        var viewModel = sharedViewModel

        val view = inflater.inflate(R.layout.fragment_knot_list, container, false)

        val KtRecyclerView = view.findViewById<RecyclerView>(R.id.kt_recycler_view)

        KtRecyclerView.adapter = KtItemAdapter(sharedViewModel.knotsData)
        KtRecyclerView.setHasFixedSize(true)

        return view

    }

}