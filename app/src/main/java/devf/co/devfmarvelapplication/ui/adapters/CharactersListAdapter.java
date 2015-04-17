package devf.co.devfmarvelapplication.ui.adapters;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.model.Character;

public class CharactersListAdapter extends RecyclerView.Adapter<CharactersListAdapter.CharacterViewHolder> {

    List <Character> characters = Collections.EMPTY_LIST;
    Context context;

    /**
     * @param context Context needed to access {@link android.view.LayoutInflater}
     * */
    public CharactersListAdapter(Context context) {
        this.context = context;
    }

    public CharacterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_character, viewGroup, false);

        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder viewHolder, int position) {
        Character currentCharacter = characters.get(position);
        viewHolder.setImg(currentCharacter.getUrlImage());
        viewHolder.setName(currentCharacter.getName());
    }

    @Override
    public int getItemCount() {
        if (characters == null)
            return 0;

        return characters.size();
    }

    public void updateList(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.img_character)
        SimpleDraweeView imgCharacter;

        @InjectView(R.id.txt_character_name)
        TextView txtName;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }

        public void setImg(Uri urlImage) {
            if(!urlImage.equals(Uri.EMPTY))
                imgCharacter.setImageURI(urlImage);
        }

        public void setName(String name){
            txtName.setText(name);
        }
    }
}
