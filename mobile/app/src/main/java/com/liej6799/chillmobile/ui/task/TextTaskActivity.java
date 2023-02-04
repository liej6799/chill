package com.liej6799.chillmobile.ui.task;

import static com.liej6799.chillmobile.model.URL.BASE_URL;
import static com.liej6799.chillmobile.model.URL.DISTILROBERTA_BASE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.liej6799.chillmobile.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import needle.Needle;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TextTaskActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_task);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String message = intent.getStringExtra("awd");

        getSupportActionBar().setTitle(message);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }




    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}