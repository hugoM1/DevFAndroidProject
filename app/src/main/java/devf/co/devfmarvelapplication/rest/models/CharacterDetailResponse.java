package devf.co.devfmarvelapplication.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import devf.co.devfmarvelapplication.model.*;
import devf.co.devfmarvelapplication.rest.Constants;

/**
 * Created by hugo on 4/20/15.
 */
public class CharacterDetailResponse {
    @SerializedName(Constants.CODE_KEY)
    private int code;

    @SerializedName(Constants.STATUS_KEY)
    private String status;

    @Expose
    List<CharacterDetailCompose> characterDetailComposes;

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

    public List<CharacterDetailCompose> getCharacterDetailComposes() {
        return characterDetailComposes;
    }

    public void setCharacterDetailComposes(List<CharacterDetailCompose> characterDetailComposes) {
        this.characterDetailComposes = characterDetailComposes;
    }
}
