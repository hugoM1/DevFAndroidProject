package devf.co.devfmarvelapplication.ui.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;

public class CharactersListAdapter extends RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder> {

    ArrayList<String> characters;
    Context context;

    /**
     * @param context Context needed to access {@link android.view.LayoutInflater}
     * @param characters This characters data will be showed in the list
     * */
    public CharactersListAdapter(Context context, ArrayList<String> characters) {
        this.characters = characters;
        this.context = context;
    }

    public CharacterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_character, viewGroup, false);

        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder CharacterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.img_character)
        ImageView imgCharacter;

        @InjectView(R.id.txt_character_name)
        TextView txtName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
}
