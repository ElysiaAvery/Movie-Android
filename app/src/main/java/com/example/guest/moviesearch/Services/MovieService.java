package com.example.guest.moviesearch.Services;

import android.graphics.Movie;
import android.util.Log;

import com.example.guest.moviesearch.Constants;
import com.example.guest.moviesearch.Models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 12/1/16.
 */
public class MovieService {
    public static final String TAG = MovieService.class.getSimpleName();
    public static void getMovies(String query, Callback callback) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TITLE_URL_BASE).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY, Constants.MOVIE_KEY);
        urlBuilder.addQueryParameter("language", "en-US");
        urlBuilder.addQueryParameter(Constants.MOVIE_TITLE, query);
        urlBuilder.addQueryParameter("page", "1");
        urlBuilder.addQueryParameter("include_adult", "false");

        String url = urlBuilder.build().toString();
        Log.v(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<MovieModel> processResponse(Response response) {
        ArrayList<MovieModel> movieList = new ArrayList<>();

        try{
            if(response.isSuccessful()) {
                String jsonData = response.body().string();
                JSONObject results = new JSONObject(jsonData);
                JSONArray resultsArray =  results.getJSONArray("results");
                for(int i = 0; i < resultsArray.length(); i++) {
                    JSONObject movie = resultsArray.getJSONObject(i);
                    String title = movie.getString("title");
                    String posterUrl = "https://image.tmdb.org/t/p/w780" + movie.getString("poster_path");
                    String overview = movie.getString("overview");
                    String rating = String.valueOf(movie.getDouble("vote_average"));
                    MovieModel newMovie = new MovieModel(title, posterUrl, overview, rating);
                    movieList.add(newMovie);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieList;
    }
}
