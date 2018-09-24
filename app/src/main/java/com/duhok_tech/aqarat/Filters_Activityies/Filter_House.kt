package com.duhok_tech.aqarat.Filters_Activityies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.duhok_tech.aqarat.R
import kotlinx.android.synthetic.main.activity_filter__house.*

class Filter_House : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter__house)


        //check the Rent and Sale toggle button
        toggleRent.setOnClickListener(View.OnClickListener {
            toggleSale.isChecked = !toggleSale.isChecked
        })
        toggleSale.setOnClickListener(View.OnClickListener {
            toggleRent.isChecked = !toggleRent.isChecked
        })


    }
}
