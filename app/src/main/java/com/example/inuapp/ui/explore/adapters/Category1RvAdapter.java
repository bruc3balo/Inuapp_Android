package com.example.inuapp.ui.explore.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inuapp.R;
import com.example.inuapp.ui.cart.Cart;
import com.example.inuapp.ui.wishlist.Wishlist;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class Category1RvAdapter extends RecyclerView.Adapter<Category1RvAdapter.ViewHolder> {


    private LinkedList<String> images;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private final Context mContext;


    public Category1RvAdapter(Context context, LinkedList<String> images) {
        this.mInflater = LayoutInflater.from(context);
        this.images = images;
        this.mContext = context;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.addToWishlistButton.setOnClickListener(v -> mContext.startActivity(new Intent(mContext, Wishlist.class)));
        holder.addToCartButton.setOnClickListener(v -> mContext.startActivity(new Intent(mContext, Cart.class)));
    }


    // total number of rows
    @Override
    public int getItemCount() {
        return images.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button addToCartButton, addToWishlistButton;

        ViewHolder(View itemView) {
            super(itemView);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            addToWishlistButton = itemView.findViewById(R.id.addToWishlistButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}