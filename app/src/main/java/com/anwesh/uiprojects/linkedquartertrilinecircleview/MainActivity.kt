package com.anwesh.uiprojects.linkedquartertrilinecircleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.quartertrilinecircleview.QuarterTriLineCircleView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        QuarterTriLineCircleView.create(this)
    }
}
