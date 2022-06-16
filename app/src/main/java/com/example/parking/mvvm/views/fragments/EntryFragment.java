package com.example.parking.mvvm.views.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.parking.R;
import com.example.parking.databinding.EntryFragmentBinding;
import com.example.parking.mvvm.viewModels.UserViewModel;

public class EntryFragment extends Fragment {
    private UserViewModel mViewModel;
    private EntryFragmentBinding binding;
    public static EntryFragment newInstance() {
        return new EntryFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = EntryFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        mViewModel.setTelephone("89169395065");
        //mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        //binding.entry.setEnabled(false);

//        mViewModel.getEmail().observe(getViewLifecycleOwner(), email -> {
//            binding.NumberEdit.setError(null);
//            if (!email.isEmpty()) {
//                binding.entry.setEnabled(true);
//            } else {
//                binding.entry.setEnabled(false);
//            }
//        });

        binding.entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.container, new EntryCodeFragment())
                        .addToBackStack(null)
                        .commit();
//                mViewModel.checkEmail(mViewModel.getEmail().getValue()).observe(getViewLifecycleOwner(), result -> {
//                    String message = result.getContentIfNotHandled();
//                    if (message != null) {
//                        if (message.equals("ok")) {
//                            getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, new Registration3Fragment())
//                                    .addToBackStack(null)
//                                    .commit();
//                        } else if (message.equals("exists")) {
//                            getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, new Registration4Fragment())
//                                    .addToBackStack(null)
//                                    .commit();
//                        } else {
//                            binding.emailLayout.setError(message);
//                        }
//                    }
//
//
//                });
            }
        });
        binding.NumberEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mViewModel.setTelephone(editable.toString());
            }
        });
    };
}
