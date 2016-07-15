package com.app.testdragndroprv;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by root on 27/05/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ExerciseViewHolder> {

    public List<Exercise> exercises;

    public Adapter(List<Exercise> exercises){
        this.exercises = exercises;
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public TextView name;
        public TextView counter;
        public ImageView imageUrl;

        public ExerciseViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_test);
            name = (TextView) itemView.findViewById(R.id.textName);
            counter = (TextView) itemView.findViewById(R.id.textCounter);
            imageUrl = (ImageView) itemView.findViewById(R.id.iv_image);
        }

        public CardView getCardView() { return cv; }
        public TextView getTextName() { return name; }
        public TextView getTextCounter() { return counter; }
        public ImageView getImageUrl() { return imageUrl; }
    }

    @Override
    public ExerciseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ExerciseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExerciseViewHolder holder, int position) {
        Context context = holder.getImageUrl().getContext();

        holder.getTextName().setText(exercises.get(position).getName());
        holder.getTextCounter().setText(exercises.get(position).getCounter());
        Log.v("URL", exercises.get(position).getImgUrl());
        Glide.with(context).load(exercises.get(position).getImgUrl()).centerCrop().into(holder.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
