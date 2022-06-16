package com.example.parking.Generation;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Objects;

public class QrGeneration {
    public Bitmap Generate(String telephone) {
        try {
            return qrcode(telephone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    public Bitmap qrcode(String telephone) throws WriterException {
        BitMatrix bitMatrix = multiFormatWriter.encode(telephone,
                BarcodeFormat.QR_CODE, 350, 300);
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        return barcodeEncoder.createBitmap(bitMatrix);

    }
}
