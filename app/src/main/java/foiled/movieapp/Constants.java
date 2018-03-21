package foiled.movieapp;

/**
 * Created by Guest on 3/21/18.
 */

public class Constants {
    public static final String MOVIEDB_KEY = BuildConfig.MOVIEDB_TOKEN;
    public static final String MOVIEDB_OPTIONS_URL = "&page=1";
    public static final String MOVIEDB_BASE_URL = "https://api.themoviedb.org/3/search/movie?api_key=" + MOVIEDB_KEY + "query=the%20rock";
}
