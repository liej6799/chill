package com.liej6799.chillmobile.api;

import com.liej6799.chillmobile.model.data.DistilRobertaBase;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HuggingfaceService {

    @GET("models/distilroberta-base")
    Observable<DistilRobertaBase> getDistrilRoberta();
}
