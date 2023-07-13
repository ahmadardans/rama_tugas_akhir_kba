package com.example.rama_tugas_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rama_tugas_akhir_kba.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}