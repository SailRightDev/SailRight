package com.example.sailright

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.sailright.boats.model.AppViewModel

class HomeFragment : Fragment() {

    lateinit var viewModel : AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val clHeroImg = view.findViewById<ImageView>(R.id.Hero_CL_ImgView)
        val siHeroImg = view.findViewById<ImageView>(R.id.Hero_SI_ImgView)

        clHeroImg.setOnClickListener() {
            view.findNavController() .navigate(R.id.action_homeFragment_to_checkListsFragment)
            //val item = HomeFragmentDirections.actionHomeFragmentToTextbookFragment()
            //view.findNavController().navigate(item)
        }

        siHeroImg.setOnClickListener() {
            view.findNavController() .navigate(R.id.action_homeFragment_to_textbookFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

}