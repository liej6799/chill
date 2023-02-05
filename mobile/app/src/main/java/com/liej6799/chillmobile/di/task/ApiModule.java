//package com.liej6799.chillmobile.di.task;
//
//import android.app.Application;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.liej6799.chillmobile.BuildConfig;
//import com.liej6799.chillmobile.api.HuggingfaceService;
//import com.liej6799.chillmobile.di.AppModule;
//import com.liej6799.chillmobile.model.User;
//
//import javax.inject.Singleton;
//
//import dagger.Module;
//import dagger.Provides;
//import io.reactivex.schedulers.Schedulers;
//import okhttp3.Cache;
//import okhttp3.HttpUrl;
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//@Module
//public final class ApiModule {
//    private static final int OK_HTTP_CACHE_SIZE = 10 * 1024 * 1024;
//    private static final String GSON_DATE_FORMAT = "yyyy-MM-dd";
//
//    private String baseUrl;
//    private String apiKey;
//
//    public ApiModule(String baseUrl, String apiKey) {
//        this.baseUrl = baseUrl;
//        this.apiKey = apiKey;
//    }
//
//    @Provides
//    @Singleton
//    Cache providesOkHttpCache(Application app) {
//        return new Cache(app.getCacheDir(), OK_HTTP_CACHE_SIZE);
//    }
//
//    @Provides
//    @Singleton
//    Gson providesGson() {
//        Gson gson = new GsonBuilder()
//                .setDateFormat(GSON_DATE_FORMAT)
//                .create();
//
//        return gson;
//    }
//
//    @Provides
//    @Singleton
//    Interceptor providesApiKeyInterceptor() {
//        final Interceptor apiKeyInterceptor = chain -> {
//            HttpUrl url = chain.request().url()
//                    .newBuilder()
//                    .addQueryParameter("api_key", apiKey)
//                    .build();
//            Request request = chain.request().newBuilder().url(url).build();
//            return chain.proceed(request);
//        };
//
//        return apiKeyInterceptor;
//    }
//
//    @Provides
//    @Singleton
//    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
//        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        if (BuildConfig.DEBUG) {
//            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        } else {
//            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
//        }
//        return httpLoggingInterceptor;
//    }
//
//    @Provides
//    @Singleton
//    OkHttpClient providesOkHttpClient(Cache cache, Interceptor apiKeyInterceptor,
//                                      HttpLoggingInterceptor loggingInterceptor) {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(apiKeyInterceptor)
//                .addInterceptor(loggingInterceptor)
//                .cache(cache)
//                .build();
//
//        return client;
//    }
//
//    @Provides
//    @Singleton
//    Retrofit providesRetrofit(Gson gson, OkHttpClient client) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory
//                        .createWithScheduler(Schedulers.newThread()))
//                .client(client)
//                .build();
//
//        return retrofit;
//    }
////
////    @Provides
////    @Singleton
////    HuggingfaceService providesHuggingfaceService(Retrofit retrofit) {
////        return retrofit.create(HuggingfaceService.class);
////    }
//
//}