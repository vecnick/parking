package com.example.parking.mvvm.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.parking.databinding.EntryFragmentBinding;
import com.example.parking.databinding.HomeFragmentBinding;
import com.example.parking.databinding.MultiFragmentBinding;
import com.example.parking.mvvm.models.Codes;
import com.example.parking.mvvm.viewModels.UserViewModel;

public class MultiFragment extends Fragment {

    private UserViewModel mViewModel;
    private MultiFragmentBinding binding;
    public static MultiFragment newInstance() {
        return new MultiFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = MultiFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        binding.qrImage.setImageBitmap(mViewModel.getQr());
        binding.barImage.setImageBitmap(mViewModel.getBar());
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        binding.qrImage.setImageBitmap(mViewModel.getQr());
    }
}