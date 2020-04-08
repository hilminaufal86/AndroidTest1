package com.example.app_test1;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GuestAdapter extends BaseAdapter {

    private final ArrayList<Guest> guest;
    private final Context context;

    public GuestAdapter(Context context, ArrayList<Guest> guests) {
        this.guest = guests;
        this.context = context;
    }

    @Override
    public int getCount() {
        return guest.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Guest g = guest.get(position);

        //if (convertView==null) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.guest_layout,null);


        ImageView avatar = convertView.findViewById(R.id.avatar);
        TextView name = convertView.findViewById(R.id.guest_name);
        //TextView email = convertView.findViewById(R.id.guest_email);

        name.setText(g.getFirstName()+" "+g.getLastName());
        //avatar.setImageResource(R.drawable.event4);
        CircularProgressDrawable circular = new CircularProgressDrawable(context);
        circular.start();
        Picasso.get()
                .load(g.getAvatar())
                .resize(400,400)
                .placeholder(circular)
                .into(avatar);

        return convertView;
    }
}
