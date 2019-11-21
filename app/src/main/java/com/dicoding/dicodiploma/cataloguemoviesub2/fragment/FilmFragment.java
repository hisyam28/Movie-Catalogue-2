package com.dicoding.dicodiploma.cataloguemoviesub2.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dicoding.dicodiploma.cataloguemoviesub2.R;
import com.dicoding.dicodiploma.cataloguemoviesub2.adapter.FilmsViewAdapter;
import com.dicoding.dicodiploma.cataloguemoviesub2.detail.FilmsDetailActivity;
import com.dicoding.dicodiploma.cataloguemoviesub2.model.Films;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private ArrayList<Films> films;
    private String[] dataTittle;
    private String[] dataScore;
    private String[] dataStatus;
    private String[] dataRelase;
    private String[] dataLengueage;
    private String[] dataRuntime;
    private String[] dataGenre;
    private String[] dataDescription;
    private TypedArray dataPoster;


    public FilmFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_film, container, false);
        recyclerView = view.findViewById(R.id.rv_films);
        // Inflate the layout for this fragment

        filmRecyclerList();
        return view;
    }

    private void filmRecyclerList() {
        FilmsViewAdapter filmsViewAdapter = new FilmsViewAdapter(films);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(filmsViewAdapter);

        filmsViewAdapter.setOnItemClickCallBack(new FilmsViewAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Films data) {
                filmsSelectedItem(data);
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
        dataTittle = getResources().getStringArray(R.array.data_tittle_films);
        dataScore = getResources().getStringArray(R.array.data_score_films);
        dataStatus = getResources().getStringArray(R.array.data_status_films);
        dataRelase = getResources().getStringArray(R.array.data_relase_films);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_films);
        dataLengueage = getResources().getStringArray(R.array.data_lenguage_films);
        dataGenre = getResources().getStringArray(R.array.data_genre_films);
        dataDescription = getResources().getStringArray(R.array.data_overview_films);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_films);
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataTittle.length; i++){
            Films film = new Films();
            film.setTittle(dataTittle[i]);
            film.setScore(dataScore[i]);
            film.setStatus(dataStatus[i]);
            film.setRelase(dataRelase[i]);
            film.setRuntime(dataRuntime[i]);
            film.setLanguage(dataLengueage[i]);
            film.setGenre(dataGenre[i]);
            film.setDescription(dataDescription[i]);
            film.setPoster(dataPoster.getResourceId(i, -1));
            films.add(film);
        }
    }

    private void filmsSelectedItem(Films films){
        Toast.makeText(getActivity(), "you choice " + films.getTittle(), Toast.LENGTH_SHORT).show();

        Films hFilm = new Films();
        hFilm.setTittle(films.getTittle());
        hFilm.setScore(films.getScore());
        hFilm.setStatus(films.getStatus());
        hFilm.setRelase(films.getRelase());
        hFilm.setRuntime(films.getRuntime());
        hFilm.setLanguage(films.getLanguage());
        hFilm.setGenre(films.getGenre());
        hFilm.setDescription(films.getDescription());
        hFilm.setPoster(films.getPoster());

        Intent intentDetailFilms = new Intent(view.getContext(), FilmsDetailActivity.class);
        intentDetailFilms.putExtra(FilmsDetailActivity.EXTRA_DETAIL, hFilm);
        startActivity(intentDetailFilms);
    }

}
