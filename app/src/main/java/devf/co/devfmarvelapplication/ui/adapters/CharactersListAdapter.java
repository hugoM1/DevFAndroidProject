package devf.co.devfmarvelapplication.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.model.Character;
import devf.co.devfmarvelapplication.nav.NavigationHelper;
import devf.co.devfmarvelapplication.rest.Constants;
import devf.co.devfmarvelapplication.rest.MarvelApiClient;
import devf.co.devfmarvelapplication.rest.models.CharactersListResponse;
import devf.co.devfmarvelapplication.ui.CharacterDetailActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static java.util.Collections.EMPTY_LIST;

public class CharactersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_CHARACTER = 0;
    private final int VIEW_PROGRESS = 1;
    private String noneContent = "None";
    private int DETAIL_FRAGMENT_ID = 0;

    List<Character> characters = EMPTY_LIST;
    Context context;

    /**
     * @param context Context needed to access {@link android.view.LayoutInflater}
     */
    public CharactersListAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        return characters.get(position) != null ? VIEW_CHARACTER : VIEW_PROGRESS;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        if (viewType == VIEW_CHARACTER) {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_character, viewGroup, false);

            return new CharacterViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_character_progress, viewGroup, false);

            return new ProgressViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof CharacterViewHolder) {
            Character currentCharacter = characters.get(position);
            ((CharacterViewHolder) viewHolder).setImg(currentCharacter.getUrlImage());
            ((CharacterViewHolder) viewHolder).setName(currentCharacter.getName());

            Bundle bundle = new Bundle();

            bundle.putString(Constants.HERO_URL_IMAGE, String.valueOf(currentCharacter.getUrlImage()));
            bundle.putString(Constants.ID_KEY, String.valueOf(currentCharacter.getId()));
            bundle.putString(Constants.HERO_NAME, currentCharacter.getName());
            bundle.putInt(CharacterDetailActivity.HERO_DETAIL_FRAGMENT_TAG, DETAIL_FRAGMENT_ID);
            if (currentCharacter.getDescription().length() > 0) {
                bundle.putString(Constants.HERO_DESC, currentCharacter.getDescription());
            } else {
                bundle.putString(Constants.HERO_DESC,noneContent );
            }

            ((CharacterViewHolder) viewHolder).item.setOnClickListener((View v) -> {
                NavigationHelper.startCharacterDetail(((ActionBarActivity) context), bundle);
            });

        }
    }

    @Override
    public int getItemCount() {
        if (characters == null)
            return 0;

        return characters.size();
    }

    /**
     * When we load more characters, a {@link devf.co.devfmarvelapplication.ui.adapters.CharactersListAdapter.ProgressViewHolder} is added
     * The {@link devf.co.devfmarvelapplication.ui.interfaces.EndlessRecyclerOnScrollListener} needs the number of real items  in the list.
     */
    public int getCharacterItemsCount() {
        if (isProgressViewVisible())
            return characters.size() - 1;

        return characters.size();
    }

    /**
     * Replace the current adapter data and replace it with a new collection.
     *
     * @param characters New {@link devf.co.devfmarvelapplication.model.Character} collection
     */
    public void updateList(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    /**
     * Add a bunch of items to the current characters list
     *
     * @param characters items to add
     */
    public void addItemCollection(List<Character> characters) {
        this.characters.addAll(characters);
        notifyDataSetChanged();
    }

    /**
     * Make a request to the Marvel API to load 20 more characters
     * The offset for the request is defined by {@link #getItemCount()}
     */
    public void requestForMoreCharacters() {
        showOnLoadViewHolder();
        MarvelApiClient.getInstance(context)
                .requestHeroesList(Constants.CHARACTERS_LIMIT, getCharacterItemsCount(), new Callback<CharactersListResponse>() {
                    @Override
                    public void success(CharactersListResponse charactersListResponse, Response response) {
                        characters.remove(characters.size() - 1);
                        addItemCollection(charactersListResponse.getCharacters());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        error.printStackTrace();
                    }
                });
    }

    private void showOnLoadViewHolder() {
        characters.add(null);
        notifyDataSetChanged();
    }

    public boolean isProgressViewVisible() {
        return characters.contains(null);
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.itemMain)
        RelativeLayout item;

        @InjectView(R.id.img_character)
        SimpleDraweeView imgCharacter;

        @InjectView(R.id.txt_character_name)
        TextView txtName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }



        public void setImg(Uri urlImage) {
            if (!urlImage.equals(Uri.EMPTY))
                imgCharacter.setImageURI(urlImage);
        }

        public void setName(String name) {
            txtName.setText(name);
        }
    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }
}
