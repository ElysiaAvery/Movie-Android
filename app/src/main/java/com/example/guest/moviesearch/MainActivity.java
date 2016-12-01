package com.example.guest.moviesearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.moviesearch.Services.MovieService;
import com.example.guest.moviesearch.UI.MoviesActivity;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.userMovie) EditText mMovieTitle;
    @Bind(R.id.movieSearchButton) Button mMovieSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMovieSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mMovieSearchButton) {
            String query = mMovieTitle.getText().toString();
            Intent intent = new Intent(MainActivity.this, MoviesActivity.class);
            intent.putExtra("query", query);
            startActivity(intent);
        }


    }
}
