package devf.co.devfmarvelapplication.ui.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.rest.Constants;

/**
 * Created by hugo on 4/18/15.
 */
public class CharacterDetailFragment extends Fragment {

    @InjectView(R.id.img_detail_character)
    SimpleDraweeView heroImage;

    public CharacterDetailFragment() {
    }

    public static CharacterDetailFragment getInstance(Bundle bundle){
        CharacterDetailFragment mCharacterDetailFragment = new CharacterDetailFragment();

        mCharacterDetailFragment.setArguments(bundle);

        return mCharacterDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_character_detail, container, false);

        ButterKnife.inject(this, rootView);
        initView();
        return rootView;
    }

    private void initView(){
        heroImage.setImageURI(Uri.parse(getArguments().getString(Constants.HERO_URL_IMAGE)));
    }
}
