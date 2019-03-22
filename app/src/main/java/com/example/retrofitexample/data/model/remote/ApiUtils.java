package com.example.retrofitexample.data.model.remote;

import retrofit2.Retrofit;

public class ApiUtils {
    public ApiUtils() {
    }

    public static final String BASE_URL="http://jsonplaceholder.typicode.com/";
    public static APIService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
