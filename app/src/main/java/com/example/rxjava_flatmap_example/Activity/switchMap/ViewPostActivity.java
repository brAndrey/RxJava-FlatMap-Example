package com.example.rxjava_flatmap_example.Activity.switchMap;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjava_flatmap_example.R;
import com.example.rxjava_flatmap_example.constants.Constants;
import com.example.rxjava_flatmap_example.models.Post;

public class ViewPostActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private TextView textId;
    private TextView textUserId;
    private TextView textTitle;
    private TextView textBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_post);
        textId = findViewById(R.id.textId);
        textUserId = findViewById(R.id.textUserId);
        textTitle = findViewById(R.id.textTitle);
        textBody = findViewById(R.id.textBody);

        Log.d(TAG,"onCreate");
        getIncomingIntent();
        
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra(Constants.POST)){
            try {
                Post post = getIntent().getParcelableExtra(Constants.POST);
                textId.setText(String.valueOf(post.getId()));
                textUserId.setText(String.valueOf(post.getUserId()));
                textTitle.setText(post.getTitle());
                textBody.setText(post.getBody());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
