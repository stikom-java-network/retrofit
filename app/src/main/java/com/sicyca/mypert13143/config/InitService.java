package com.sicyca.mypert13143.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitService {
    private static String URL = "http://192.168.171.34/film/";

    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APIFilm getInstance(){
        return setInit().create(APIFilm.class);
    }

    public static String getUrl(){
        return URL;
    }
}
