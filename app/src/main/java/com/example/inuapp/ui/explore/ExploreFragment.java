package com.example.inuapp.ui.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.inuapp.R;
import com.example.inuapp.models.Products;
import com.example.inuapp.ui.explore.adapters.ElectronicsRv;

import java.util.LinkedList;

public class ExploreFragment extends Fragment {

    private final LinkedList<Products> category1List = new LinkedList<>();
    private ElectronicsRv category1Adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_explore, container, false);

        //Electronics
        RecyclerView electronicsRv = root.findViewById(R.id.electronicsRv);
        electronicsRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        category1Adapter = new ElectronicsRv(requireContext(), category1List);
        electronicsRv.setAdapter(category1Adapter);


        populateShop();

        return root;
    }

    private void populateShop() {
        ExploreViewModel exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        exploreViewModel.getProductsData().observe(getViewLifecycleOwner(), products -> {
            category1List.add(products);
            category1Adapter.notifyDataSetChanged();
        });
    }
}