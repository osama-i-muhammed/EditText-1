package com.duhok_tech.aqarat.Filters_Activityies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.duhok_tech.aqarat.R
import kotlinx.android.synthetic.main.activity_filter__farm.*

class Filter_Farm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter__farm)


        //check the Rent and Sale toggle button
        toggleRent.setOnClickListener {
            toggleSale.isChecked = !toggleSale.isChecked
        }
        toggleSale.setOnClickListener(View.OnClickListener {
            toggleRent.isChecked = !toggleRent.isChecked
        })


    }
}
