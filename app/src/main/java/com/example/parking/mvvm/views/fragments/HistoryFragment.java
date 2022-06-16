package com.example.parking.mvvm.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parking.R;
import com.example.parking.adapters.TravelAdapter;
import com.example.parking.adapters.TravelListener;
import com.example.parking.databinding.EntryFragmentBinding;
import com.example.parking.databinding.HistoryFragmentBinding;
import com.example.parking.mvvm.models.travelInfo;
import com.example.parking.mvvm.viewModels.UserViewModel;


public class HistoryFragment extends Fragment {

    private UserViewModel mViewModel;
    private HistoryFragmentBinding binding;
    private TravelAdapter travelAdapter;
    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = HistoryFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.historyRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
//        mViewModel.getTravels().observe(getViewLifecycleOwner(), result->{
//            travelAdapter = new TravelAdapter(this,result,new TravelListener() {
//                @Override
//                public void onClick(travelInfo travelInfo) {
//
//                }
//            })
//        });
//        binding.historyRecycle.setAdapter(TravelAdapter);
    }
}