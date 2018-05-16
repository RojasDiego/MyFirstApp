package com.dfr.myfirstapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dfr.myfirstapp.model.GameTask;
import com.dfr.myfirstapp.response.GameResponse;

public class SelectGame extends AppCompatActivity implements GameTask.onGameListener{

    ViewPager viewPager;
    gameAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);
        viewPager = findViewById(R.id.pagerGame);
        selectGame();
    }

    public void selectGame(){
        GameTask gameTask = new GameTask();
        gameTask.setOngameListener(this);
        String url = getResources().getString(R.string.gameLink);
        gameTask.execute(url);
    }

    @Override
    public void insertData(GameResponse gameResponse) {

        String[] fotos = new String[gameResponse.getGame().size()];
        String[] titulo = new String[gameResponse.getGame().size()];

        int i = 0;
        for (Game f: gameResponse.getGame()
             ) {
            System.out.println(f.getImg());
            fotos[i] = f.getImg();
            titulo[i] = f.getName();
            i++;
        }

        viewPagerAdapter = new gameAdapter(SelectGame.this,fotos,titulo);

        viewPager.setAdapter(viewPagerAdapter);
    }
}
