package com.example.work.crawickmultiverse;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class GpsFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    public GpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gps, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        super.onViewCreated(view, savedInstanceState);
    }

    public void onMapReady (GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Add a marker in Sydney and move the camera

        LatLng crawickMulti = new LatLng(55.3816164, -3.9329154);
        LatLng omphalosTop = new LatLng(55.38481, -3.93317);
        LatLng omphalosBottom = new LatLng(55.3839, -3.93294);
        LatLng void5 = new LatLng(55.3847, -3.93292);
        LatLng supercluster11 = new LatLng(55.38396, -3.93408);
        LatLng milkyway13 = new LatLng(55.38346, -3.93433);
        LatLng andromeda14 = new LatLng(55.38338, -3.93451);
        LatLng multiverse12 = new LatLng(55.38459, -3.93407);
        LatLng northsouthAve2 = new LatLng(55.38232, -3.93286);
        LatLng northsouthAve3 = new LatLng(55.38153, -3.93271);
        LatLng mosaicInAmp = new LatLng(55.38231, -3.93282);
        LatLng amp78 = new LatLng(55.38235, -3.93277);
        LatLng cosmicCollision = new LatLng(55.38209, -3.93233);
        LatLng rockPoint = new LatLng(55.38159, -3.93032);
        LatLng carPark = new LatLng(55.37984, -3.93291);


        mMap.addMarker(new MarkerOptions().position(crawickMulti).title("Crawick Multiverse"));
        mMap.addMarker(new MarkerOptions().position(omphalosTop).title("Omphalos Top"));
        mMap.addMarker(new MarkerOptions().position(omphalosBottom).title("Omphalos Bottom"));
        mMap.addMarker(new MarkerOptions().position(void5).title("Void 5"));
        mMap.addMarker(new MarkerOptions().position(supercluster11).title("Supercluster 11"));
        mMap.addMarker(new MarkerOptions().position(milkyway13).title("Milkyway 13"));
        mMap.addMarker(new MarkerOptions().position(andromeda14).title("Andromeda 14"));
        mMap.addMarker(new MarkerOptions().position(multiverse12).title("Multiverse 12"));
        mMap.addMarker(new MarkerOptions().position(northsouthAve2).title("North South Avenue Point 2"));
        mMap.addMarker(new MarkerOptions().position(northsouthAve3).title("North South Avenue Point 3"));
        mMap.addMarker(new MarkerOptions().position(mosaicInAmp).title("Mosaic in Ampitheatre 7/8"));
        mMap.addMarker(new MarkerOptions().position(amp78).title("Ampitheatre 7/8"));
        mMap.addMarker(new MarkerOptions().position(cosmicCollision).title("Cosmic Collisions 6"));
        mMap.addMarker(new MarkerOptions().position(rockPoint).title("4 Rock Point"));
        mMap.addMarker(new MarkerOptions().position(carPark).title("Car Park"));


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(crawickMulti));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(crawickMulti, zoomLevel));
    }

}
