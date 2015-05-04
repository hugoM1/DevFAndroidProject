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
public class Comic {

    @SerializedName(Constants.ID_KEY)
    private int id;

    @SerializedName(Constants.COMIC_TITLE_KEY)
    private String title;

    @SerializedName(Constants.COMIC_PAGES_KEY)
    private int pages;

    @SerializedName(Constants.COMIC_ISSUE_KEY)
    private int issues;

    @Expose
    Uri urlImage;

    public static Comic buildFromJson (JsonObject characterData) {
        Gson gson = new Gson();
        Comic currentComic = gson.fromJson(characterData, Comic.class);
        currentComic.setUrlImage(extractComicImgFromJson(characterData));

        return currentComic;
    }

    private static Uri extractComicImgFromJson(JsonObject characterData) {
        if (characterData.get(Constants.THUMBNAIL_KEY).isJsonNull())
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getIssues() {
        return issues;
    }

    public Uri getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Uri urlImage) {
        this.urlImage = urlImage;
    }





}
