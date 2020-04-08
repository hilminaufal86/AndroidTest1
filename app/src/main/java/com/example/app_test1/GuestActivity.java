package com.example.app_test1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;

public class GuestActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Guest>> {

    String username;
    int eventID;
    String eventName;
    ArrayList<Guest> guest;
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_four);


        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");
        eventID = intent.getIntExtra("EVENT ID",-1);
        eventName = intent.getStringExtra("EVENT NAME");

        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
    }


    @NonNull
    @Override
    public Loader<ArrayList<Guest>> onCreateLoader(int id, @Nullable Bundle args) {
        return new GuestLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Guest>> loader, ArrayList<Guest> data) {
        guest = data;
        Log.d(guest.get(0).getFirstName(), "first name");
        GuestAdapter guestAdapter = new GuestAdapter(this,guest);
        gridView = findViewById(R.id.gridview);
        gridView.setAdapter(guestAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intents = new Intent(GuestActivity.this, MainActivity.class);
                Integer Id = guest.get(position).getAttributeID();
                String Name = guest.get(position).getFirstName()+' '+guest.get(position).getLastName();

                intents.putExtra("USERNAME",username);
                intents.putExtra("GUEST ID",Id);
                intents.putExtra("GUEST NAME",Name);
                intents.putExtra("EVENT ID",eventID);
                intents.putExtra("EVENT NAME",eventName);
                startActivity(intents);
            }
        });
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Guest>> loader) {

    }
}
