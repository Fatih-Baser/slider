package com.example.slider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdepter extends RecyclerView.Adapter<SliderAdepter.SliderViewHolder> {

    private List<slide_item>slide_items;
    private ViewPager2 viewPager2;

    SliderAdepter(List<slide_item> slide_items, ViewPager2 viewPager2) {
        this.slide_items = slide_items;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder (
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slider_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {

        holder.setImage(slide_items.get(position));
        if(position == slide_items.size()){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slide_items.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
           imageView =itemView.findViewById(R.id.imageSlider);
        }
        void  setImage(slide_item  slide_item   ){

            imageView.setImageResource(slide_item.getImage() );
        }

    }
    private Runnable runnable =new Runnable() {
        @Override
        public void run() {
            slide_items.addAll(slide_items);
            notifyDataSetChanged();
        }
    };
}
