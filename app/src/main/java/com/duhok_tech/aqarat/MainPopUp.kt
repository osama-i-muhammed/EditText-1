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



        var imgR = ArrayList<String>()
        imgR.add("https://i3.au.reastatic.net/640x480/23c94a60c4138ecf26f81753c69ce5d615188061d6333a585d01c36efe58e7c6/image2.jpg")
        imgR.add("https://i4.au.reastatic.net/640x480/fc2fa861df8e8da18b51e3fe261c5c9407f144f67668dcb5a866b858c44fb389/image3.jpg")
        imgR.add("http://blog.nkdroidsolutions.com/wp-content/uploads/2016/02/device-2016-02-20-205832-1.png")
        imgR.add("https://i1.au.reastatic.net/640x480/b27cb6133c40f0d7e93e23303be79cb853bbe1897397a06461a4942f2d347072/image4.jpg")
        imgR.add("https://i2.au.reastatic.net/640x480/e3df2b24e4de22a628e261d3c0fe0fbf8a8ba7743841e59beded5f1f58e91cc0/image5.jpg")
        imgR.add("https://i3.au.reastatic.net/640x480/3ee7530bc207c6f519cd8950e322af8f0a51e88d7d88f28dc69ad9b4973c360c/image6.jpg")
        imgR.add("https://i4.au.reastatic.net/640x480/8ff7b14e7714e89c0c3fa109d1da029eaa2a23a904ccb7b02601470d70ccc806/image7.jpg")
        imgR.add("https://i1.au.reastatic.net/640x480/6540947aec9747c60628e8383c744c3c5dfb8cadd1745f3eb4636038f49b4146/image8.jpg")
        imgR.add("https://i2.au.reastatic.net/640x480/4d4d09062f7e26848cc684e1365661fea1f4c630a18cfbdb7863d4e2f34d9b0c/image9.jpg")
        imgR.add("https://i3.au.reastatic.net/640x480/52b2681fccbec82329e17c6a9b9c8543fbadad4d4eb16bb07108f89eac018ea0/image10.jpg")
        imgR.add("https://i4.au.reastatic.net/640x480/dbf66aecc569e475d92de9d2e0bad5e218ae89829532fb506dd58ede2e4ab90c/image11.jpg")
        imgR.add("https://i4.au.reastatic.net/640x480/79b22ab381bd465a12ec793f97c9d9b145cf6c544dab8990bc8f7fa54e9314be/floorplan1.jpg")


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
            iv.scaleType = ImageView.ScaleType.FIT_CENTER
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
            Const.HOUSE -> return R.drawable.house
            Const.VILLA -> return R.drawable.villa
            Const.APARTMENT -> return R.drawable.apartment
            Const.STORE -> return R.drawable.store
            Const.STTORAGE -> return R.drawable.storage
            Const.LAND -> return R.drawable.land
            Const.LAND -> return R.drawable.field
            else -> return R.drawable.house
        }
    }
}
