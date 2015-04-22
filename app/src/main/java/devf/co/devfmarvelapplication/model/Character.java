package devf.co.devfmarvelapplication.model;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import devf.co.devfmarvelapplication.rest.Constants;

public class Character {

    @SerializedName(Constants.ID_KEY)
    int id;

    @SerializedName(Constants.NAME_KEY)
    String name;

    @SerializedName(Constants.DESCRIPTION_KEY)
    String description;

    @Expose
    Uri urlImage;

    @Expose
    int availableComics;

    @Expose
    int availableSeries;

    @Expose
    int availableStories;

    /**
     * Build a {@link devf.co.devfmarvelapplication.model.Character} from a JsonObject.
     * To build it, extract all the nested data from {@code characterData}
     * */
    public static Character buildFromJson (JsonObject characterData) {
        Gson gson = new Gson();
        Character currentCharacter = gson.fromJson(characterData, Character.class);
        currentCharacter.setUrlImage(extractCharacterImgFromJson(characterData));
        currentCharacter.setAvailableComics(
                extractCharacterAvailableResource(Constants.COMICS_KEY, characterData));
        currentCharacter.setAvailableSeries(
                extractCharacterAvailableResource(Constants.SERIES_KEY, characterData));
        currentCharacter.setAvailableStories(
                extractCharacterAvailableResource(Constants.STORIES_KEY, characterData));

        return currentCharacter;
    }

    /**
     * Use a JsonObject that contains the character data to extract the character thumbnail image <br>
     * <a href="http://developer.marvel.com/docs#!/public/getCreatorCollection_get_0">Check the general Json response</a>
     *
     * @return empty string if there is no image
     * */
    private static Uri extractCharacterImgFromJson(JsonObject characterData) {
        if(characterData.get(Constants.THUMBNAIL_KEY).isJsonNull())
            return Uri.EMPTY;
        // First obtain the image url and then obtain the extension of that image
        String imgUrl = characterData.get(Constants.THUMBNAIL_KEY).getAsJsonObject()
                .get(Constants.PATH_KEY).getAsString() + "." +
                characterData.get(Constants.THUMBNAIL_KEY).getAsJsonObject()
                .get(Constants.EXTENSION_KEY).getAsString();

        return Uri.parse(imgUrl);
    }

    /**
     *Try to extract the mount of a character resource, like comics, stories or series.
     * @param availableResource The string key for the resource, it could be: <br>
     *                          {@link devf.co.devfmarvelapplication.rest.Constants#COMICS_KEY}<br>
     *                          {@link devf.co.devfmarvelapplication.rest.Constants#SERIES_KEY}<br>
     *                          {@link devf.co.devfmarvelapplication.rest.Constants#STORIES_KEY}<br>
     * */
    private static int extractCharacterAvailableResource(String availableResource, JsonObject characterData) throws IllegalArgumentException {
        if(!availableResource.equals(Constants.COMICS_KEY) &&
                !availableResource.equals(Constants.STORIES_KEY) && !availableResource.equals(Constants.SERIES_KEY))
            throw new IllegalArgumentException();
        else
            return characterData.get(availableResource).getAsJsonObject().get(Constants.AVAILABLE_KEY).getAsInt();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Uri getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Uri urlImage) {
        this.urlImage = urlImage;
    }

    public int getAvailableComics() {
        return availableComics;
    }

    public void setAvailableComics(int availableComics) {
        this.availableComics = availableComics;
    }

    public int getAvailableSeries() {
        return availableSeries;
    }

    public void setAvailableSeries(int availableSeries) {
        this.availableSeries = availableSeries;
    }

    public int getAvailableStories() {
        return availableStories;
    }

    public void setAvailableStories(int availableStories) {
        this.availableStories = availableStories;
    }

    @Override
    public String toString() {
        String hero = name +
                "\n Description:" + description +
                "\n img:"+ urlImage +
                "\n available comics:"+ availableComics +
                "\n available series:"+ availableSeries +
                "\n available stories:"+ availableStories;

        return hero;
    }
}
