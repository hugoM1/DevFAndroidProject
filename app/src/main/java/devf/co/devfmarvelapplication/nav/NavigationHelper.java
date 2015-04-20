package devf.co.devfmarvelapplication.nav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import devf.co.devfmarvelapplication.ui.CharacterDetailActivity;

/**
 * Created by hugo on 4/18/15.
 */
public class NavigationHelper {

    public static void startCharacterDetail(ActionBarActivity activity, Bundle bundle){
        Intent detailCharacter = new Intent(activity, CharacterDetailActivity.class);
        detailCharacter.putExtras(bundle);
        activity.startActivity(detailCharacter);
    }
}
