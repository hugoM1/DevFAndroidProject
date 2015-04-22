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

import devf.co.devfmarvelapplication.model.CharacterDetailCompose;
import devf.co.devfmarvelapplication.rest.models.CharacterDetailResponse;

/**
 * Created by hugo on 4/20/15.
 */
public class CharacterDetailResponseDeserializer implements JsonDeserializer<CharacterDetailResponse> {
    @Override
    public CharacterDetailResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        CharacterDetailResponse response = gson.fromJson(json, CharacterDetailResponse.class);

        JsonObject data = json.getAsJsonObject().getAsJsonObject(Constants.DATA_KEY);

        JsonArray characterDetailDataArray = data.getAsJsonArray(Constants.RESULTS_KEY);
        response.setCharacterDetailComposes(extractCharacterFromJson(characterDetailDataArray));

        return response;
    }

    private ArrayList<CharacterDetailCompose> extractCharacterFromJson(JsonArray characterDetailArray){
        ArrayList<CharacterDetailCompose> characterDetailComposes = new ArrayList<>();
        for (int index = 0; index < characterDetailArray.size(); index++){

            JsonObject characterDetail = characterDetailArray.get(index).getAsJsonObject();
            characterDetailComposes.add(CharacterDetailCompose.buildFromJson(characterDetail));
        }
        return characterDetailComposes;
    }
}
