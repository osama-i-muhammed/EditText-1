package com.duhok_tech.aqarat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.duhok_tech.aqarat.Filters_Activityies.*
import kotlinx.android.synthetic.main.activity_filter__menu.*

class Filter_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter__menu)

        btFilterMenuHouse.setOnClickListener { startActivity(Intent(this,Filter_House::class.java)) }
        btFilterMenuApartment.setOnClickListener { startActivity(Intent(this,Filter_Aprt::class.java)) }
        btFilterMenuVilla.setOnClickListener { startActivity(Intent(this,Filter_Villa::class.java)) }
        btFilterMenuFarm.setOnClickListener { startActivity(Intent(this,Filter_Farm::class.java)) }
        btFilterMenuPartOfLand.setOnClickListener { startActivity(Intent(this,Filter_Earth::class.java)) }
        btFilterMenuStore.setOnClickListener { startActivity(Intent(this,Filter_Store::class.java)) }
        btFilterMenuStorage.setOnClickListener { startActivity(Intent(this,Filter_Storage::class.java)) }
    }
}
