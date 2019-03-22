package com.example.retrofitexample.data.model.remote;

import com.example.retrofitexample.data.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/posts")
    @FormUrlEncoded
    Call<Post> saveData(@Field("title") String title,@Field("body") String body,@Field("userId") Integer userId);
}
