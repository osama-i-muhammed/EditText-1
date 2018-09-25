package com.duhok_tech.aqarat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Switch
import android.widget.Toast
import com.duhok_tech.aqarat.data.House
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.Marker
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.activity_min_map.*


class MinMapActivity : AppCompatActivity() {

    var arHouse:ArrayList<House> = ArrayList<House>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_min_map)

        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.874129, 42.981419))
        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.874421, 42.987438))
        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.868696, 42.991772))
        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.868953, 42.993686))
        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.864176, 42.987600))
        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.861830, 42.966947))
        arHouse.add(House(1,2,"Grebase, Ashty",3,180000.0,2,2,1,1,230.0,36.852181, 42.985830))
        var mMap = Mapbox.getInstance(this, getString(R.string.mapbox_access_token))

        val iconFactory = IconFactory.getInstance(this)
        var icon = iconFactory.fromResource(R.drawable.mmmm)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->

            for (h in arHouse){
                mapboxMap.addMarker(MarkerOptions()
                        .position(LatLng(h.House_lat!!, h.House_lng!!))
                        .title(h.House_ID.toString())
                        .icon(iconFactory.fromResource(cheakMapPhoto(h.type!!)))
                )
            }




            mapboxMap.setOnMarkerClickListener(object : MapboxMap.OnMarkerClickListener {
                override fun onMarkerClick(marker: Marker): Boolean {
                    val s = arHouse.get(marker.title.toInt())
                    val sented:ArrayList<House> = ArrayList<House>()
                    sented.add(House(s.House_ID,s.House_RentSale,s.House_Adress,s.House_Room,s.House_Price,s.House_bathroom,s.House_Livingroom,s.House_Swedish_Room,s.House_Garage,s.House_Area,s.House_lat,s.House_lng))
                    startActivity(Intent(this@MinMapActivity, MainPopUp::class.java).putExtra("tit",sented ))
                    Toast.makeText(this@MinMapActivity, marker.position.latitude.toString(), Toast.LENGTH_LONG).show()
                    return true
                }
            })
        })

        btToMainMenu.setOnClickListener { startActivity(Intent(this, MainMenu::class.java)) }
        btOpenFilterMenu.setOnClickListener { startActivity(Intent(this, Filter_Menu::class.java)) }

    }

    fun cheakMapPhoto(type:String) :Int{

        when (type){
            "house" -> return R.drawable.house_map
            "villa" -> return R.drawable.villa_map
            "apartment" -> return R.drawable.apartment_map
            "store" -> return R.drawable.shop_map
            "Storage" -> return R.drawable.warehouse_map
            "land" -> return R.drawable.land_map
            "Farm" -> return R.drawable.field_map
           else -> return R.drawable.land_map
        }

    }

    public override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    public override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    public override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }


}
