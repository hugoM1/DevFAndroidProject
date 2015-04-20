package devf.co.devfmarvelapplication.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.ui.fragments.CharacterDetailFragment;
import devf.co.devfmarvelapplication.ui.fragments.CharactersFragment;

public class CharacterDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_detail_actiity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            savedInstanceState = getIntent().getExtras();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailContainer, CharacterDetailFragment.getInstance(savedInstanceState))
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
