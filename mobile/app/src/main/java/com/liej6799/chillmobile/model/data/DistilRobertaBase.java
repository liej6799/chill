package com.liej6799.chillmobile.model.data;

import com.google.gson.annotations.SerializedName;

public class DistilRobertaBase {

    @SerializedName("score")
    private double score;

    @SerializedName("token")
    private int token;


    public double getScore() {
        return score;
    }

    public int getToken() {
        return token;
    }

}
