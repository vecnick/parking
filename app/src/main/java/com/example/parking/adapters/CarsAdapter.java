package com.example.parking.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parking.adapters.viewHolders.CarsViewHolder;
import com.example.parking.databinding.ProfileFragmentBinding;
import com.example.parking.mvvm.views.fragments.ProfileFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarsAdapter extends RecyclerView.Adapter<CarsViewHolder> {


    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfileFragmentBinding binding = ProfileFragmentBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new CarsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
