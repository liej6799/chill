package com.liej6799.chillmobile.ui.main;

import static com.liej6799.chillmobile.util.TaskList.TASK_LIST;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.liej6799.chillmobile.R;
import com.liej6799.chillmobile.model.TaskType;
import com.liej6799.chillmobile.ui.task.TextTaskActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private MainAdapter mainNLPAdapter;
    private MainAdapter mainAudioAdapter;

    OkHttpClient client = new OkHttpClient();

    @BindView(R.id.rv_main_nlp)
    RecyclerView rv_main_nlp;

    @BindView(R.id.rv_main_audio)
    RecyclerView rv_main_audio;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rv_main_nlp.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mainNLPAdapter =  new MainAdapter(this, TASK_LIST.stream().filter(x -> x.getTaskTypes() == TaskType.NATURAL_LANGUAGE_PROCESSING).collect(Collectors.toList()));
        rv_main_nlp.setAdapter(mainNLPAdapter);
        mainNLPAdapter.setClickListener(this);

        rv_main_audio.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mainAudioAdapter = new MainAdapter(this, TASK_LIST.stream().filter(x -> x.getTaskTypes() == TaskType.AUDIO).collect(Collectors.toList()));
        rv_main_audio.setAdapter(mainAudioAdapter);
        mainAudioAdapter.setClickListener(this);

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
                .url("https://api-inference.huggingface.co/models/distilroberta-base")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, TextTaskActivity.class);
        intent.putExtra("awd", mainNLPAdapter.getString(position));
        startActivity(intent);
    }
}