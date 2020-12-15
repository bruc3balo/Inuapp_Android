package com.example.inuapp.admin.addProducts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inuapp.R;
import com.example.inuapp.admin.addNewProduct.adapter.NewProductRvAdapter;
import com.example.inuapp.models.Products;
import com.example.inuapp.ui.explore.ExploreViewModel;
import com.example.inuapp.ui.explore.adapters.ElectronicsRv;

import java.util.LinkedList;


public class AddToMarket extends AppCompatActivity {

    private final LinkedList<Products> productsList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_market);

        RecyclerView productMarketRv = findViewById(R.id.productMarketRv);
        productMarketRv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        ElectronicsRv electronicsRv = new ElectronicsRv(this,productsList);
        productMarketRv.setAdapter(electronicsRv);

        populateShop(electronicsRv);
    }

    private void populateShop(ElectronicsRv newProductFragment) {
        ExploreViewModel exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        exploreViewModel.getProductsData().observe(this, products -> {
            productsList.add(products);
            newProductFragment.notifyDataSetChanged();
        });
    }

}