package com.dfr.myfirstapp.model;

import android.os.AsyncTask;
import android.util.Log;

import com.dfr.myfirstapp.response.GameResponse;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by NACHZEHER on 13/02/2018.
 */

public class GameTask extends AsyncTask<String, Void, GameResponse>{
    HttpURLConnection urlConnection;
    @Override
    protected GameResponse doInBackground(String... strings) {
        StringBuilder json = new StringBuilder();
        GameResponse gameResponse;
        try{
            URL url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = reader.readLine()) != null) json.append(line);

            Log.d("STR",json.toString());
            Gson gson = new Gson();
            gameResponse = gson.fromJson(json.toString(),GameResponse.class);
        } catch (Exception e){
            return null;
        } finally {
            urlConnection.disconnect();
        }

        return gameResponse;
    }

    public interface onGameListener{
        void  insertData(GameResponse gameResponse);
    }



    @Override
    protected void onPostExecute(GameResponse gameResponse) {

        if (gameListener != null) gameListener.insertData(gameResponse);

    }

    private onGameListener gameListener;

    public void setOngameListener(onGameListener ongameListener){
        this.gameListener=ongameListener;
    }
}
