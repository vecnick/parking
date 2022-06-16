package com.example.parking.mvvm.views.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parking.databinding.MainFragmentBinding;
import com.example.parking.mvvm.viewModels.UserViewModel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainFragment extends Fragment {
    private UserViewModel mViewModel;
    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = MainFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  binding.editCode.setText("Success");
                try {
                    qrcode();
                    barcode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                getParentFragmentManager().beginTransaction().replace(R.id.container, new MapFragment())
//                        .addToBackStack(null)
//                        .commit();
            }
        });
    };

    private void getCode() {
        try {
            qrcode();
            barcode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

    public void qrcode() throws WriterException {
        BitMatrix bitMatrix = multiFormatWriter.encode(binding.editCode.getText().toString(),
                BarcodeFormat.QR_CODE, 350, 300);
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
        binding.qrCode.setImageBitmap(bitmap);
    }

    private void barcode() throws WriterException {
        BitMatrix bitMatrix = multiFormatWriter.encode(binding.editCode.getText().toString(),
                BarcodeFormat.CODE_128, 400, 170, null);
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
        binding.barCode.setImageBitmap(bitmap);
    }
}