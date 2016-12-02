package com.example.guest.moviesearch.UI;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.moviesearch.Models.MovieModel;
import com.example.guest.moviesearch.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    @Bind(R.id.moviePosterView) ImageView mMoviePoster;
    @Bind(R.id.movieTitleView) TextView mMovieTitle;
    @Bind(R.id.ratingTextView) TextView mRating;
    @Bind(R.id.saveMovieButton) Button mSaveMovieButton;
    @Bind(R.id.websiteTextView) TextView mWebsiteView;
    @Bind(R.id.movieOverviewTextView) TextView mMovieOverview;

    private MovieModel mMovie;

    public static MovieDetailFragment newInstance(MovieModel movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.with(view.getContext()).load(mMovie.mPosterUrl).into(mMoviePoster);

        mMovieTitle.setText(mMovie.mTitle);
        mRating.setText(mMovie.mVoteAvg);
        mWebsiteView.setText("https://www.themoviedb.org/");
        mWebsiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.themoviedb.org/"));
                startActivity(webIntent);
            }
        });
        mMovieOverview.setText(mMovie.mOverview);
        return view;
    }

}
