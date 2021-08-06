package com.example.rest_room_api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.rest_room_api.R;
import com.example.rest_room_api.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ItemClickListener mClickListener;
    private List<Category> categoryList = new ArrayList<>();

    public CategoryAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_view_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textView.setText(categoryList.get(position).getTitle());
        holder.textView2.setText(categoryList.get(position).getLname());

        Glide.with(context)
                .load(categoryList.get(position).getImage())
                .placeholder(R.drawable.group)
                .into(holder.imageView);



    }

    public void addItems(List<Category> categories){
        this.categoryList.clear();
        this.categoryList.addAll(categories);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView, textView2;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            textView2 = itemView.findViewById(R.id.lname);
            imageView = itemView.findViewById(R.id.picture);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

