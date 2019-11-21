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
import com.dicoding.dicodiploma.cataloguemoviesub2.R;
import com.dicoding.dicodiploma.cataloguemoviesub2.model.TvShows;

import java.util.ArrayList;

public class TvShowsViewAdapter extends RecyclerView.Adapter<TvShowsViewAdapter.ListViewHolder> {
    private final ArrayList<TvShows> listShows;

    public TvShowsViewAdapter(ArrayList<TvShows> listShows){
        this.listShows = listShows;
    }

    private TvShowsViewAdapter.OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(TvShowsViewAdapter.OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tvshows, parent, false);
        return new TvShowsViewAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        TvShows tvShows = listShows.get(position);

        holder.tvShowName.setText(tvShows.getTittle());
        holder.tvShowScore.setText(tvShows.getScore());
        holder.tvShowRelase.setText(tvShows.getRelase());
        holder.tvShowDescription.setText(tvShows.getDescription());

        Glide.with(holder.itemView.getContext())
                .load(tvShows.getPoster())
                .apply(new RequestOptions().override(100,150))
                .into(holder.imgPosterShows);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listShows.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listShows.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPosterShows;
        private TextView tvShowName, tvShowScore, tvShowRelase, tvShowDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imgPosterShows = itemView.findViewById(R.id.img_tvshows);
            this.tvShowName = itemView.findViewById(R.id.tv_tittle_tvshows);
            this.tvShowScore = itemView.findViewById(R.id.tv_score_tvshows);
            this.tvShowRelase = itemView.findViewById(R.id.tv_relase_tvshows);
            this.tvShowDescription = itemView.findViewById(R.id.tv_description_tvshows);
        }
    }

    public interface OnItemClickCallBack{
        void onItemClicked(TvShows data);
    }
}
