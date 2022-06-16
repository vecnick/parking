package com.example.parking.mvvm.models;

import android.graphics.Bitmap;

public class Codes {
    private Bitmap qrCode;
    private Bitmap BarCode;

    public Bitmap getQrCode() {
        return qrCode;
    }

    public void setQrCode(Bitmap qrCode) {
        this.qrCode = qrCode;
    }

    public Bitmap getBarCode() {
        return BarCode;
    }

    public void setBarCode(Bitmap barCode) {
        this.BarCode = barCode;
    }
}
