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
import com.example.inuapp.ui.explore.adapters.ExploreRv;

import java.util.LinkedList;

import static com.example.inuapp.models.Products.COMPUTING;
import static com.example.inuapp.models.Products.ELECTRONICS;
import static com.example.inuapp.models.Products.FASHION;
import static com.example.inuapp.models.Products.GAMING;
import static com.example.inuapp.models.Products.HOME;
import static com.example.inuapp.models.Products.SPORTING;

public class ExploreFragment extends Fragment {

    private LinkedList<Products> electronicList, homeList, gamingList, fashionList, computingList, sportingList;
    private ExploreRv electronicsAdapter, homeAdapter, gamingAdapter, fashionAdapter, computingAdapter, sportingAdapter;
    private ExploreViewModel exploreViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_explore, container, false);

        //Electronics
        RecyclerView electronicsRv = root.findViewById(R.id.electronicsRv);
        electronicsRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        electronicList = new LinkedList<>();
        electronicsAdapter = new ExploreRv(requireContext(), electronicList);
        electronicsRv.setAdapter(electronicsAdapter);

        //Home
        RecyclerView homeRv = root.findViewById(R.id.homeRv);
        homeRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        homeList = new LinkedList<>();
        homeAdapter = new ExploreRv(requireContext(), homeList);
        homeRv.setAdapter(homeAdapter);

        //Gaming
        RecyclerView gamingRv = root.findViewById(R.id.gamingRv);
        gamingRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        gamingList = new LinkedList<>();
        gamingAdapter = new ExploreRv(requireContext(), gamingList);
        gamingRv.setAdapter(gamingAdapter);

        //Fashion
        RecyclerView fashionRv = root.findViewById(R.id.fashionRv);
        fashionRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        fashionList = new LinkedList<>();
        fashionAdapter = new ExploreRv(requireContext(), fashionList);
        fashionRv.setAdapter(fashionAdapter);

        //Computing
        RecyclerView computingRv = root.findViewById(R.id.computingRv);
        computingRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        computingList = new LinkedList<>();
        computingAdapter = new ExploreRv(requireContext(), computingList);
        computingRv.setAdapter(computingAdapter);

        //Sporting
        RecyclerView sportingRv = root.findViewById(R.id.sportingRv);
        sportingRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        sportingList = new LinkedList<>();
        sportingAdapter = new ExploreRv(requireContext(), sportingList);
        sportingRv.setAdapter(sportingAdapter);

        populateShop();

        return root;
    }

    private void populateShop() {
        exploreViewModel.getProductsData().observe(getViewLifecycleOwner(), products -> {
            switch (products.getProductCategory()) {
                default:
                    break;
                case ELECTRONICS:
                    electronicList.add(products);
                    electronicsAdapter.notifyDataSetChanged();
                    break;

                case HOME:
                    homeList.add(products);
                    homeAdapter.notifyDataSetChanged();
                    break;

                case GAMING:
                    gamingList.add(products);
                    gamingAdapter.notifyDataSetChanged();
                    break;

                case FASHION:
                    fashionList.add(products);
                    fashionAdapter.notifyDataSetChanged();
                    break;

                case COMPUTING:
                    computingList.add(products);
                    computingAdapter.notifyDataSetChanged();
                    break;

                case SPORTING:
                    sportingList.add(products);
                    sportingAdapter.notifyDataSetChanged();
                    break;
            }
        });
    }
}