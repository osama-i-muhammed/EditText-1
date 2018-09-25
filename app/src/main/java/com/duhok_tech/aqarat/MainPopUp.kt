package com.duhok_tech.aqarat

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import com.duhok_tech.aqarat.data.House
import kotlinx.android.synthetic.main.activity_add_menu.*
import kotlinx.android.synthetic.main.activity_main_pop_up.*

class MainPopUp : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pop_up)
        val dm = DisplayMetrics()

        try {


        }catch (ex:Exception){}
        windowManager.defaultDisplay.getMetrics(dm)

        val w = dm.widthPixels
        val h = dm.heightPixels

        window.setLayout(w, (h * .6).toInt())
//        getWindow().setLayout(100,100);

        val params = window.attributes
//        WindowManager.LayoutParams params=new WindowManager.LayoutParams();
        params.gravity = Gravity.BOTTOM
        params.x = 0
        params.y = -2
        window.attributes = params
    }
}
