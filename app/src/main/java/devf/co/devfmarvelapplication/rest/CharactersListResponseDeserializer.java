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

import devf.co.devfmarvelapplication.model.Character;
import devf.co.devfmarvelapplication.rest.models.CharactersListResponse;

public class CharactersListResponseDeserializer implements JsonDeserializer<CharactersListResponse> {


    @Override
    public CharactersListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //First deserialize the attributes that are in the first level in the JsonObject.
        Gson gson = new Gson();
        CharactersListResponse response = gson.fromJson(json, CharactersListResponse.class);

        //Then deserialize all the attributes that are needed but are nested
        JsonObject data = json.getAsJsonObject()
                .getAsJsonObject(Constants.DATA_KEY);
        response.setOffset(data.get(Constants.OFFSET_KEY).getAsInt());

        JsonArray charactersArray = data.getAsJsonArray(Constants.RESULTS_KEY);
        response.setCharacters(extractCharactersFromJson(charactersArray));

        return response;
    }

    private ArrayList<Character> extractCharactersFromJson (JsonArray charactersArray) {
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < charactersArray.size(); i++) {
            JsonObject characterData = charactersArray.get(i).getAsJsonObject();
            characters.add(Character.buildFromJson(characterData));
        }

        return characters;
    }

}
