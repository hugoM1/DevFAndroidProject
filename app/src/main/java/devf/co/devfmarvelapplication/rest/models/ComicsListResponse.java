package devf.co.devfmarvelapplication.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import devf.co.devfmarvelapplication.model.Character;
import devf.co.devfmarvelapplication.model.Comic;
import devf.co.devfmarvelapplication.rest.Constants;

/**
 * This class contains the structure of the response for the
 * {@link devf.co.devfmarvelapplication.rest.MarvelApiService#requestHeroesList(int, int, String, long, String, retrofit.Callback)}
 * */
public class ComicsListResponse {
    @SerializedName(Constants.CODE_KEY)
    private int code;

    @SerializedName(Constants.STATUS_KEY)
    private String status;

    //We expose these fields because we gonna parse them manually with a deserializer
    @Expose
    private int offset;

    @Expose
    List<Comic> comics;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<Comic> getComics() {
        return comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }
}

