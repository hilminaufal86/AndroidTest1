package com.example.app_test1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class GuestLoader extends AsyncTaskLoader<ArrayList<Guest>> {


    public GuestLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public ArrayList<Guest> loadInBackground() {
        return NetworkUtils.getGuest();
    }
}
