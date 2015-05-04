package devf.co.devfmarvelapplication.rest;


public class Constants {
    public static final String API_PUBLIC_KEY = "d684dfa6da7758f19ef605cd31519a65";
    public static final String API_PRIVATE_KEY = "757b487fa440b51f58fc4eafb6dad910bc002a49";

    //This constants are the key for each param in the URL query
    public static final String API_KEY_PARAM = "apikey";
    public static final String LIMIT_PARAM = "limit";
    public static final String OFFSET_PARAM = "offset" ;
    public static final String TS_PARAM = "ts";
    public static final String HASH_PARAM = "hash";
    public static final int CHARACTERS_LIMIT = 20;

    //This constants are the key for each object found in a JSON response
    public static final String CODE_KEY = "code";
    public static final String STATUS_KEY = "status";
    public static final String DATA_KEY = "data";
    public static final String OFFSET_KEY = "offset";
    public static final String RESULTS_KEY = "results";
    public static final String ID_KEY = "id";
    public static final String NAME_KEY = "name";
    public static final String DESCRIPTION_KEY = "description";
    public static final String THUMBNAIL_KEY = "thumbnail";
    public static final String PATH_KEY = "path";
    public static final String EXTENSION_KEY = "extension";
    public static final String COMICS_KEY = "comics";
    public static final String SERIES_KEY = "series";
    public static final String STORIES_KEY = "stories";
    public static final String AVAILABLE_KEY = "available";
    public static final String COMIC_TITLE_KEY = "title";
    public static final String COMIC_URLS_KEY = "urls";
    public static final String COMIC_URL_KEY= "url";
    public static final String COMIC_ISSUE_KEY = "issueNumber";
    public static final String COMIC_PAGES_KEY = "pageCount";


    // This constants are the key for each hero character
    public static final String HERO_URL_IMAGE = "heroImage";
    public static final String HERO_NAME = "heroName";
    public static final String HERO_DESC = "heroDesc";

    //URLs for requests
    public static final String MAIN_URL = "http://gateway.marvel.com:80/v1/public";
    public static final String HEROES_URL = "/characters";
    public static final String HERO_DETAIL_URL = "/characters/{id}"; //id -> characterId
    public static final String HERO_COMICS_URL = "/characters/{id}/series"; //id -> character series id
    public static final String COMICS_URL = "/comics"; //id -> character series id


}
