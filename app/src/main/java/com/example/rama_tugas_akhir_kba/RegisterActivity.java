package com.example.rama_tugas_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.rama_tugas_akhir_kba.api.ApiConfig;
import com.example.rama_tugas_akhir_kba.api.models.Register.ResponseRegister;
import com.example.rama_tugas_akhir_kba.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsernameRegister.getText().toString().trim();
                String email = binding.etEmailRegister.getText().toString().trim();
                String password = binding.etPasswordRegister.getText().toString().trim();

                if (TextUtils.isEmpty(username)){
                    binding.etUsernameRegister.setError("username harus di isi!");
                } else if (TextUtils.isEmpty(email)) {
                    binding.etEmailRegister.setError("Email harus di isi!");
                } else if (TextUtils.isEmpty(password)) {
                    binding.etPasswordRegister.setError("password harus di isi!");
                } else {
                    register(username,email,password);
                }

            }
        });
    }

    private void register(String username, String email, String password) {
        ApiConfig.service.requestRegister(username, email, password).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()){
                    ResponseRegister responseRegister = response.body();

                    if (responseRegister.isSukses()){
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();

                        Intent registerSuccess = new Intent(RegisterActivity.this,RegisterSuccessActivity.class);
                        startActivity(registerSuccess);
                        finishAffinity();
                    }  else {
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Harap Periksa jaringan anda!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}