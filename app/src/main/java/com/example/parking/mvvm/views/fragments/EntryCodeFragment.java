package com.example.parking.mvvm.views.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.parking.R;
import com.example.parking.databinding.EntryCodeFragmentBinding;
import com.example.parking.mvvm.viewModels.UserViewModel;


public class EntryCodeFragment extends Fragment {
        private UserViewModel mViewModel;
        private EntryCodeFragmentBinding binding;
        public static EntryCodeFragment newInstance() {
            return new EntryCodeFragment();
        }
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {

            binding = EntryCodeFragmentBinding.inflate(inflater, container, false);
            View view = binding.getRoot();
            return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
            binding.number.setText(mViewModel.getTelephone().getValue());
            binding.button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse("geo:60,30.5"));
//                    startActivity(intent);
                    getParentFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment())
                            .addToBackStack(null)
                            .commit();
                }
            });
        };
    }


