package com.duhok_tech.aqarat

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.DisplayMetrics
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.duhok_tech.aqarat.Tools.Const
import com.duhok_tech.aqarat.data.Apartment
import com.duhok_tech.aqarat.data.House
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_pop_up.*
import java.text.DecimalFormat


class MainPopUp : Activity() {

    var arHouse = ArrayList<House>()
    var arApart = ArrayList<Apartment>()


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pop_up)

        when (intent.getStringExtra(Const.TYPE)) {
            Const.HOUSE -> {
                ivBuildType.background = getDrawable(findePhotoByTyoe(intent.getStringExtra(Const.TYPE)))
                if (intent.getIntExtra(Const.RENT_SALE, 0) == 1) {
                    tvPrice.text = DecimalFormat("#,###").format(intent.getDoubleExtra(Const.PRICE, 0.0)) + " $ / Month"
                } else {
                    tvPrice.text = DecimalFormat("#,###").format(intent.getDoubleExtra(Const.PRICE, 0.0)) + " $"
                }
                var Info: Array<Array<String>> = Array(7) { Array(2) { "" } }
                Info[0][0] = getString(R.string.Room) + " : "
                Info[0][1] = intent.getIntExtra(Const.ROOM, 0).toString()
                Info[1][0] = getString(R.string.Adress) + " : "
                Info[1][1] = intent.getStringExtra(Const.ADRESS)
                Info[2][0] = getString(R.string.bathroom) + " : "
                Info[2][1] = intent.getIntExtra(Const.BATHROOM, 0).toString()
                Info[3][0] = getString(R.string.hall) + " : "
                Info[3][1] = intent.getIntExtra(Const.LINIVGROOM, 0).toString()
                Info[4][0] = getString(R.string.SwedishRoom) + " : "
                Info[4][1] = intent.getIntExtra(Const.SWIDSHROOM, 0).toString()
                Info[5][0] = getString(R.string.garage) + " : "
                Info[5][1] = if (intent.getIntExtra(Const.GARAGE, 0) == 0) " No Garage" else intent.getIntExtra(Const.GARAGE, 0).toString() + " Car"
                Info[6][0] = getString(R.string.Area) + " : "
                Info[6][1] = DecimalFormat("#,###").format(intent.getDoubleExtra(Const.AREA, 0.0)) + " m2"
                setInfo(Info)
            }
            Const.APARTMENT -> {
                ivBuildType.background = getDrawable(findePhotoByTyoe(intent.getStringExtra(Const.TYPE)))
                if (intent.getIntExtra(Const.RENT_SALE, 0) == 1) {
                    tvPrice.text = DecimalFormat("#,###").format(intent.getDoubleExtra(Const.PRICE, 0.0)) + " $ / Month"
                } else {
                    tvPrice.text = DecimalFormat("#,###").format(intent.getDoubleExtra(Const.PRICE, 0.0)) + " $"
                }
                var Info: Array<Array<String>> = Array(6) { Array(2) { "" } }
                Info[0][0] = getString(R.string.Room) + " : "
                Info[0][1] = intent.getIntExtra(Const.ROOM, 0).toString()
                Info[1][0] = getString(R.string.Adress) + " : "
                Info[1][1] = intent.getStringExtra(Const.ADRESS)
                Info[2][0] = getString(R.string.bathroom) + " : "
                Info[2][1] = intent.getIntExtra(Const.BATHROOM, 0).toString()
                Info[3][0] = getString(R.string.hall) + " : "
                Info[3][1] = intent.getIntExtra(Const.LINIVGROOM, 0).toString()
                Info[4][0] = getString(R.string.SwedishRoom) + " : "
                Info[4][1] = intent.getIntExtra(Const.SWIDSHROOM, 0).toString()
                Info[5][0] = getString(R.string.Area) + " : "
                Info[5][1] = DecimalFormat("#,###").format(intent.getDoubleExtra(Const.AREA, 0.0)) + " m2"
                setInfo(Info)
            }
        }


        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val w = dm.widthPixels
        val h = dm.heightPixels
        window.setLayout(w, (h * .7).toInt())
        val params = window.attributes
        params.gravity = Gravity.BOTTOM
        params.x = 0
        params.y = -2
        window.attributes = params


        var arIMG = ArrayList<ImageView>()

        var imgR = ArrayList<String>()
        imgR.add("https://cnet4.cbsistatic.com/img/9vEVqVx3KOqT0RGAswuhGv3YFSk=/830x467/2017/10/31/a22348c2-6d9b-4c45-9b4d-e5e2d1ce0344/iphone-x-comparisons-01.jpg")
        imgR.add("https://pbs.twimg.com/profile_images/817389061564493825/c8wrPD8L_400x400.jpg")
        imgR.add("https://www.boostmobile.com/content/dam/boostmobile/en/products/phones/apple/iphone-6s/space-gray/device-front.png.transform/pdpCarousel/image.jpg")
        imgR.add("https://pbs.twimg.com/profile_images/817389061564493825/c8wrPD8L_400x400.jpg")
        imgR.add("https://www.google.iq/logos/doodles/2018/googles-20th-birthday-6342583134453760.7-s.png")
        imgR.add("https://pbs.twimg.com/profile_images/817389061564493825/c8wrPD8L_400x400.jpg")
        imgR.add("https://www.google.iq/logos/doodles/2018/googles-20th-birthday-6342583134453760.7-s.png")
        imgR.add("https://pbs.twimg.com/profile_images/817389061564493825/c8wrPD8L_400x400.jpg")

        arIMG.add(ImageView(this))
        arIMG.add(ImageView(this))
        arIMG.add(ImageView(this))
        arIMG.add(ImageView(this))
        arIMG.add(ImageView(this))

        val d = resources.getDimension(R.dimen.padd).toInt()
        var lp: LinearLayout.LayoutParams? = null

        for (imageID in imgR) {
            var iv = ImageView(this)
//            iv.background = getDrawable(imageID)
            Picasso.get().load(imageID).into(iv)
            //imgR.add(iv.background)
            cdcd.addView(iv)
            lp = LinearLayout.LayoutParams(iv.layoutParams)
            lp.setMargins(d, d, d, d)
            iv.layoutParams = lp
            iv.layoutParams.height = resources.getDimension(R.dimen.imageview_height).toInt()
            iv.layoutParams.width = resources.getDimension(R.dimen.imageview_height).toInt()
            iv.setOnClickListener {
//                                Toast.makeText(this,iv.background.toString(),Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ImageViewer::class.java).putExtra("img",imgR))
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setInfo(info: Array<Array<String>>) {
        var arLin = ArrayList<ArrayList<Any>>()
        for (i in 1..info.size) {
            var lttl = ArrayList<Any>()
            lttl.add(TextView(this))
            lttl.add(TextView(this))
            lttl.add(LinearLayout(this))
            lttl.add(LinearLayout(this))
            arLin.add(lttl)
        }
        var ind: Int = 0
        for (infoLine in arLin) {
            var tv1 = infoLine[0] as TextView
            tv1.text = info[ind][0]
            tv1.textSize = 20f
            var tv2 = infoLine[1] as TextView
            tv2.text = info[ind][1]
            if (Build.VERSION.SDK_INT >= 21) {
                tv2.setTextColor(getColor(R.color.colorTxt2))
                tv1.setTextColor(getColor(R.color.colorTxt2))
            }
            tv2.textSize = 20f
            var lin1 = infoLine[2] as LinearLayout
            var lin2 = infoLine[3] as LinearLayout

            lin2.background = getDrawable(R.color.colorTxt2)

            infoLiniearaLayout.addView(lin1)
            infoLiniearaLayout.addView(lin2)

            lin1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            lin2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (this.resources.displayMetrics.density * 1).toInt())
            lin1.addView(tv1)
            lin1.addView(tv2)
            tv1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            tv2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            ind++
        }

    }

    fun findePhotoByTyoe(type: String): Int {
        when (type) {
            "house" -> return R.drawable.house
            "villa" -> return R.drawable.villa
            "apartment" -> return R.drawable.apartment
            "store" -> return R.drawable.store
            "Storage" -> return R.drawable.storage
            "land" -> return R.drawable.land
            "Farm" -> return R.drawable.field
            else -> return R.drawable.land
        }
    }
}
