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
import java.util.List;

import devf.co.devfmarvelapplication.model.Character;
import devf.co.devfmarvelapplication.model.Comic;
import devf.co.devfmarvelapplication.rest.models.ComicsListResponse;

public class ComicsListResponseDeserializer implements JsonDeserializer<ComicsListResponse> {


    @Override
    public ComicsListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //First deserialize the attributes that are in the first level in the JsonObject.
        Gson gson = new Gson();
        ComicsListResponse response = gson.fromJson(json, ComicsListResponse.class);

        //Then deserialize all the attributes that are needed but are nested
        JsonObject data = json.getAsJsonObject()
                .getAsJsonObject(Constants.DATA_KEY);
        response.setOffset(data.get(Constants.OFFSET_KEY).getAsInt());

        JsonArray charactersArray = data.getAsJsonArray(Constants.RESULTS_KEY);
        response.setComics(extractComicsFromJson(charactersArray));

        return response;    }

    private List<Comic> extractComicsFromJson(JsonArray comicsArray) {
        List<Comic> comics = new ArrayList<>();

        for (int i = 0; i < comicsArray.size(); i++) {
            JsonObject characterData = comicsArray.get(i).getAsJsonObject();
            comics.add(Comic.buildFromJson(characterData));
        }

        return comics;
    }

}
