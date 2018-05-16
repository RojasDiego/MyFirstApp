package com.dfr.myfirstapp;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


public class RanquingPage extends AppCompatActivity {

    private Integer positionOfGame;
    private TextView tvGameName;
    private TextView tvDescription;
    private ImageView ivGamePic;
    private SwipeRefreshLayout srlRanking;
    private RecyclerView rvRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranquing_page);
        tvGameName =  findViewById(R.id.tvNameGame);
        tvDescription = findViewById(R.id.tvDescription);
        ivGamePic = findViewById(R.id.ivGamePic);
        srlRanking = findViewById(R.id.srlRanking);
        rvRanking = findViewById(R.id.rvRanking);
        positionOfGame = getIntent().getIntExtra("POSITION_PHOTO",0);
        updateRanking();
//        srlRanking.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//           @Override
//            public void onRefresh() {
//               updateRanking();
//            }
//        });

    }

    /*
    TODO
     */
    public void updateRanking(){}
}

