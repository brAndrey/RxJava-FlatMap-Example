package com.example.rxjava_flatmap_example.requests;

import com.example.rxjava_flatmap_example.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

//    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
//    Constants.API_BASE_URI
    //https://jsonplaceholder.typicode.com/posts/

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URI)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static RequestApi requestApi = retrofit.create(RequestApi.class);

    public static RequestApi getRequestApi(){
        return requestApi;
    }
}
