package com.example.rama_tugas_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.rama_tugas_akhir_kba.api.Adapter.MinumanAdapter;
import com.example.rama_tugas_akhir_kba.api.ApiConfig;
import com.example.rama_tugas_akhir_kba.api.models.DataMinuman.DataMinumanItem;
import com.example.rama_tugas_akhir_kba.api.models.DataMinuman.ResponseDataMinuman;
import com.example.rama_tugas_akhir_kba.databinding.ActivityListMinumanBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMinumanActivity extends AppCompatActivity {
    MinumanAdapter minumanAdapter;

    ActivityListMinumanBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMinumanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvDataminuman.setHasFixedSize(true);
        binding.rvDataminuman.setLayoutManager(new LinearLayoutManager(this));

        ApiConfig.service.getDataMinuman().enqueue(new Callback<ResponseDataMinuman>() {
            @Override
            public void onResponse(Call<ResponseDataMinuman> call, Response<ResponseDataMinuman> response) {
                if (response.isSuccessful()) {
                    if (response.body()!= null) {
                        ResponseDataMinuman responseDataMinuman = response.body();
                        List<DataMinumanItem> dataMinumanItems = responseDataMinuman.getDataMinuman();

                        Toast.makeText(ListMinumanActivity.this,responseDataMinuman.getPesan(),Toast.LENGTH_SHORT).show();

                        minumanAdapter = new MinumanAdapter(dataMinumanItems);
                        binding.rvDataminuman.setAdapter(minumanAdapter );
                    }else {
                        Toast.makeText(ListMinumanActivity.this, "Data kosong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ListMinumanActivity.this, "Response gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDataMinuman> call, Throwable t) {
                Toast.makeText(ListMinumanActivity.this, "Harap periksa jaringan aanda", Toast.LENGTH_SHORT).show();
            }
        });

    }
}