package com.liej6799.chillmobile.ui.task;

import static com.liej6799.chillmobile.model.URL.BASE_URL;
import static com.liej6799.chillmobile.model.URL.DISTILROBERTA_BASE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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


    @BindView(R.id.cl_mask_text_task)
    ConstraintLayout cl_mask_text_task;

    @BindView(R.id.et_input_header_text_task)
    EditText et_input_header_text_task;

    @BindView(R.id.tv_output_text_task)
    TextView tv_output_text_task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_task);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String message = intent.getStringExtra("awd");

        getSupportActionBar().setTitle(message);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cl_mask_text_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_input_header_text_task.append("<mask>");
            }
        });

        et_input_header_text_task.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() != 0)
                    tv_output_text_task.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }




    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}