package com.example.sailright

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sailright.R
import com.example.sailright.boats.model.AppViewModel

class TextbookFragment : Fragment() {

    lateinit var viewModel : AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_textbook, container, false)
        val ktHeroImg = view.findViewById<ImageView>(R.id.Hero_Kt_ImgView)

        ktHeroImg.setOnClickListener() {
            view.findNavController() .navigate(R.id.action_textbookFragment_to_knotListFragment)
        }

        return view
    }

}