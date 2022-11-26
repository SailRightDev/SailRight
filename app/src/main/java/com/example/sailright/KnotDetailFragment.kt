package com.example.sailright

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.sailright.R
import com.example.sailright.boats.model.AppViewModel
import java.lang.StringBuilder

class KnotDetailFragment : Fragment() {

    private val sharedViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val knotPos = KnotDetailFragmentArgs.fromBundle(requireArguments()).knotNum

        var viewModel = sharedViewModel

        val thisKot = sharedViewModel.knotsData[knotPos]

        val view = inflater.inflate(R.layout.fragment_knot_detail, container, false)
        val res = view.context.resources

        val knotImgView: ImageView = view.findViewById<ImageView>(R.id.cur_kt_image)
        val s1TxVw: TextView = view.findViewById<TextView>(R.id.cur_kt_step1)
        val s2TxVw: TextView = view.findViewById<TextView>(R.id.cur_kt_step2)
        val s3TxVw: TextView = view.findViewById<TextView>(R.id.cur_kt_step3)

        knotImgView.setImageResource(thisKot.imageResourceID)
        s1TxVw.text = res.getString(thisKot.knot_s1_resID)
        s2TxVw.text = res.getString(thisKot.knot_s2_resID)
        s3TxVw.text = res.getString(thisKot.knot_s3_resID)

        return view
    }

}