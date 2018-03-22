package foiled.movieapp.services;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import foiled.movieapp.Constants;
import foiled.movieapp.models.Movie;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieDBService {
    public static void findMovies(String query, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIEDB_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.MOVIEDB_QUERY, query);
        String url = urlBuilder.build().toString();
        Log.d("String", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject movieDBJSON = new JSONObject(jsonData);
            JSONArray resultsJSON = movieDBJSON.getJSONArray("results");
            for (int i = 0; i < resultsJSON.length(); i++) {
                JSONObject movieJSON = resultsJSON.getJSONObject(i);
                String title = movieJSON.getString("title");
                String voteAverage = movieJSON.getString("vote_average");
                String posterPath = movieJSON.getString("poster_path");
                String overview = movieJSON.getString("overview");
                String releaseDate = movieJSON.getString("release_date");
                String backDropPath = movieJSON.getString("backdrop_path");

                Movie movie = new Movie(title, voteAverage, posterPath, overview, releaseDate, backDropPath);
                movies.add(movie);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
