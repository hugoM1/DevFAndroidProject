package devf.co.devfmarvelapplication.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import devf.co.devfmarvelapplication.R;
import devf.co.devfmarvelapplication.model.ItemOptionNavDra;

/**
 * Adapter para el Navigation Drawer
 */
public class NavigationDrawerAdapter extends ArrayAdapter<ItemOptionNavDra> {

    private List<ItemOptionNavDra> itemOptionNavDras;
    private LayoutInflater layoutInflater;


    public NavigationDrawerAdapter(Context context, List<ItemOptionNavDra> itemOptionNavDras) {
        super(context, R.layout.item_navigation_drawer, itemOptionNavDras);
        this.layoutInflater = LayoutInflater.from(context);
        this.itemOptionNavDras = itemOptionNavDras;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.item_navigation_drawer, parent, false);

        ImageView imageViewIcon = (ImageView) view.findViewById(R.id.imageViewIconContent);
        imageViewIcon.setImageResource(itemOptionNavDras.get(position).getIdIcon());
        TextView textView = (TextView) view.findViewById(R.id.textViewContentTitle);
        textView.setText(itemOptionNavDras.get(position).getIdText());

        return view;
    }
}
