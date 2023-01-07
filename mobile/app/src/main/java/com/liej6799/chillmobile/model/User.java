package com.liej6799.chillmobile.model;

public class User {

    private String idToken;

    private String refreshToken;

    private String accessToken;


    public User(String accessToken, String idToken) {
        this.accessToken = accessToken;
        this.idToken = idToken;
    }

    public User() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}