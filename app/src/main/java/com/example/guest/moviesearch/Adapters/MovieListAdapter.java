package com.example.guest.moviesearch.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.moviesearch.Models.MovieModel;
import com.example.guest.moviesearch.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    private ArrayList<MovieModel> mMovieModel = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<MovieModel> movies) {
        mContext = context;
        mMovieModel = movies;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovies(mMovieModel.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieModel.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.moviePoster) ImageView mMoviePoster;
        @Bind(R.id.movieTitle) TextView mMovieTitle;
        @Bind(R.id.movieOverview) TextView mMovieOverview;
        @Bind(R.id.movieRating) TextView mMovieRating;

        private Context mContext;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMovies(MovieModel movie) {
            mMovieTitle.setText(movie.mTitle);
            mMovieOverview.setText(movie.mOverview);
            mMovieRating.setText(movie.mVoteAvg);
            Picasso.with(mContext)
                    .load(movie.mPosterUrl)
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mMoviePoster);
        }
    }
}
