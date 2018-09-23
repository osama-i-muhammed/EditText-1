package com.duhok_tech.aqarat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_desing_test.*

class DesingTEST : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desing_test)


        toggleButton.setOnClickListener(View.OnClickListener {

                toggleButton2.isChecked = !toggleButton2.isChecked

        })
        toggleButton2.setOnClickListener(View.OnClickListener {

                toggleButton.isChecked = !toggleButton.isChecked

        })

    }
}
