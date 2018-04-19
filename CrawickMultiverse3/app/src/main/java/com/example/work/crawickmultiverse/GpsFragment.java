package com.example.work.crawickmultiverse;


import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.geofire.GeoQuery;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class GpsFragment extends Fragment implements OnMapReadyCallback, OnMyLocationButtonClickListener, OnMyLocationClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private boolean mPermissionDenied = false;

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

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

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
        final LatLng carPark = new LatLng(55.37984, -3.93291);


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


       final Circle circle = mMap.addCircle(new CircleOptions().center(carPark).radius(50).strokeColor(Color.BLUE).fillColor(0x220000FF).strokeWidth(5.0f));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(crawickMulti));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(crawickMulti, zoomLevel));


        final Location location = mMap.getMyLocation();
        mMap.setOnMyLocationButtonClickListener(new OnMyLocationButtonClickListener() {

            public boolean onMyLocationButtonClick() {
                float [] distance = new float[2];

                double lat = mMap.getCameraPosition().target.latitude;
                double lng = mMap.getCameraPosition().target.longitude;
                Toast.makeText(getActivity(), "You are standing at " + lat + " " + lng,
                        Toast.LENGTH_LONG).show();

                Location.distanceBetween(lat, lng, circle.getCenter().latitude, circle.getCenter().longitude, distance);
                if ( distance[0] <= circle.getRadius())
                {
                    Toast.makeText(getActivity(), "You are Standing at the car park", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(), "You are Standing out of the car park", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });


        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

            @Override
            public void onMyLocationChange(Location location) {
                float [] distance = new float[2];

                double lat = mMap.getCameraPosition().target.latitude;
                double lng = mMap.getCameraPosition().target.longitude;
                //Toast.makeText(getActivity(), "You are standing at " + lat + " " + lng,
                //        Toast.LENGTH_LONG).show();

                Location.distanceBetween(location.getLatitude(), location.getLongitude(), circle.getCenter().latitude, circle.getCenter().longitude, distance);
                if ( distance[0] <= circle.getRadius())
                {
                    Toast.makeText(getActivity(), "You are Standing at the car park", Toast.LENGTH_LONG).show();
                }
               // else
                //{
                  //  Toast.makeText(getActivity(), "You are Standing out of the car park", Toast.LENGTH_LONG).show();
                //}

            }
        });

    }


    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }


    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
}
