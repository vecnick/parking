package com.example.parking.mvvm.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parking.R;
import com.example.parking.databinding.EntryFragmentBinding;
import com.example.parking.databinding.ProfileFragmentBinding;
import com.example.parking.mvvm.viewModels.UserViewModel;


public class ProfileFragment extends Fragment {

    private UserViewModel mViewModel;
    private ProfileFragmentBinding binding;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = ProfileFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        binding.number.setText(mViewModel.getTelephone().getValue());
    }
}