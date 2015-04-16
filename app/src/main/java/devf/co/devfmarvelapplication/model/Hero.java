package devf.co.devfmarvelapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import devf.co.devfmarvelapplication.rest.Constants;

public class Hero {

    @SerializedName(Constants.ID_KEY)
    int id;

    @SerializedName(Constants.NAME_KEY)
    String name;

    @SerializedName(Constants.DESCRIPTION_KEY)
    String description;

    @Expose
    String urlImage;

    @Expose
    int availableComics;

    @Expose
    int availableSeries;

    @Expose
    int availableStories;

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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
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
