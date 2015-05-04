package devf.co.devfmarvelapplication.ui.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.ui.adapters.ComicsListAdapter;
import devf.co.devfmarvelapplication.ui.interfaces.OnComicsRecycleViewScrollListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComicsFragment extends Fragment {

    private RecyclerView recyclerViewComics;
    private ComicsListAdapter comicsListAdapter;
    private Context CONTEXT;

    public ComicsFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclerViewComics = (RecyclerView) inflater.inflate(R.layout.fragment_comics, container, false);
        return recyclerViewComics;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListComics();
    }

    private void initListComics() {
        GridLayoutManager gm = new GridLayoutManager(CONTEXT, 2);
        comicsListAdapter = new ComicsListAdapter(CONTEXT);
        recyclerViewComics.setLayoutManager(gm);
        recyclerViewComics.setAdapter(comicsListAdapter);
        recyclerViewComics.setOnScrollListener(new OnComicsRecycleViewScrollListener(gm) {
            @Override
            public void onLoadMore() {
                comicsListAdapter.requestForMoreComics();
            }
        });


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comicsListAdapter.requestForMoreComics();
    }

}
