package com.duhok_tech.aqarat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.duhok_tech.aqarat.Filters_Activityies.*
import kotlinx.android.synthetic.main.activity_desing_test.*

class DesingTEST : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desing_test)

        //SAlark
        //SAlark
        //SAlark
        //SAlark

        house.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Filter_House::class.java))
        })

        villa.setOnClickListener {
            startActivity(Intent(this, Filter_Villa::class.java))
        }

        Apart.setOnClickListener {
            startActivity(Intent(this, Filter_Aprt::class.java))
        }

        Storage.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Filter_Storage::class.java))
        })

        Store.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Filter_Store::class.java))
        })

        Farm.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Filter_Farm::class.java))
        })

        Earth.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Filter_Earth::class.java))
        })

    }
}
