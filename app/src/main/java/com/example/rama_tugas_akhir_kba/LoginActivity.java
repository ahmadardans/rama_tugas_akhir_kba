package com.example.rama_tugas_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.rama_tugas_akhir_kba.api.ApiConfig;
import com.example.rama_tugas_akhir_kba.api.models.Login.ResponseLogin;
import com.example.rama_tugas_akhir_kba.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register);
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.etEmailLogin.getText().toString().trim();
                String password = binding.etPasswordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                     binding.etEmailLogin.setError("Email harus di isi!!");
                } else if (TextUtils.isEmpty(password)) {
                    binding.etPasswordLogin.setError("password harus di isi!");
                } else {
                    login(email,password);
                }
            }
        });
    }

    private void login(String email, String password) {
        ApiConfig.service.requestLogin(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    ResponseLogin responseLogin = response.body();

                    if (responseLogin.isSukses()){
                        Bundle data = new Bundle();
                        data.putString("email",responseLogin.getDataLogin().getEmail());
                        data.putString("username",responseLogin.getDataLogin().getUsername());

                        Intent login = new Intent(LoginActivity.this,MainActivity.class);
                        login.putExtras(data);
                        startActivity(login);
                        finishAffinity();
                    } else {
                        Toast.makeText(LoginActivity.this, responseLogin.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Response gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Harap periksa internet anda!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}