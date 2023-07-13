package com.example.rama_tugas_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rama_tugas_akhir_kba.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cvMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listminuman = new Intent(MainActivity.this,ListMinumanActivity.class);
                startActivity(listminuman);
            }
        });
    }
}