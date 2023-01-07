package com.liej6799.chillmobile.util;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T> {

    @NonNull
    public final AuthStatus status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;


    public Resource(@NonNull AuthStatus status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> authenticated(@Nullable T data) {
        return new Resource<>(AuthStatus.AUTHENTICATED, data, null);
    }

    public static <T> Resource<T> error(@NonNull String msg, @Nullable T data) {
        return new Resource<>(AuthStatus.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(AuthStatus.LOADING, data, null);
    }

    public static <T> Resource<T> logout() {
        return new Resource<>(AuthStatus.NOT_AUTHENTICATED, null, null);
    }

    public enum AuthStatus {AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED}


    public enum ToggleView {CAMERA, MAP}

}