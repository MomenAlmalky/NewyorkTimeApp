package com.example.almal.newyorktimes.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.almal.newyorktimes.R;
import com.example.almal.newyorktimes.data.local.Stories_Local;
import com.example.almal.newyorktimes.data.model.Multimedium;
import com.example.almal.newyorktimes.data.model.Result;
import com.example.almal.newyorktimes.data.remote.Service;
import com.example.almal.newyorktimes.util.GlobalEntities;
import com.example.almal.newyorktimes.util.RecyclerViewAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewyorkTimesStories extends AppCompatActivity {

    public static Context context;

    List<Result> results;
    List<Result> resultFromSection;

    RecyclerView rv;

    Service service;
    Realm realm = null;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newyork_times_stories);
        context = getApplicationContext();
        rv = (RecyclerView) findViewById(R.id.recycler_view_result);

        sharedpreferences = getSharedPreferences(GlobalEntities.MyPREFERENCES, Context.MODE_PRIVATE);


        try { // I could use try-with-resources here
            realm.init(context);
            realm = Realm.getDefaultInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String restoredText = sharedpreferences.getString("cache", null);
        if (restoredText != null && restoredText.equals("yes")) {
            loadFromCache("home");
        } else {
            connect("world");
            connect("home");
            connect("national");
            connect("politics");
            connect("nyregion");
            connect("business");
            connect("opinion");
            connect("technology");
            connect("science");

        }

        editor = sharedpreferences.edit();
        editor.putString("cache", "yes");
        editor.commit();

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);


    }

    public List<Result> connect(final String section) {

        service = Service.Creator.getService();
        Call<com.example.almal.newyorktimes.data.model.Response> call = service.top_stories(section, GlobalEntities.API_KEY);

        call.enqueue(new Callback<com.example.almal.newyorktimes.data.model.Response>() {
            @Override
            public void onResponse(Call<com.example.almal.newyorktimes.data.model.Response> call, Response<com.example.almal.newyorktimes.data.model.Response> response) {
                try {

                    results = response.body().getResults();
                }
                catch (Exception e){
                    Log.i("error_time",section);
                    e.printStackTrace();
                }

                savetoCache(results, section);
            }

            @Override
            public void onFailure(Call<com.example.almal.newyorktimes.data.model.Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return results;

    }

    public void loadFromCache(String section) {
        RealmResults<Stories_Local> realmResults = realm.where(Stories_Local.class).equalTo("section", section).findAll();

        Log.i(GlobalEntities.NEWYORK_TIMES_STORIES_ACTIVITY, "hello" + realmResults.toString());

        List<Result> resultList = new ArrayList<>();

        for (Stories_Local s : realmResults) {
            Result cacheResult = new Result();
            Multimedium m = new Multimedium();
            List<Multimedium> multimediumList = new ArrayList<>();
            cacheResult.setTitle(s.getTitle());
            cacheResult.setPublishedDate(s.getPublishData());
            m.setUrl(s.getImage());
            multimediumList.add(m);

            cacheResult.setMultimedia(multimediumList);
            resultList.add(cacheResult);

        }

        RecyclerViewAdapter RA = new RecyclerViewAdapter(resultList);
        rv.setAdapter(RA);
    }

    public void savetoCache(List<Result> results, String section) {
        if(!results.isEmpty()) {
            for (Result r : results) {
                // Create an object
                realm.beginTransaction();
                Stories_Local stories_local = realm.createObject(Stories_Local.class);

                // Set its fields
                stories_local.setTitle(r.getTitle());
                stories_local.setSection(section);
                stories_local.setPublishData(r.getPublishedDate());


                if (r.getMultimedia().size() != 0) {
                    stories_local.setImage(r.getMultimedia().get(0).getUrl());
                }

                realm.commitTransaction();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.world:
                loadFromCache("world");
                return true;
            case R.id.home1:
                loadFromCache("home");
                return true;
            case R.id.national:
                loadFromCache("national");
                return true;
            case R.id.politics:
                loadFromCache("politics");
                return true;
            case R.id.nyregion:
                loadFromCache("nyregion");
                return true;
            case R.id.business:
                loadFromCache("business");
            case R.id.opinion:
                loadFromCache("opinion");
                return true;
            case R.id.technology:
                loadFromCache("technology");
            case R.id.science:
                loadFromCache("science");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
