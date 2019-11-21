package com.dicoding.dicodiploma.cataloguemoviesub2.detail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.dicodiploma.cataloguemoviesub2.R;
import com.dicoding.dicodiploma.cataloguemoviesub2.model.TvShows;

public class TvShowsDetailActivity extends AppCompatActivity {
    public static final String EXTRA_DETAIL = "extra_detail";

    private ImageView imgPosterTvShows;
    private TextView tvTitleTvShows, tvScoreTvShows, tvStatusTvShows, tvRelaseTvShows, tvLengueageTvShows, tvGenreTvShows, tvDescriptionTvShows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows_detail);

        ActionBar actionBar = getSupportActionBar();

        tvTitleTvShows = findViewById(R.id.tv_tittle_tvshow);
        tvStatusTvShows = findViewById(R.id.tv_status_tvshow);
        tvScoreTvShows = findViewById(R.id.tv_score_tvshow);
        tvRelaseTvShows = findViewById(R.id.tv_relase_tvshow);
        tvLengueageTvShows = findViewById(R.id.tv_lenguage_tvshow);
        tvGenreTvShows = findViewById(R.id.tv_genre_tvshow);
        tvDescriptionTvShows = findViewById(R.id.tv_description_tvshow);
        imgPosterTvShows = findViewById(R.id.img_tvshow);

        final TvShows mShows = getIntent().getParcelableExtra(EXTRA_DETAIL);

        String title = "";
        String score = "";
        String status = "";
        String relase = "";
        String lengueage = "";
        String genre = "";
        String description = "";
        if (mShows != null){
            title = mShows.getTittle();
            score = mShows.getScore();
            status = mShows.getStatus();
            relase = mShows.getRelase();
            lengueage = mShows.getLanguage();
            genre = mShows.getGenre();
            description = mShows.getDescription();
        }

        tvTitleTvShows.setText(title);
        tvScoreTvShows.setText(score);
        tvStatusTvShows.setText(status);
        tvRelaseTvShows.setText(relase);
        tvLengueageTvShows.setText(lengueage);
        tvGenreTvShows.setText(genre);
        tvDescriptionTvShows.setText(description);

        if (mShows != null){
            Glide.with(getApplicationContext())
                    .load(mShows.getPoster())
                    .apply(new RequestOptions().override(200,300))
                    .into(imgPosterTvShows);
        }

        actionBar.setTitle(title);

    }
}
