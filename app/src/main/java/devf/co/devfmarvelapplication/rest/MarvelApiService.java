package devf.co.devfmarvelapplication.rest;

import devf.co.devfmarvelapplication.rest.models.HeroesListResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MarvelApiService {

    @GET(Constants.HEROES_URL)
    public void requestHeroesList(@Query(Constants.LIMIT_PARAM) int limit,
                                  @Query(Constants.OFFSET_PARAM) int offset,
                                  @Query(Constants.API_KEY_PARAM) String apiKey,
                                  @Query(Constants.TS_PARAM) long ts,
                                  @Query(Constants.HASH_PARAM) String hash,
                                   Callback<HeroesListResponse> callback);


}
