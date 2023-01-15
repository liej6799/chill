package com.liej6799.chillmobile.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.liej6799.chillmobile.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import needle.Needle;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements MainAdapter.MainItemClickListener {

    private MainAdapter mainAdapter;

    OkHttpClient client = new OkHttpClient();

    @BindView(R.id.rv_main_nlp)
    RecyclerView rv_main_nlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        List<String> samplelist = new ArrayList<>();
        samplelist.add("ad");
        samplelist.add("12");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_main_nlp.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter(this, samplelist);
        rv_main_nlp.setAdapter(mainAdapter);
        mainAdapter.setClickListener(this);
        Needle.onBackgroundThread().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    post();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // e.g. change one of the views
            }
        });
    }

    void post() throws IOException {
        RequestBody formBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("input", "The answer to the universe is [MASK].")
                .build();
        Request request = new Request.Builder()
                .url("https://api-inference.huggingface.co/models/bert-base-uncased")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}