package com.example.app_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    private String UserName;
    private TextView NameView;

    private Integer EventID;
    private String EventName;
    private Button EventButton;

    private Integer GuestID;
    private String GuestName;
    private Button GuestButton;

    public MainActivity() {
        EventID = -1;
        EventName = "Choose Event";
        GuestID = -1;
        GuestName = "Choose Guest";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two);

        Intent intent = getIntent();
        if (intent.getStringExtra("USERNAME")!="") {
            UserName = intent.getStringExtra("USERNAME");
        }

        NameView = findViewById(R.id.nama);
        EventButton = findViewById(R.id.Event);
        GuestButton = findViewById(R.id.Guest);

        NameView.setText(UserName);
        if (GuestID==-1) {
            GuestButton.setText(GuestName);
        }
        if (EventID==-1) {
            EventButton.setText(EventName);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        Integer tempEventId = intent.getIntExtra("EVENT ID",-1);

        if (tempEventId != -1) {
            EventID = tempEventId;
            EventName = intent.getStringExtra("EVENT NAME");

            EventButton.setText(EventName);
        } else {
            EventButton.setText(EventName);
        }

        Integer tempGuestId = intent.getIntExtra("GUEST ID",-1);
        if (tempGuestId!=-1) {
            GuestID = tempGuestId;
            GuestName = intent.getStringExtra("GUEST NAME");

            GuestButton.setText(GuestName);
        } else {
            GuestButton.setText(GuestName);
        }

    }

    public void onClickEvent(View v) {
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra("USERNAME",UserName);
        intent.putExtra("GUEST ID",GuestID);
        intent.putExtra("GUEST NAME",GuestName);
        startActivity(intent);
    }

    public  void onClickGuest(View v) {
        Intent intent = new Intent(this, GuestActivity.class);
        intent.putExtra("USERNAME",UserName);
        intent.putExtra("EVENT ID",EventID);
        intent.putExtra("EVENT NAME",EventName);
        startActivity(intent);
    }
}
