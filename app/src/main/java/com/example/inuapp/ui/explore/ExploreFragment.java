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
import com.example.inuapp.ui.explore.adapters.Category1RvAdapter;

import java.util.LinkedList;

public class ExploreFragment extends Fragment {

    private final LinkedList<String> category1List = new LinkedList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ExploreViewModel exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);

        View root = inflater.inflate(R.layout.fragment_explore, container, false);

        RecyclerView category1Grid = root.findViewById(R.id.category1Grid);
        category1Grid.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        category1List.add("");
        category1List.add("");
        category1List.add("");
        Category1RvAdapter category1Adapter = new Category1RvAdapter(requireContext(), category1List);
        category1Grid.setAdapter(category1Adapter);

        return root;
    }
}