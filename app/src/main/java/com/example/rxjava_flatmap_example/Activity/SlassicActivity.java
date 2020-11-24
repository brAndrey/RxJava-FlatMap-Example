package com.example.rxjava_flatmap_example.Activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjava_flatmap_example.BuildConfig;
import com.example.rxjava_flatmap_example.R;
import com.example.rxjava_flatmap_example.constants.Constants;
import com.example.rxjava_flatmap_example.models.Post;
import com.example.rxjava_flatmap_example.requests.RequestApi;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SlassicActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Post> posts;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        posts= new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter();

        recyclerView.setAdapter(adapter);



        HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();



        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        //подключаем интерфейс

        RequestApi requestApi = retrofit.create(RequestApi.class);

        Call<List<Post>> messeges = requestApi.getData();

        messeges.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    Log.i("onResponse", "  " + response.body().size());
                } else {
                    Log.i("onResponse code", "  " + response.code());
                }
                posts.addAll(response.body());

                recyclerView.getAdapter().notifyDataSetChanged();
                adapter.setPosts(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.i("onFailure", "  " );
            }
        });

    }



}
