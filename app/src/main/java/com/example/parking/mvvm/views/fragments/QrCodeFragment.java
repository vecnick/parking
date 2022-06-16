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
import com.example.parking.databinding.EntryFragmentBinding;
import com.example.parking.databinding.QrCodeFragmentBinding;
import com.example.parking.mvvm.viewModels.UserViewModel;

public class QrCodeFragment extends Fragment {
    private UserViewModel mViewModel;
    private QrCodeFragmentBinding binding;
    public static QrCodeFragment newInstance() {
        return new QrCodeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = QrCodeFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

    }

}