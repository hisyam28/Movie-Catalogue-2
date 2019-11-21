package com.dicoding.dicodiploma.cataloguemoviesub2.detail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.dicodiploma.cataloguemoviesub2.R;
import com.dicoding.dicodiploma.cataloguemoviesub2.model.Films;

public class FilmsDetailActivity extends AppCompatActivity {
    public static final String EXTRA_DETAIL = "extra_detail";

    private ImageView imgDetailFilms;
    private TextView tvTitleFilms, tvScoreFilms, tvStatusFilms, tvRelaseFilms, tvRuntimeFilms, tvLengueageFilms, tvGenreFilms, tvDescriptionFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films_detail);

        ActionBar actionBar = getSupportActionBar();

        tvTitleFilms = findViewById(R.id.tv_tittle_film);
        tvScoreFilms = findViewById(R.id.tv_score_film);
        tvStatusFilms = findViewById(R.id.tv_status_film);
        tvRelaseFilms = findViewById(R.id.tv_relase_film);
        tvRuntimeFilms = findViewById(R.id.tv_runtime_film);
        tvLengueageFilms = findViewById(R.id.tv_lenguage_film);
        tvGenreFilms = findViewById(R.id.tv_genre_film);
        tvDescriptionFilms = findViewById(R.id.tv_description_film);
        imgDetailFilms = findViewById(R.id.img_film);

        final Films mFilms = getIntent().getParcelableExtra(EXTRA_DETAIL);

        String tittle = "";
        String score = "";
        String status = "";
        String relase = "";
        String runtime = "";
        String lengueage = "";
        String genre = "";
        String description = "";

        if (mFilms != null){
            tittle = mFilms.getTittle();
            score = mFilms.getScore();
            status = mFilms.getStatus();
            relase = mFilms.getRelase();
            runtime = mFilms.getRuntime();
            lengueage = mFilms.getLanguage();
            genre = mFilms.getGenre();
            description = mFilms.getDescription();
        }

        tvTitleFilms.setText(tittle);
        tvScoreFilms.setText(score);
        tvStatusFilms.setText(status);
        tvRelaseFilms.setText(relase);
        tvRuntimeFilms.setText(runtime);
        tvLengueageFilms.setText(lengueage);
        tvGenreFilms.setText(genre);
        tvDescriptionFilms.setText(description);

        if (mFilms != null){
            Glide.with(getApplicationContext())
                    .load(mFilms.getPoster())
                    .apply(new RequestOptions().override(200, 300))
                    .into(imgDetailFilms);
        }

        if (actionBar != null){
            actionBar.setTitle(tittle);
        }

    }
}
