package com.duhok_tech.aqarat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.duhok_tech.aqarat.menuActivit.Aboutus
import com.duhok_tech.aqarat.menuActivit.Call
import com.duhok_tech.aqarat.menuActivit.InformationAbouApp
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
//
//        getWindow().setWindowAnimations(Animation.INFINITE)

        ssss.setOnClickListener {
            finish()
        }
        btMenuAddYourHouse.setOnClickListener { startActivity(Intent(this, AddMenu::class.java)) }
        btMenuContactAS.setOnClickListener { startActivity(Intent(this, Call::class.java)) }
        btMenuInformation.setOnClickListener { startActivity(Intent(this, InformationAbouApp::class.java)) }
        btMenuAboutAs.setOnClickListener { startActivity(Intent(this, Aboutus::class.java)) }
    }
}