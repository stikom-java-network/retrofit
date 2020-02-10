package com.sicyca.mypert13143.config;

import com.sicyca.mypert13143.model.Crud;
import com.sicyca.mypert13143.model.GetFilm;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIFilm {
    @GET("functions/get.php")
    Call<GetFilm> getFilm();

    @FormUrlEncoded
    @POST("functions/insert.php")
    Call<Crud> postFilm(@Field("judul") String judul,
                        @Field("genre") String genre,
                        @Field("tahun") String tahun,
                        @Field("durasi") int durasi,
                        @Field("images") String images);

    @FormUrlEncoded
    @POST("functions/update.php")
    Call<Crud> putFilm(@Field("id") int id,
                       @Field("judul") String judul,
                       @Field("genre") String genre,
                       @Field("tahun") String tahun,
                       @Field("durasi") int durasi);

    @FormUrlEncoded
    @POST("functions/delete.php")
    Call<Crud> delFilm(@Field("id") int id);
}
