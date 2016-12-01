package com.example.guest.moviesearch.Models;

import org.parceler.Parcel;



/**
 * Created by Guest on 12/1/16.
 */

@Parcel
public class MovieModel {
    public String mTitle;
    public String mPosterUrl;
    public String mOverview;
    public String mVoteAvg;

    public MovieModel() {

    }

    public MovieModel(String title, String posterUrl, String overview, String voteAvg) {
        this.mTitle = title;
        this.mPosterUrl = posterUrl;
        this.mOverview = overview;
        this.mVoteAvg = voteAvg;
    }

}
