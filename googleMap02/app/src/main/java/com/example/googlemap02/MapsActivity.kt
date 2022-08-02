package com.example.googlemap02



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

internal class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//
//        mMap = googleMap
//
//        val SEOUL = LatLng(37.56, 126.97)
//
//        val markerOptions = MarkerOptions()
//        markerOptions.position(SEOUL)
//        markerOptions.title("서울")
//        markerOptions.snippet("한국의 수도")
//        mMap.addMarker(markerOptions)
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL,15f ))
//
//    }
override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val SEOUL = LatLng(37.56, 126.97)

        val markerOptions = MarkerOptions()
        markerOptions.position(SEOUL)
        markerOptions.title("서울")
        markerOptions.snippet("한국의 수도")
        mMap.addMarker(markerOptions)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL,15f ))


    // Add polylines to the map.
    // Polylines are useful to show a route or some other connection between points.
    val polyline1 = googleMap.addPolyline(
        PolylineOptions()
            .clickable(true)
            .add(
                LatLng(37.56, 126.97),
                LatLng(37.747, 126.592),
                LatLng(37.864, 126.891),
                LatLng(37.901, 126.217),
                LatLng(37.906, 126.248),
                LatLng(37.891, 126.309)
            )
    )

    // Position the map's camera near Alice Springs in the center of Australia,
    // and set the zoom factor so most of Australia shows on the screen.
    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(37.56, 126.97), 10f))

    // Set listeners for click events.
    googleMap.setOnPolylineClickListener(this)
    googleMap.setOnPolygonClickListener(this)
    }

        private fun GoogleMap.setOnPolygonClickListener(mapsActivity: MapsActivity) {

        }

        private fun GoogleMap.setOnPolylineClickListener(mapsActivity: MapsActivity) {

        }


    }

