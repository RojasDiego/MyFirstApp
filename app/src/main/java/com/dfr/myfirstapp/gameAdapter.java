package com.dfr.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by NACHZEHER on 13/02/2018.
 */

public class gameAdapter extends PagerAdapter {

    Activity  activity;
    String[] imagenes, texto;
    LayoutInflater inflater;

    public gameAdapter(Activity activity, String[] imagenes, String[] texto) {
        this.activity = activity;
        this.imagenes = imagenes;
        this.texto = texto;
    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.itemgame,container,false);

        ImageView imageView;
        imageView = view.findViewById(R.id.gamePic);

        TextView textView;
        textView = view.findViewById(R.id.gameName);
        textView.setText(texto[position]);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        imageView.setMinimumHeight(height);
        imageView.setMinimumWidth(width);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RanquingPage.class);
                intent.putExtra("POSITION_PHOTO",position+1);
                activity.startActivity(intent);
           }
        });

        Picasso.with(activity.getApplicationContext()).load(imagenes[position]).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);
        container.addView(view);
        return  view;
    }
}
