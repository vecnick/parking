package com.example.parking.mvvm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.parking.R;
import com.example.parking.databinding.MapFragmentBinding;
import com.example.parking.mvvm.viewModels.MapViewModel;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends Fragment {
    private MapViewModel mapViewModel;
    private MapFragmentBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.map_fragment, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapViewModel = new ViewModelProvider(this).get(MapViewModel.class);
        mapViewModel.getMap(mapFragment);
        return view;
    }

}