package com.example.parking.mvvm.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.parking.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapViewModel extends ViewModel {

    public void getMap(SupportMapFragment mapFragment) {

        MarkerOptions markerOptions = new MarkerOptions();
        MarkerOptions markerOptions1 = new MarkerOptions();
        LatLng ParkingOne = new LatLng(55.757240, 37.659067);
        LatLng ParkingTwo = new LatLng(55.670299, 37.479859);
        LatLng Moscow = new LatLng(55.75115095448885, 37.6243933990855);
        markerOptions.position(ParkingOne).title("Атриум").snippet("Свободных мест: 10");
        markerOptions1.position(ParkingTwo).title("Мирэа").snippet("Свободных мест: 0");

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.addMarker(markerOptions);
                googleMap.addMarker(markerOptions1);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Moscow,12));
            }
        });
    }
}