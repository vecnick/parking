package com.example.parking.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parking.adapters.viewHolders.CarsViewHolder;
import com.example.parking.adapters.viewHolders.TravelViewHolder;
import com.example.parking.databinding.ProfileFragmentBinding;

public class TravelAdapter extends RecyclerView.Adapter<TravelViewHolder>{

    @NonNull
    @Override
    public TravelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfileFragmentBinding binding = ProfileFragmentBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new TravelViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
