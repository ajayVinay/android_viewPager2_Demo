package com.example.pdfview.adapter;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pdfview.R;
import com.example.pdfview.ViewPagerActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class ViewPageAdapter extends RecyclerView.Adapter<ViewPageAdapter.ViewHolder> {

   private List<String> mData;
   private ViewPager2 viewPager2;
   private LayoutInflater mInflater;

    private int[] color = {R.color.black,
            R.color.holo_red_light,
            R.color.holo_blue_dark,
            R.color.holo_purple};

    public ViewPageAdapter(Context context, List<String> data, ViewPager2 viewPager2) {

        this.mInflater =LayoutInflater.from(context);
        this.mData = data;
        this.viewPager2 = viewPager2;
    }

    public ViewPageAdapter(Context context, List<String> list) {

        this.mInflater =LayoutInflater.from(context);
        this.mData = list;
    }


    @NonNull
    @Override
    public ViewPageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View converView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent,false);
        return new ViewHolder(converView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPageAdapter.ViewHolder holder, int position) {

        String animal = mData.get(position);
        holder.mTextView.setText(animal);
        holder.constraintLayout.setBackgroundResource(color[position]);

    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.tv_title);
            constraintLayout = itemView.findViewById(R.id.container);

        }
    }
}

