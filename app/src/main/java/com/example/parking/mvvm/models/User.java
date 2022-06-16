package com.example.parking.mvvm.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

        @PrimaryKey
        @NonNull
        String telephon;
        String name;
        String car;

    @NonNull
    public String getTelephon() {
        return telephon;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setTelephon(@NonNull String telephon) {
        this.telephon = telephon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class ServiceLocator {
    }
}
