package devf.co.devfmarvelapplication.ui.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.rest.Constants;
import devf.co.devfmarvelapplication.rest.MarvelApiClient;
import devf.co.devfmarvelapplication.rest.models.CharacterDetailResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by hugo on 4/18/15.
 */
public class CharacterDetailFragment extends Fragment {

    @InjectView(R.id.img_detail_character)
    SimpleDraweeView heroImage;
    @InjectView(R.id.heroName)
    TextView heroName;
    @InjectView(R.id.heroDesc)
    TextView heroDesc;


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
        MarvelApiClient.getInstance(getActivity()).requestHeroDetail(getArguments().getString(Constants.ID_KEY), new Callback<CharacterDetailResponse>() {
            @Override
            public void success(CharacterDetailResponse characterDetailResponse, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
        return rootView;
    }

    private void initView(){
        heroImage.setImageURI(Uri.parse(getArguments().getString(Constants.HERO_URL_IMAGE)));
        heroName.setText(getArguments().getString(Constants.HERO_NAME));
        heroDesc.setText(getArguments().getString(Constants.HERO_DESC));
    }
}
