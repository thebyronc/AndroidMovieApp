package foiled.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import foiled.movieapp.adapters.MovieListAdapter;
import foiled.movieapp.models.Movie;
import okhttp3.Call;
import okhttp3.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;
import foiled.movieapp.R;
import foiled.movieapp.services.MovieDBService;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private MovieListAdapter mAdapter;

    public ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String search = intent.getStringExtra("search");


    }

    private void getMovies(String search) {
        final MovieDBService movieDBService = new MovieDBService();
        movieDBService.findMovies(search, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                movies = movieDBService.processResults(response);


            }

        });
    }
}
