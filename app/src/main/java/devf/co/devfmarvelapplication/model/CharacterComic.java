package devf.co.devfmarvelapplication.model;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import devf.co.devfmarvelapplication.rest.Constants;

/**
 * Created by hugo on 4/21/15.
 */
public class CharacterComic {
    @SerializedName(Constants.ID_KEY)
    private int id;
    @SerializedName(Constants.DESCRIPTION_KEY)
    private String description;
    @Expose
    private String url;
    @Expose
    private Uri urlImage;

    public static CharacterComic buildFromJson(JsonObject characterComicData){
        Gson gson = new Gson();
        CharacterComic currentCharacterComic = gson.fromJson(characterComicData, CharacterComic.class);
        currentCharacterComic.setUrl(characterComicData.getAsJsonArray(
                Constants.COMIC_URLS_KEY)
                .get(0).getAsJsonObject()
                .get(Constants.COMIC_URL_KEY).getAsString());
        currentCharacterComic.setUrlImage(extractCharacterImgFromJson(characterComicData));

        return currentCharacterComic;
    }

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

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Uri getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Uri urlImage) {
        this.urlImage = urlImage;
    }
}
