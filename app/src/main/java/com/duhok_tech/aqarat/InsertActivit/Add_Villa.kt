package com.duhok_tech.aqarat.InsertActivit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.duhok_tech.aqarat.R
import kotlinx.android.synthetic.main.activity_add__villa.*

class Add_Villa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__villa)

        //check the Rent and Sale toggle button
        toggleRent.setOnClickListener(View.OnClickListener {
            toggleSale.isChecked = !toggleSale.isChecked
        })
        toggleSale.setOnClickListener(View.OnClickListener {
            toggleRent.isChecked = !toggleRent.isChecked
        })
    }
}
