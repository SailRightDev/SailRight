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

class CheckListFragment : Fragment() {

    private val sharedViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val boatPos = CheckListFragmentArgs.fromBundle(requireArguments()).boatNum

        var viewModel = sharedViewModel

        val thisBoat = sharedViewModel.boatsData[boatPos]

        val view = inflater.inflate(R.layout.fragment_check_list, container, false)
        val res = view.context.resources

        val boatImgView: ImageView = view.findViewById<ImageView>(R.id.cur_cl_image)
        val boatTitleTxVw: TextView = view.findViewById<TextView>(R.id.cur_cl_title)
        val boatFullTitleTxVw: TextView = view.findViewById<TextView>(R.id.cur_cl_fulltitle)
        val boatDescTxtVw: TextView = view.findViewById<TextView>(R.id.cur_cl_desc)
        val subButton: Button = view.findViewById<Button>(R.id.button_submit)

        boatImgView.setImageResource(thisBoat.imageResourceID)
        boatTitleTxVw.text = res.getString(thisBoat.boat_title_resID)
        boatFullTitleTxVw.text = res.getString(thisBoat.boat_fulltitle_resID)
        boatDescTxtVw.text = res.getString(thisBoat.boat_desc_resID)

        subButton.setOnClickListener {

            val etNameTxtVw: TextView = view.findViewById<TextView>(R.id.etName)
            val etEmailTxtVw: TextView = view.findViewById<TextView>(R.id.etEmail)
            val etComTxtVw: TextView = view.findViewById<TextView>(R.id.etComments)

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(etEmailTxtVw.text))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Checklist for ${boatFullTitleTxVw.text}")

            val emailMsgBody = StringBuilder()
            emailMsgBody.append("Hello\nMy name is ${etNameTxtVw.text}.\nToday I am renting a ${boatFullTitleTxVw.text} and I can certify that:\n\n")

            emailMsgBody.append(res.getString(R.string.CLQ1)).append("\n")
            emailMsgBody.append(res.getString(R.string.CLQ2)).append("\n")
            emailMsgBody.append(res.getString(R.string.CLQ3)).append("\n")
            emailMsgBody.append(res.getString(R.string.CLQ4)).append("\n")
            emailMsgBody.append("\nThank you. Have a good day.")
            intent.putExtra(Intent.EXTRA_TEXT, emailMsgBody.toString())

            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose an Email Client:"))
            }

        return view
    }

}