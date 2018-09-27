package com.duhok_tech.aqarat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.animation.Animation
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_viewer.*


class ImageViewer : Activity() {
    var animFinished = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)

        var imgR = intent.getStringArrayListExtra("img")

        //make Activity PopUp
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val w = dm.widthPixels
        val h = dm.heightPixels
        window.setLayout((w * .9).toInt(), (h * .7).toInt())
        val params = window.attributes
        params.gravity = Gravity.CENTER
        params.x = 0
        params.y = -2
        window.attributes = params

//        flipper.SetInAnimation(this, android.Resource.Animation.SlideInLeft);
//        flipper.SetOutAnimation(this, Android.Resource.Animation.SlideOutRight);

        viewFlipper.setInAnimation(this, android.R.anim.fade_in)
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out)

        viewFlipper.inAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                animFinished = false
            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                animFinished = true
            }
        })

        next.setOnClickListener { if (animFinished) viewFlipper.showNext() }
        previous.setOnClickListener { if (animFinished) viewFlipper.showPrevious() }

        for (imageID in imgR) {
            var iv = ImageView(this)
            Picasso.get().load(imageID).into(iv)
            viewFlipper.addView(iv)
            iv.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT)
            iv.setOnClickListener {
                Toast.makeText(this, iv.background.toString(), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ImageViewer::class.java).putExtra("img", imgR))
            }
        }

    }
}
