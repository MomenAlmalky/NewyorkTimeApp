package com.example.almal.newyorktimes.util;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.almal.newyorktimes.ui.NewyorkTimesStories;
import com.example.almal.newyorktimes.R;
import com.example.almal.newyorktimes.data.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by almal on 2017-05-18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ResultViewHolder> implements View.OnClickListener{
    List<Result> results;

    public RecyclerViewAdapter(List<Result> results) {
        this.results = results;
    }


    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ResultViewHolder pvh = new ResultViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        Result result = results.get(position);

        holder.bind(result);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @Override
    public void onClick(View view) {
        if(view instanceof CardView){
            Log.i("cardview","done");
        }
    }

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        static CardView cv;
        static TextView newsTitle;
        static TextView newsPublishDate;
        static ImageView newsImage;

        ResultViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            newsTitle = (TextView)itemView.findViewById(R.id.news_title);
            newsPublishDate = (TextView)itemView.findViewById(R.id.news_publish_date);
            newsImage = (ImageView)itemView.findViewById(R.id.news_photo);
        }
        public void bind(final Result item) {
            ResultViewHolder.newsTitle.setText(item.getTitle());
            ResultViewHolder.newsPublishDate.setText(item.getPublishedDate());
            if(item.getMultimedia().size()!=0) {
                Log.i(GlobalEntities.NEWYORK_TIMES_STORIES_ACTIVITY, String.valueOf(item.getMultimedia().size()));
                Picasso.with(NewyorkTimesStories.context).load(item.getMultimedia().get(0).getUrl()).into(ResultViewHolder.newsImage);
            }

        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
