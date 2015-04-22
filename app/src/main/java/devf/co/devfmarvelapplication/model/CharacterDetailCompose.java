package devf.co.devfmarvelapplication.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import devf.co.devfmarvelapplication.rest.Constants;

/**
 * Created by hugo on 4/20/15.
 */
public class CharacterDetailCompose extends Character{
    public static CharacterDetailCompose buildFromJson(JsonObject characterDetailData){
        Gson gson = new Gson();
        CharacterDetailCompose currentCharacterDetailCompose = gson.fromJson(characterDetailData, CharacterDetailCompose.class);
        currentCharacterDetailCompose.setDescription(Constants.DESCRIPTION_KEY);

        return currentCharacterDetailCompose;
    }
}
