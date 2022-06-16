package com.example.parking.mvvm.views.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parking.R;
import com.example.parking.databinding.EntryFragmentBinding;
import com.example.parking.databinding.HomeFragmentBinding;
import com.example.parking.mvvm.viewModels.UserViewModel;

public class HomeFragment extends Fragment {

    private UserViewModel mViewModel;
    private HomeFragmentBinding binding;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        getParentFragmentManager().beginTransaction().replace(R.id.smallContainer, new MultiFragment())
                .addToBackStack(null)
                .commit();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonToGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.container, new MapFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        binding.buttonToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.container, new ProfileFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

}