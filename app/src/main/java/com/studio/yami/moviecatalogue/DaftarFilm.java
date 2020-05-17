package com.studio.yami.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DaftarFilm extends AppCompatActivity {

    public static final String EXTRA_FILM = "com.studio.yami.moviecatalogue.EXTRA_FILM";

    private ListView lvDaftar;
    private TypedArray poster;
    private String[] title, date, runtime, budget, genre, overview;
    private int[] score;
    private DaftarAdapter adapter;
    private List<Film> filmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_film);

        lvDaftar = findViewById(R.id.lv_daftar_film);
        setValue();
        adapter = new DaftarAdapter(this, filmList);
        lvDaftar.setAdapter(adapter);

        lvDaftar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Film film = filmList.get(i);
                Intent intent = new Intent(getApplicationContext(), DetailFilm.class);
                intent.putExtra(EXTRA_FILM, film);
                startActivity(intent);
            }
        });
    }

    private void setValue(){
        poster = getResources().obtainTypedArray(R.array.poster);
        title = getResources().getStringArray(R.array.title);
        date = getResources().getStringArray(R.array.date);
        score = getResources().getIntArray(R.array.score);
        runtime = getResources().getStringArray(R.array.runtime);
        budget = getResources().getStringArray(R.array.budget);
        genre = getResources().getStringArray(R.array.genre);
        overview = getResources().getStringArray(R.array.overview);
        addDaftar();
    }

    private void addDaftar(){
        filmList = new ArrayList<>();
        for (int i=0; i<title.length; i++){
            Film d = new Film(
                    poster.getResourceId(i, -1),
                    title[i],
                    date[i],
                    score[i],
                    runtime[i],
                    budget[i],
                    genre[i],
                    overview[i]
            );
            filmList.add(d);
        }
    }

}
