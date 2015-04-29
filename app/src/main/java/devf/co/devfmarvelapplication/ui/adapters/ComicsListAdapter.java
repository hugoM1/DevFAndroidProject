package devf.co.devfmarvelapplication.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import devf.co.devfmarvelapplication.R;

/**
 * Created by sati on 29/04/2015.
 */
public class ComicsListAdapter extends RecyclerView.Adapter<ComicsListAdapter.ComicViewHolder> {

    private LayoutInflater layoutInflater;

    public ComicsListAdapter(Context context) {

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_comic, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.img_comic)
        SimpleDraweeView imgComic;

        @InjectView(R.id.textViewTitleComic)
        TextView txtTItle;


        @InjectView(R.id.textViewPagesComic)
        TextView txtPages;

        @InjectView(R.id.textViewIssueComic)
        TextView txtIssue;


        public ComicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void setImg(Uri urlImage) {
            if (!urlImage.equals(Uri.EMPTY))
                imgComic.setImageURI(urlImage);
        }


    }
}
