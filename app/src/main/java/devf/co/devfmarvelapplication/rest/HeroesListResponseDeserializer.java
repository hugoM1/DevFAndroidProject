package devf.co.devfmarvelapplication.rest;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import devf.co.devfmarvelapplication.model.Hero;
import devf.co.devfmarvelapplication.rest.models.HeroesListResponse;

public class HeroesListResponseDeserializer implements JsonDeserializer<HeroesListResponse> {

    //TODO: Refactor deserialize method
    @Override
    public HeroesListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        HeroesListResponse response = gson.fromJson(json, HeroesListResponse.class);

        JsonObject data = json.getAsJsonObject()
                .getAsJsonObject(Constants.DATA_KEY);

        response.setOffset(data.get(Constants.OFFSET_KEY).getAsInt());

        ArrayList<Hero> heroes = new ArrayList<>();
        JsonArray heroesArray = data.getAsJsonArray(Constants.RESULTS_KEY);

        for (int i = 0; i < heroesArray.size(); i++) {
            JsonObject heroData = heroesArray.get(i).getAsJsonObject();
            Hero currentHero = gson.fromJson(heroData, Hero.class);

            String imgUrl = heroData.get(Constants.THUMBNAIL_KEY).getAsJsonObject()
                    .get(Constants.PATH_KEY).getAsString() + heroData.get(Constants.THUMBNAIL_KEY).getAsJsonObject()
                    .get(Constants.EXTENSION_KEY).getAsString();

            int availableComics = heroData.get(Constants.COMICS_KEY)
                    .getAsJsonObject().get(Constants.AVAILABLE_KEY).getAsInt();

            int availableSeries = heroData.get(Constants.SERIES_KEY)
                    .getAsJsonObject().get(Constants.AVAILABLE_KEY).getAsInt();

            int availableStories = heroData.get(Constants.STORIES_KEY)
                    .getAsJsonObject().get(Constants.AVAILABLE_KEY).getAsInt();

            currentHero.setUrlImage(imgUrl);
            currentHero.setAvailableComics(availableComics);
            currentHero.setAvailableSeries(availableSeries);
            currentHero.setAvailableStories(availableStories);

            heroes.add(currentHero);
        }

        response.setHeroes(heroes);
        return response;
    }

}
