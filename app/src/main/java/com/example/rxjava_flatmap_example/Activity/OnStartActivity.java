package com.example.rxjava_flatmap_example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjava_flatmap_example.R;

public class OnStartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


    }

    public void startClassic(View view) {
        try {
            Intent intent = new Intent(this, SlassicActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void startObserverable(View view) {
        try {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
