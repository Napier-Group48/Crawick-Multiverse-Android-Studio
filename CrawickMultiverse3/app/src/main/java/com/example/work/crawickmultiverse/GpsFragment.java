package com.example.work.crawickmultiverse;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.Manifest;


import com.google.android.gms.common.api.GoogleApiClient;
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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class GpsFragment extends Fragment implements OnMapReadyCallback, OnMyLocationButtonClickListener, OnMyLocationClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private Context mContext;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    MediaPlayer mp;
    private boolean mPermissionDenied = false;

    public GpsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public void initChannels(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("default",
                "Channel name",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Channel description");
        notificationManager.createNotificationChannel(channel);
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getContext())
                        .setTitle(R.string.title_activity_maps)
                        .setMessage(R.string.title_activity_maps)
                        .setPositiveButton(R.string.common_signin_button_text, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        //Request location updates:
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

        }
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gps, container, false);
        checkLocationPermission();
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
        LatLng cometSeats = new LatLng(55.383608, -3.931852);
        final LatLng carPark = new LatLng(55.37984, -3.93291);


       // mMap.addMarker(new MarkerOptions().position(crawickMulti).title("Crawick Multiverse"));
        mMap.addMarker(new MarkerOptions().position(omphalosTop).title("The Void"));
        mMap.addMarker(new MarkerOptions().position(omphalosBottom).title("Omphalos"));
        mMap.addMarker(new MarkerOptions().position(void5).title("Belvedere"));
        mMap.addMarker(new MarkerOptions().position(supercluster11).title("Supercluster"));
        mMap.addMarker(new MarkerOptions().position(milkyway13).title("Milkyway"));
        mMap.addMarker(new MarkerOptions().position(andromeda14).title("Andromeda"));
        mMap.addMarker(new MarkerOptions().position(multiverse12).title("Multiverse"));
        //mMap.addMarker(new MarkerOptions().position(northsouthAve2).title("North South Avenue Point 2"));
        mMap.addMarker(new MarkerOptions().position(northsouthAve3).title("North South Avenue Point"));
        mMap.addMarker(new MarkerOptions().position(mosaicInAmp).title("Mosaic (in Ampitheatre)"));
        mMap.addMarker(new MarkerOptions().position(amp78).title("Ampitheatre"));
        mMap.addMarker(new MarkerOptions().position(cosmicCollision).title("Cosmic Collisions"));
        mMap.addMarker(new MarkerOptions().position(rockPoint).title("Access to Cosmic Collision"));
        mMap.addMarker(new MarkerOptions().position(cometSeats).title("Comet seats"));
        mMap.addMarker(new MarkerOptions().position(carPark).title("Car Park"));



       final Circle circle = mMap.addCircle(new CircleOptions().center(carPark).radius(25).strokeColor(Color.BLUE).fillColor(0x220000FF).strokeWidth(5.0f));


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(crawickMulti));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(crawickMulti, zoomLevel));

        final Location location = mMap.getMyLocation();

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String MTitle = marker.getTitle();
                //Toast.makeText(getActivity(), MTitle,Toast.LENGTH_LONG).show();
                if (mp.isPlaying()){
                    mp.stop();
                }
                if (MTitle.equals("Car Park")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location1);
                    //mp.stop();

                    mp.start();

                }

                else if (MTitle.equals("Access to Cosmic Collision")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location2);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Comet seats")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location3);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Belvedere")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location4);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("The Void")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location5);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Cosmic Collisions")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location6);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Ampitheatre")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location7);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Mosaic (in Ampitheatre)")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location8);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("North South Avenue Point")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location9);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Omphalos")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location10);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Supercluster")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location11);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Multiverse")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location12);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Milkyway")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location13);
                    //mp.stop();

                    mp.start();

                }
                else if (MTitle.equals("Andromeda")) {
                    if (mp.isPlaying()){
                        mp.stop();
                    }
                    mp = MediaPlayer.create(getActivity(),R.raw.location14);
                    //mp.stop();

                    mp.start();

                }
                else {

                }


                return false;
            }
        });
        mMap.setOnMyLocationButtonClickListener(new OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {

                float [] distance = new float[2];


                //mp = MediaPlayer.create(getActivity(), R.raw.plucky);
               //mp.start();
                double lat = mMap.getCameraPosition().target.latitude;
                double lng = mMap.getCameraPosition().target.longitude;
                Toast.makeText(getActivity(), "You are standing at " + lat + " " + lng,
                        Toast.LENGTH_LONG).show();

//                Location.distanceBetween(lat, lng, circle.getCenter().latitude, circle.getCenter().longitude, distance);
//                if ( distance[0] <= circle.getRadius())
//                {
//                    Toast.makeText(getActivity(), "You are Standing at the car park", Toast.LENGTH_LONG).show();
//
//                }
//                else {
//                    Toast.makeText(getActivity(), "You are Standing out of the car park", Toast.LENGTH_LONG).show();
//                }
//
//

                return false;
            }
        });


        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

            @Override
            public void onMyLocationChange(Location location) {
                float [] distance = new float[2];


                //MediaPlayer mp;
                mp = MediaPlayer.create(getActivity(), R.raw.plucky);
                double lat = mMap.getCameraPosition().target.latitude;
                double lng = mMap.getCameraPosition().target.longitude;
                //Toast.makeText(getActivity(), "You are standing at " + lat + " " + lng,
                //        Toast.LENGTH_LONG).show();

                Location.distanceBetween(location.getLatitude(), location.getLongitude(), circle.getCenter().latitude, circle.getCenter().longitude, distance);
                if ( distance[0] <= circle.getRadius())
                {
                    Toast.makeText(getActivity(), "You are Standing at the car park", Toast.LENGTH_LONG).show();
                    mp.start();
                    int notificationId = 1;
                   // NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(mContext, "default")
                    //        .setSmallIcon(R.drawable.ic_gps_fixed_black_24dp)
                    //        .setContentTitle("Crawick Multiverse")
                     //       .setContentText("You are standing at Napier University")
                     //       .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    //NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
                    //notificationManager.notify(notificationId, notificationBuilder.build());
                }
               // else
                //{
                  //  Toast.makeText(getActivity(), "You are Standing out of the car park", Toast.LENGTH_LONG).show();
                //}

                else
                {
                    Toast.makeText(getActivity(), "You are out of the Car Park", Toast.LENGTH_LONG).show();
                    //mp.start();
                    int notificationId = 1;
                 //   NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(mContext, "default")
                 //           .setSmallIcon(R.drawable.ic_gps_fixed_black_24dp)
                 //           .setContentTitle("Crawick Multiverse")
                 //           .setContentText("You are standing outside Napier University")
                 //           .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                 //   NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
                 //   notificationManager.notify(notificationId, notificationBuilder.build());
                }


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
