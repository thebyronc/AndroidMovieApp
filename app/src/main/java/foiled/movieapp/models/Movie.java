package foiled.movieapp.models;

public class Movie {
    private String title;
    private String voteAverage;
    private String posterPath;
    private String overview;
    private String releaseDate;
    private String backDropPath;

    public Movie(String title, String voteAverage, String posterPath, String overview, String releaseDate, String backDropPath) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.posterPath = "https://image.tmdb.org/t/p/w92" + posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.backDropPath = "https://image.tmdb.org/t/p/w300" + backDropPath;
    }

    public String getTitle() {
        return title;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public String getBackDropPath() {
        return backDropPath;
    }

}
