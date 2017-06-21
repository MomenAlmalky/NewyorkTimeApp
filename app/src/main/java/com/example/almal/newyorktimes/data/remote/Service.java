package com.example.almal.newyorktimes.data.remote;

import com.example.almal.newyorktimes.data.model.Response;
import com.example.almal.newyorktimes.data.model.Result;
import com.example.almal.newyorktimes.util.GlobalEntities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by almal on 2017-06-20.
 */

public interface Service {
    @GET("{section}.json?")
    Call<Response> top_stories(
            @Path("section") String section,
            @Query("api-key") String key);

    class Creator{
        public static Retrofit retrofit;

        public static Service getService(){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();


            retrofit = new Retrofit.Builder()
                    .baseUrl(GlobalEntities.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            return retrofit.create(Service.class);
        }
    }
}
