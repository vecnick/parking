package com.example.parking.Repositories;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.lifecycle.MutableLiveData;

import com.example.parking.DI.ServiceLocator;
import com.example.parking.Generation.BarGeneration;
import com.example.parking.Generation.QrGeneration;
import com.example.parking.mvvm.models.Codes;
import com.example.parking.mvvm.models.User;
import com.example.parking.mvvm.models.travelInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {

    private ServiceLocator mServiceLocator;
    private Context context;
    private static MutableLiveData<User> mUser = new MutableLiveData<>();
    private static MutableLiveData<String> mTelephone = new MutableLiveData<>();
    private List<travelInfo> travels = new ArrayList<>();
    private Codes codes = new Codes();

    public MutableLiveData<Codes> getmCodes() {
        return mCodes;
    }
    public List<travelInfo>getTravels(){
        return travels;
    }
    public UserRepository(){
        travelInfo travelInfo = new travelInfo();
        travelInfo.setPlace("Mirea");
        travelInfo.setTime("25.05.22");
        travels.add(travelInfo);
        travelInfo.setPlace("Atrium");
        travelInfo.setTime("10.05.22");
        travels.add(travelInfo);
    }
    public void setmCodes(MutableLiveData<Codes> mCodes) {
        this.mCodes = mCodes;
    }

    private MutableLiveData<Codes> mCodes = new MutableLiveData<>();
    public UserRepository(Context context) {
        this.context = context;
    }

    public MutableLiveData<User> getUser() {
        return mUser;
    }

    public void setTelephone(String telephone) {
        mTelephone.setValue(telephone);
        Codes codes = new Codes();
        User user = new User();
        user.setTelephon(telephone);
        mUser.setValue(user);
        User user2 = new User();
        user2 = mUser.getValue();
        codes.setBarCode(new BarGeneration().Generate(user2.getTelephon()));
        codes.setQrCode(new QrGeneration().Generate(user2.getTelephon()));
        this.codes = codes;
        mCodes.setValue(codes);

    }

    public static String getTelephone(){
        if(mUser.getValue()!=null){
            return mUser.getValue().getTelephon();
        }
  return "nothing";
    }
    public Bitmap getQr(){

            return new QrGeneration().Generate(mTelephone.getValue());

    }
}
