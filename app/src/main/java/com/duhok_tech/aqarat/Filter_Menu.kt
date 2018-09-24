package com.duhok_tech.aqarat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_filter__menu.*

class Filter_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter__menu)

        btFilterMenuHouse.setOnClickListener{
            Toast.makeText(this,"sdsad",Toast.LENGTH_SHORT).show()
        }
    }
}
