package devf.co.devfmarvelapplication.ui.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.model.Hero;
import devf.co.devfmarvelapplication.rest.MarvelApiClient;
import devf.co.devfmarvelapplication.rest.models.HeroesListResponse;
import devf.co.devfmarvelapplication.ui.adapters.HeroesListAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HeroesFragment extends Fragment {

    private static final String LOG_TAG = HeroesFragment.class.getCanonicalName();
    public Context CONTEXT;

    @InjectView(R.id.list_heroes)
    RecyclerView mListHeroes;

    public HeroesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_heroes, container, false);
        ButterKnife.inject(this, rootView);

        initListHeroes();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        MarvelApiClient.getInstance(CONTEXT)
                .requestHeroesList(2, 0, new Callback<HeroesListResponse>() {
                    @Override
                    public void success(HeroesListResponse heroesListResponse, Response response) {
                        //Only for debugging
                        ArrayList<Hero> heroes = heroesListResponse.getHeroes();
                        for(Hero hero: heroes) {
                            Log.i(LOG_TAG, hero.toString());
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        error.printStackTrace();
                    }
                });
    }

    //================================================================================
    //Init Methods
    //================================================================================
    private void initListHeroes() {
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL , false);
        mListHeroes.setLayoutManager(lm);

        //Todo: remove this section
        ArrayList<String> heroes = new ArrayList<>();
        heroes.add("1");
        heroes.add("2");
        heroes.add("3");
        heroes.add("4");

        HeroesListAdapter adapter = new HeroesListAdapter(CONTEXT, heroes);
        mListHeroes.setAdapter(adapter);
    }
}
