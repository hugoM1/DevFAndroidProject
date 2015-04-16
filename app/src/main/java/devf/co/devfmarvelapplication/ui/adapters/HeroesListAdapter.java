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

public class HeroesListAdapter extends RecyclerView.Adapter<HeroesListAdapter.HeroViewHolder> {

    ArrayList<String> heroes;
    Context context;

    public HeroesListAdapter(Context context, ArrayList<String> heroes) {
        this.heroes = heroes;
        this.context = context;
    }

    public HeroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_heroe, viewGroup, false);

        return new HeroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HeroViewHolder heroViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.img_hero)
        ImageView imgHero;

        @InjectView(R.id.txt_hero_name)
        TextView txtName;

        public HeroViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
}
