package com.studio.yami.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import static com.studio.yami.moviecatalogue.DaftarFilm.EXTRA_FILM;

public class DetailFilm extends AppCompatActivity {

    private ImageView poster;
    private TextView date, budget, runtime, genre, title, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_film);

        poster = findViewById(R.id.iv_poster_detail);
        date = findViewById(R.id.tv_date_detail);
        budget = findViewById(R.id.tv_budget);
        runtime = findViewById(R.id.tv_runtime);
        genre =  findViewById(R.id.tv_genre);
        title = findViewById(R.id.tv_title_detail);
        overview = findViewById(R.id.tv_overview);

        onBind();

    }

    private void onBind(){
        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        if(film != null){
            poster.setImageResource(film.getPoster());
            date.setText(film.getDate());
            budget.setText(film.getBudget());
            runtime.setText(film.getRuntime());
            genre.setText(film.getGenre());
            title.setText(film.getTitle());
            overview.setText(film.getOverview());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
