package devf.co.devfmarvelapplication.rest;

import devf.co.devfmarvelapplication.rest.models.CharacterDetailResponse;
import devf.co.devfmarvelapplication.rest.models.CharactersListResponse;
import devf.co.devfmarvelapplication.rest.models.ComicsListResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface MarvelApiService {

    @GET(Constants.HEROES_URL)
    public void requestHeroesList(@Query(Constants.LIMIT_PARAM) int limit,
                                  @Query(Constants.OFFSET_PARAM) int offset,
                                  @Query(Constants.API_KEY_PARAM) String apiKey,
                                  @Query(Constants.TS_PARAM) long ts,
                                  @Query(Constants.HASH_PARAM) String hash,
                                   Callback<CharactersListResponse> callback);

    @GET(Constants.HERO_DETAIL_URL)
    public void requestHeroDetail(
            @Path("id")
            String characterId,
            @Query(Constants.API_KEY_PARAM) String apiKey,
            @Query(Constants.TS_PARAM) long ts,
            @Query(Constants.HASH_PARAM) String hash,
            Callback<CharacterDetailResponse> callback
    );

    @GET(Constants.HERO_COMICS_URL)
    public void requestHeroList(
            @Path("id") String comicId,
            @Query(Constants.API_KEY_PARAM) String apiKey,
            @Query(Constants.TS_PARAM) long ts,
            @Query(Constants.HASH_PARAM) String hash,
            Callback<CharacterDetailResponse> callback
    );

    @GET(Constants.COMICS_URL)
    public void requestComicsList(@Query(Constants.LIMIT_PARAM) int limit,
                                  @Query(Constants.OFFSET_PARAM) int offset,
                                  @Query(Constants.API_KEY_PARAM) String apiKey,
                                  @Query(Constants.TS_PARAM) long ts,
                                  @Query(Constants.HASH_PARAM) String hash,
                                  Callback<ComicsListResponse> callback);


}
