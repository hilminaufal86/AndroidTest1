package com.example.app_test1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    String UserName;
    TextView UserField;
    Button NextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_one);

        NextButton = findViewById(R.id.nextButton);
        UserField = findViewById(R.id.nameField);

        UserField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                UserName = s.toString();
            }
        });
    }

    public void onClickBtn(View v) {
        if (UserName!=null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("USERNAME",UserName);
            startActivity(intent);
        }
    }
}
