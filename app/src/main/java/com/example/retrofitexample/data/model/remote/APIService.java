package com.example.retrofitexample.data.model.remote;

import com.example.retrofitexample.data.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @POST("api/otp")
    @FormUrlEncoded
    Call<Post> saveData(@Field("number") String number);
}
