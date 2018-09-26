package com.duhok_tech.aqarat

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.duhok_tech.aqarat.Tools.Const
import com.duhok_tech.aqarat.data.Apartment
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

    var arHouse = ArrayList<House>()
    var arApart = ArrayList<Apartment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_min_map)

        arHouse.add(House(0, 1, "Grebase, Ashty", 8, 190000.0, 2, 2, 1, 0, 230.0, 36.874129, 42.981419))
        arHouse.add(House(1, 2, "Grebase, Ashty", 6, 180000.0, 2, 2, 1, 1, 230.0, 36.874421, 42.987438))
        arHouse.add(House(2, 1, "Grebase, Ashty", 7, 110000.0, 2, 2, 1, 9, 230.0, 36.868696, 42.991772))
        arHouse.add(House(3, 2, "Grebase, Ashty", 5, 276000.0, 2, 2, 1, 0, 230.0, 36.868953, 42.993686))
        arHouse.add(House(4, 1, "Grebase, Ashty", 4, 325000.0, 2, 2, 1, 5, 230.0, 36.864176, 42.987600))
        arHouse.add(House(5, 2, "Grebase, Ashty", 3, 254000.0, 2, 2, 1, 0, 230.0, 36.861830, 42.966947))
        arHouse.add(House(6, 1, "Grebase, Ashty", 3, 99000.0, 2, 2, 1, 3, 230.0, 36.852181, 42.985830))
        arApart.add(Apartment(0, 2, "AvroCity b5 5", 2, 105000.0, 2, 2, 1, 230.0, 36.868104, 42.980557))
        arApart.add(Apartment(1, 1, "AvroCity b5 5", 3, 105000.0, 2, 2, 1, 230.0, 36.857014, 42.907024))
        arApart.add(Apartment(2, 2, "AvroCity b5 5", 5, 105000.0, 2, 2, 1, 230.0, 36.861057, 42.909167))
        arApart.add(Apartment(3, 1, "AvroCity b5 5", 21, 105000.0, 2, 2, 1, 230.0, 36.866410, 42.978087))
        arApart.add(Apartment(4, 3, "AvroCity b5 5", 7, 105000.0, 2, 2, 1, 230.0, 36.858191, 42.996098))

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))




        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            val iconFactory = IconFactory.getInstance(this)

            //add House marker to map
            for (h in arHouse) {
                mapboxMap.addMarker(MarkerOptions()
                        .position(LatLng(h.lat!!, h.lng!!))
                        .title(h.ID.toString() + "|" + h.type)
                        .icon(iconFactory.fromResource(cheakMapPhoto(h.type!!)))
                )
            }
            //add Apartments marker to map
            for (h in arApart) {
                mapboxMap.addMarker(MarkerOptions()
                        .position(LatLng(h.lat!!, h.lng!!))
                        .title(h.ID.toString() + "|" + h.type)
                        .icon(iconFactory.fromResource(cheakMapPhoto(h.type!!)))
                )
            }

            //disable mapBox compass
            mapboxMap.uiSettings.isCompassEnabled = false


            //On Marker click listener
            mapboxMap.setOnMarkerClickListener(object : MapboxMap.OnMarkerClickListener {
                override fun onMarkerClick(marker: Marker): Boolean {
                    var s: String = marker.title
                    var ss = s.split("|")
                    //ss[0] -> id  : ss[1] -> type

                    var intent = Intent(this@MinMapActivity, MainPopUp::class.java)


                    when (ss[1]) {
                        Const.HOUSE -> {
                            val mBuild = arHouse[ss[0].toInt()]
                            intent.putExtra(Const.ID,ss[0])
                            intent.putExtra(Const.TYPE,ss[1])
                            intent.putExtra(Const.PRICE, mBuild.Price)
                            intent.putExtra(Const.ROOM, mBuild.Room)
                            intent.putExtra(Const.RENT_SALE, mBuild.RentSale)
                            intent.putExtra(Const.ADRESS, mBuild.Address)
                            intent.putExtra(Const.BATHROOM, mBuild.bathroom)
                            intent.putExtra(Const.LINIVGROOM, mBuild.Livingroom)
                            intent.putExtra(Const.SWIDSHROOM, mBuild.Swedish_Room)
                            intent.putExtra(Const.GARAGE, mBuild.Garage)
                            intent.putExtra(Const.AREA, mBuild.Area)
                        }
                        Const.APARTMENT -> {
                            val mBuild = arApart[ss[0].toInt()]
                            intent.putExtra(Const.ID,ss[0])
                            intent.putExtra(Const.TYPE,ss[1])
                            intent.putExtra(Const.PRICE, mBuild.Price)
                            intent.putExtra(Const.ROOM, mBuild.Room)
                            intent.putExtra(Const.RENT_SALE, mBuild.RentSale)
                            intent.putExtra(Const.ADRESS, mBuild.Address)
                            intent.putExtra(Const.BATHROOM, mBuild.bathroom)
                            intent.putExtra(Const.LINIVGROOM, mBuild.Livingroom)
                            intent.putExtra(Const.SWIDSHROOM, mBuild.Swedish_Room)
                            intent.putExtra(Const.AREA, mBuild.Area)
                        }
                    }

                    startActivity(intent)
//                    Toast.makeText(this@MinMapActivity, arHouse.get(marker.title.toInt()).House_Price.toString(), Toast.LENGTH_LONG).show()
                    return true
                }
            })
        })

        btToMainMenu.setOnClickListener { startActivity(Intent(this, MainMenu::class.java)) }
        btOpenFilterMenu.setOnClickListener { startActivity(Intent(this, Filter_Menu::class.java)) }

    }

    fun cheakMapPhoto(type: String): Int {
        when (type) {
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
