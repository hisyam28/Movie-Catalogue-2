package com.dicoding.dicodiploma.cataloguemoviesub2.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dicoding.dicodiploma.cataloguemoviesub2.R;
import com.dicoding.dicodiploma.cataloguemoviesub2.adapter.TvShowsViewAdapter;
import com.dicoding.dicodiploma.cataloguemoviesub2.detail.TvShowsDetailActivity;
import com.dicoding.dicodiploma.cataloguemoviesub2.model.TvShows;

import java.util.ArrayList;


public class TvShowFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private ArrayList<TvShows> tvShows;
    private String[] dataTittle;
    private String[] dataScore;
    private String[] dataStatus;
    private String[] dataRelase;
    private String[] dataLengueage;
    private String[] dataGenre;
    private String[] dataDescription;
    private TypedArray dataPoster;


    public TvShowFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        recyclerView = view.findViewById(R.id.rv_tvshow);

        showRecyclerList();
        return view;
    }

    private void showRecyclerList() {
        TvShowsViewAdapter tvShowsViewAdapter = new TvShowsViewAdapter(tvShows);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tvShowsViewAdapter);

        tvShowsViewAdapter.setOnItemClickCallBack(new TvShowsViewAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(TvShows data) {
                tvShowsSelectedItem(data);

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();
    }

    private void prepare() {
        dataTittle = getResources().getStringArray(R.array.data_tittle_tvshows);
        dataScore = getResources().getStringArray(R.array.data_scores_tvshows);
        dataStatus = getResources().getStringArray(R.array.data_status_tvshows);
        dataRelase = getResources().getStringArray(R.array.data_relase_tvshows);
        dataLengueage = getResources().getStringArray(R.array.data_lengueage_tvshows);
        dataGenre = getResources().getStringArray(R.array.data_genre_tvshows);
        dataDescription = getResources().getStringArray(R.array.data_overview_tvshows);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tvshows);
    }

    private void addItem() {
        tvShows = new ArrayList<>();

        for (int i = 0; i < dataTittle.length; i++){
            TvShows show = new TvShows();
            show.setTittle(dataTittle[i]);
            show.setScore(dataScore[i]);
            show.setStatus(dataStatus[i]);
            show.setRelase(dataRelase[i]);
            show.setLanguage(dataLengueage[i]);
            show.setGenre(dataGenre[i]);
            show.setDescription(dataDescription[i]);
            show.setPoster(dataPoster.getResourceId(i, -1));
            tvShows.add(show);
        }
    }

    private void tvShowsSelectedItem(TvShows tvShows){
        Toast.makeText(getActivity(), "you choice " + tvShows.getTittle(), Toast.LENGTH_SHORT).show();

        TvShows hShow = new TvShows();
        hShow.setTittle(tvShows.getTittle());
        hShow.setScore(tvShows.getScore());
        hShow.setStatus(tvShows.getStatus());
        hShow.setRelase(tvShows.getRelase());
        hShow.setLanguage(tvShows.getLanguage());
        hShow.setGenre(tvShows.getGenre());
        hShow.setDescription(tvShows.getDescription());
        hShow.setPoster(tvShows.getPoster());

        Intent intentDetailTvShows = new Intent(view.getContext(), TvShowsDetailActivity.class);
        intentDetailTvShows.putExtra(TvShowsDetailActivity.EXTRA_DETAIL, hShow);
        startActivity(intentDetailTvShows);
    }

}


