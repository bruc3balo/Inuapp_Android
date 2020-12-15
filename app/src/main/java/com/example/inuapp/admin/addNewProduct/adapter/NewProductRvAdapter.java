package com.example.inuapp.admin.addNewProduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inuapp.R;
import com.example.inuapp.models.Products;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class NewProductRvAdapter extends RecyclerView.Adapter<NewProductRvAdapter.ViewHolder> {


    private LinkedList<Products>productList;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private final Context mContext;


    public NewProductRvAdapter(Context context, LinkedList<Products> productList) {
        this.mInflater = LayoutInflater.from(context);
        this.productList = productList;
        this.mContext = context;
    }


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.new_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.commodityDescription_admin.setText(productList.get(position).getProductDescription());
        holder.commodityPrice_admin.setText(String.valueOf(productList.get(position).getProductSellingPricePerUnit()));
        holder.commodityDescription_admin.setText(productList.get(position).getProductDescription());
       // holder.commodityNumber_admin.setText(productList.get(position).get);
    }


    // total number of rows
    @Override
    public int getItemCount() {
        return productList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView commodityName_admin, commodityPrice_admin, commodityDescription_admin, commodityNumber_admin;
        ImageView commodityImage_admin;
        ImageButton edit_admin,delete_admin;

        ViewHolder(View itemView) {
            super(itemView);
            commodityName_admin = itemView.findViewById(R.id.commodityName_admin);
            commodityPrice_admin = itemView.findViewById(R.id.commodityPrice_admin);
            commodityDescription_admin = itemView.findViewById(R.id.commodityDescription_admin);
          //  commodityNumber_admin = itemView.findViewById(R.id.commodityNumber_admin);
            commodityImage_admin = itemView.findViewById(R.id.commodityImage_admin);
            edit_admin = itemView.findViewById(R.id.edit_admin);
            delete_admin = itemView.findViewById(R.id.delete_admin);
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