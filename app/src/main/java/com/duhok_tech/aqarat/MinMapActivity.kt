package com.duhok_tech.aqarat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.activity_min_map.*
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.maps.MapboxMap
import android.support.annotation.NonNull
import com.mapbox.mapboxsdk.annotations.Marker


class MinMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_min_map)

        var mMap =  Mapbox.getInstance(this, getString(R.string.mapbox_access_token))

        val iconFactory = IconFactory.getInstance(this)
        val icon = iconFactory.fromResource(R.drawable.mmmm)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(OnMapReadyCallback {
            mapboxMap ->

            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(36.874129, 42.981419))
                    .title("Eiffel vvvvvvv")
                    .icon(icon)
            )
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(36.874421, 42.987438))
                    .title("Eiffel Tower")
                    .icon(icon)
            )
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(36.868696, 42.991772))
                    .title("Eiffel Tower")
                    .icon(icon)
            )
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(36.868953, 42.993686))
                    .title("Eiffel Tower")
                    .icon(icon)
            )
            mapboxMap.addMarker(MarkerOptions()
                    .position(LatLng(36.864176, 42.987600))
                    .title("Eiffel Tower")
                    .icon(icon)


            )
            mapboxMap.setOnMarkerClickListener(object : MapboxMap.OnMarkerClickListener {
                override fun onMarkerClick(marker: Marker): Boolean {
                    startActivity(Intent(this@MinMapActivity,MainPopUp::class.java).putExtra("tit",marker.title.toString()))
                    Toast.makeText(this@MinMapActivity, marker.position.latitude.toString(), Toast.LENGTH_LONG).show()
                    return true
                }
            })
        })

        btToMainMenu.setOnClickListener { startActivity(Intent(this,MainMenu::class.java)) }
        btOpenFilterMenu.setOnClickListener { startActivity(Intent(this,Filter_Menu::class.java)) }

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
