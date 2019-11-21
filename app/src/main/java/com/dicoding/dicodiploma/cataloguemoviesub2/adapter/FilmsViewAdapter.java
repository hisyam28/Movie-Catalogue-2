package com.dicoding.dicodiploma.cataloguemoviesub2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.dicodiploma.cataloguemoviesub2.model.Films;
import com.dicoding.dicodiploma.cataloguemoviesub2.R;

import java.util.ArrayList;

public class FilmsViewAdapter extends RecyclerView.Adapter<FilmsViewAdapter.ListViewHolder> {
    private final ArrayList<Films> listFilms;

    public FilmsViewAdapter(ArrayList<Films> listFilms) {
        this.listFilms = listFilms;
    }

    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_films, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Films films = listFilms.get(position);

        holder.tvFilmName.setText(films.getTittle());
        holder.tvFilmScore.setText(films.getScore());
        holder.tvFilmRelase.setText(films.getRelase());
        holder.tvFilmDescription.setText(films.getDescription());

        Glide.with(holder.itemView.getContext())
                .load(films.getPoster())
                .apply(new RequestOptions().override(100, 150))
                .into(holder.imgPosterFilm);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listFilms.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilms.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPosterFilm;
        private TextView tvFilmName, tvFilmScore, tvFilmRelase, tvFilmDescription;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imgPosterFilm = itemView.findViewById(R.id.img_films);
            this.tvFilmName = itemView.findViewById(R.id.tv_tittle_films);
            this.tvFilmScore = itemView.findViewById(R.id.tv_score_films);
            this.tvFilmRelase = itemView.findViewById(R.id.tv_relase_films);
            this.tvFilmDescription = itemView.findViewById(R.id.tv_description_films);
        }
    }

    public interface OnItemClickCallBack{
        void onItemClicked(Films data);
    }
}
