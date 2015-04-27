package se.k3.antonochisak.kd323bassignment5.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import se.k3.antonochisak.kd323bassignment5.R;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;

/**
 * Created by Anton on 15-04-27.
 */

public class TrendingMoviesAdapter extends BaseAdapter {

    ArrayList<Movie> mMovies;
    LayoutInflater mLayoutInflater;
    //private int mItemWidth, mItemHeight, mMargin;

    public TrendingMoviesAdapter(ArrayList<Movie> mMovies, LayoutInflater mLayoutInflater) {
        this.mMovies = mMovies;
        this.mLayoutInflater = mLayoutInflater;
    }

    class ViewHolder {
        @InjectView(R.id.poster)
        ImageView poster;

        @InjectView(R.id.title)
        TextView title;

        @InjectView(R.id.year)
        TextView year;

//        @InjectView(R.id.overview)
//        TextView overview;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.trending_list_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Movie movie = mMovies.get(i);

        String title = String.valueOf(movie.getTitle());
                holder.title.setText(title);

        String year = String.valueOf(movie.getYear());
        holder.year.setText(year);

//        String overview = String.valueOf(movie.getOverview());
//        holder.overview.setText(overview);


        // Load pictures with picasso
        Picasso.with(view.getContext())
                .load(mMovies.get(i)
                        .getPoster())
                        //.resize(mItemWidth, mItemHeight)
                .into(holder.poster);
        return view;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
