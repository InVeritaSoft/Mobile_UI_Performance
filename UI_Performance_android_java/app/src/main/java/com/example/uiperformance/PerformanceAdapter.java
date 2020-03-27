package com.example.uiperformance;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;


public class PerformanceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int ITEM_COUNTS = 101;
    public final int TYPE_CONTAINER = R.layout.item_contaner;
    public final int TYPE_OTHER = R.layout.item_other;



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_CONTAINER == viewType){
            View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contaner, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }else{
            View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_CONTAINER){
            ((ViewHolder)holder).bind(position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_CONTAINER;
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNTS;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        static Random  rnd = new Random();

        View mContentContainer;
        TextView mItemText;


        public ViewHolder(View v) {
            super(v);
            mContentContainer = v.findViewById(R.id.item_container);
            mItemText = v.findViewById(R.id.item_text);
        }

        public void bind(final int index) {
          mItemText.setText(String.valueOf(index));
          mContentContainer.setBackgroundColor(randomColor());
        }

        private int randomColor(){
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            return  color;
        }


    }
}
