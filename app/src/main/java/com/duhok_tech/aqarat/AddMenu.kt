package com.duhok_tech.aqarat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.duhok_tech.aqarat.InsertActivit.*
import kotlinx.android.synthetic.main.activity_add_menu.*


class AddMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)
        btAddMenuHouse.setOnClickListener { startActivity(Intent(this,Add_House::class.java)) }
        btAddMenuApartment.setOnClickListener { startActivity(Intent(this,Add_Apart::class.java)) }
        btAddMenuVilla.setOnClickListener { startActivity(Intent(this,Add_Villa::class.java)) }
        btAddMenuFarm.setOnClickListener { startActivity(Intent(this,Add_Farm::class.java)) }
        btAddMenuPartOfLand.setOnClickListener { startActivity(Intent(this,Add_Earth::class.java)) }
        btAddMenuStore.setOnClickListener { startActivity(Intent(this,Add_Store::class.java)) }
        btAddMenuStorage.setOnClickListener { startActivity(Intent(this,Add_Storage::class.java)) }
    }

}
