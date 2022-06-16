package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.parking.DI.ServiceLocator;
import com.example.parking.mvvm.views.fragments.EntryFragment;
import com.example.parking.mvvm.views.fragments.MapFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ServiceLocator.init(this.getApplicationContext());
    }

}