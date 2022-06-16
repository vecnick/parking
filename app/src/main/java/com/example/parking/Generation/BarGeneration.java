package com.example.parking.Generation;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class BarGeneration {
    public Bitmap Generate(String telephone) {
        try {
           return  barcode(telephone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    private Bitmap barcode(String telephone) throws WriterException {
        BitMatrix bitMatrix = multiFormatWriter.encode(telephone,
                BarcodeFormat.CODE_128, 400, 170, null);
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        return barcodeEncoder.createBitmap(bitMatrix);

    }
}
