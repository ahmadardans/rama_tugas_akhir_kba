package com.example.rama_tugas_akhir_kba.api;

import com.example.rama_tugas_akhir_kba.api.models.DataMinuman.ResponseDataMinuman;
import com.example.rama_tugas_akhir_kba.api.models.Login.ResponseLogin;
import com.example.rama_tugas_akhir_kba.api.models.Register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("getDataMinuman")
    Call<ResponseDataMinuman> getDataMinuman();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin(@Field("email") String email,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegister(@Field("username") String userName,
                                           @Field("email") String email,
                                           @Field("password") String password);

}
