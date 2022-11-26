package com.example.sailright.data

import com.example.sailright.R
import com.example.sailright.boats.model.Boat
import com.example.sailright.boats.model.Knot

class Datasouce {

    fun loadBoats(): List<Boat>{

        return listOf<Boat>(

            //create boat objects. pass obj creator resource IDs of the following:
            //title, fulltitle, length, draft, disp, img

            Boat(R.string.boat_capri22_title, R.string.boat_capri22_fulltitle, R.string.boat_capri22_desc,
                R.integer.boat_capri22_len_ft, R.integer.boat_capri22_draft_ft, R.integer.boat_capri22_disp_lb, R.drawable.capri_22_140dp),
            Boat(R.string.boat_hunter31_title, R.string.boat_hunter31_fulltitle, R.string.boat_hunter31_desc,
                R.integer.boat_hunter31_len_ft, R.integer.boat_hunter31_draft_ft, R.integer.boat_hunter31_disp_lb, R.drawable.hunter_31_140dp),
            Boat(R.string.boat_oceanis37_title, R.string.boat_oceanis37_fulltitle, R.string.boat_oceanis37_desc,
                R.integer.boat_oceanis37_len_ft, R.integer.boat_oceanis37_draft_ft, R.integer.boat_oceanis37_disp_lb, R.drawable.oceanis_37_140dp),
            Boat(R.string.boat_first44_title, R.string.boat_first44_fulltitle, R.string.boat_first44_desc,
                R.integer.boat_first44_len_ft, R.integer.boat_first44_draft_ft, R.integer.boat_first44_disp_lb, R.drawable.first_44_140dp)

        )

    }

    fun loadKnots(): List<Knot>{

        return listOf<Knot>(

            //create knot objects. pass obj creator resource IDs of the following:
            //title, uses, step1, step2, step3, img

            Knot(R.string.kt_cleat_hitch_title, R.string.kt_cleat_hitch_uses,
                R.string.kt_cleat_hitch_s1, R.string.kt_cleat_hitch_s2, R.string.kt_cleat_hitch_s3,
                R.drawable.kt_cleat_hitch_140dp),
            Knot(R.string.kt_fig8_title, R.string.kt_fig8_uses,
                R.string.kt_fig8_s1, R.string.kt_fig8_s2, R.string.kt_fig8_s3,
                R.drawable.kt_fig8_140dp),
            Knot(R.string.kt_rolling_hitch_title, R.string.kt_rolling_hitch_uses,
                R.string.kt_rolling_hitch_s1, R.string.kt_rolling_hitch_s2, R.string.kt_rolling_hitch_s3,
                R.drawable.kt_rolling_hitch_140dp),
            Knot(R.string.kt_square_title, R.string.kt_square_uses,
                R.string.kt_square_s1, R.string.kt_square_s2, R.string.kt_square_s3,
                R.drawable.kt_square_140dp)

        )

    }

}