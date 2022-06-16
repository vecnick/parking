package com.example.parking.mvvm.viewModels;

import android.app.Application;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parking.DI.ServiceLocator;
import com.example.parking.Generation.BarGeneration;
import com.example.parking.Generation.QrGeneration;
import com.example.parking.Repositories.UserRepository;
import com.example.parking.mvvm.models.Codes;
import com.example.parking.mvvm.models.User;
import com.example.parking.mvvm.models.travelInfo;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

private MutableLiveData<String> telephone = new MutableLiveData<>();
private UserRepository userRepository;
    private Codes codes = new Codes();

    public UserViewModel(@NonNull Application application){
        super(application);
        userRepository = ServiceLocator.getInstance().getUserRepository();
    }
    public MutableLiveData<String> getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        getTelephone().setValue(telephone);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public Bitmap getQr(){
        return new QrGeneration().Generate(telephone.getValue());
    }
    public Bitmap getBar(){
        return new BarGeneration().Generate(telephone.getValue());
    }
    public MutableLiveData<List<travelInfo>> getTravels(){
        return new MutableLiveData<>(userRepository.getTravels());
    }
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}