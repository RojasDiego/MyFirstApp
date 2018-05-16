package com.dfr.myfirstapp.response;

import com.dfr.myfirstapp.Game;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by NACHZEHER on 13/02/2018.
 */

public class GameResponse {
    @SerializedName("data")
    private List<Game> game;

    public List<Game> getGame() {
        return game;
    }

    @Override
    public String toString() {
        return "GameResponse{" +
                "gameLista=" + game +
                '}';
    }
}

