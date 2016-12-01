package com.example.guest.moviesearch.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.moviesearch.Models.MovieModel;
import com.example.guest.moviesearch.UI.MovieDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 12/1/16.
 */

public class MoviePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<MovieModel> mMovieList;

    public MoviePagerAdapter(FragmentManager fm, ArrayList<MovieModel> movies) {
        super(fm);
        mMovieList = movies;
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance(mMovieList.get(position));
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMovieList.get(position).mTitle;
    }
}

