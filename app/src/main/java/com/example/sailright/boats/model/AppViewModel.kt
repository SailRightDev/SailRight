package com.example.sailright.boats.model

import com.example.sailright.data.Datasouce
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {

    private var _boatsData: List<Boat> = Datasouce().loadBoats()
    val boatsData: List<Boat> = _boatsData

    private var _knotsData: List<Knot> = Datasouce().loadKnots()
    val knotsData: List<Knot> = _knotsData

}