package com.dfr.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.dfr.myfirstapp.game.GameMainActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        final Button jugar = (Button) findViewById(R.id.Jugar);
        final Button ranquing = (Button) findViewById(R.id.ranquing);
        final ImageButton conf = (ImageButton) findViewById(R.id.settings);
        final ImageButton about = (ImageButton) findViewById(R.id.aboutUs);


        jugar.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent inten = new Intent(MainPage.this, GameMainActivity.class);
                startActivity(inten);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten2 = new Intent(MainPage.this, SettingsPage.class);
                startActivity(inten2);
            }
        });

        ranquing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten3 = new Intent(MainPage.this, SelectGame.class);
                startActivity(inten3);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten5 = new Intent(MainPage.this, AboutUsPage.class);
                startActivity(inten5);
            }
        });


    }

}
