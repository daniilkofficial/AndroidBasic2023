package com.daniilk.la9movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

//    String filter = "&field=rating.kp&search=7-10&sortField=votes.kpsortType=-1&limit=30";
//    String filter = "&field=rating.kp&search=4-10&sortField=votes.kpsortType=1&limit=100";
    String filter = "&sortField=votes.kp&sortType=-1&limit=30&rating.kp=4-10";


    @GET("v1.3/movie?token=4GWXPPG-W83440Q-MTC9NBZ-R4VSARH" + filter)
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("v1.3/movie/{id}?token=4GWXPPG-W83440Q-MTC9NBZ-R4VSARH")
    Single<TrailerResponse> loadTrailers(@Path("id") int id);

    @GET("v1/review?token=4GWXPPG-W83440Q-MTC9NBZ-R4VSARH")
    Single<ReviewResponse> loadReviews(@Query("movieId") int id);
}
