package devf.co.devfmarvelapplication.ui.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.model.ItemOptionNavDra;
import devf.co.devfmarvelapplication.ui.adapters.NavigationDrawerAdapter;

public class NavigationDrawerFragment extends Fragment {

    private NavigationDrawerCallbacks mCallbacks;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;


    public NavigationDrawerFragment() {
    }

    public interface NavigationDrawerCallbacks {
        void onNavigationDrawerItemSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mCallbacks.onNavigationDrawerItemSelected(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDrawerListView = (ListView) inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        return mDrawerListView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDrawerListView.setAdapter(new NavigationDrawerAdapter(getActivity(), loadArrayOptions()));

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);

    }

    public List<ItemOptionNavDra> loadArrayOptions() {

        List<ItemOptionNavDra> itemOptionNavDras = new ArrayList<>();

        itemOptionNavDras.add(new ItemOptionNavDra(R.mipmap.ic_character, R.string.title_section1));
        itemOptionNavDras.add(new ItemOptionNavDra(R.mipmap.ic_comics, R.string.title_section2));
        itemOptionNavDras.add(new ItemOptionNavDra(R.mipmap.ic_series, R.string.title_section3));

        return itemOptionNavDras;

    }


    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        mCallbacks.onNavigationDrawerItemSelected(position);
        mDrawerLayout.closeDrawer(mFragmentContainerView);
    }


    public void setUp(View mFragmentContainerView, DrawerLayout drawerLayout, Toolbar toolbar) {
        this.mFragmentContainerView = mFragmentContainerView;
        this.mDrawerLayout = drawerLayout;

        enableHomeButton();

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),
                mDrawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                getActivity().supportInvalidateOptionsMenu();
            }
        };

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }


    private void enableHomeButton ()
    {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }


}
