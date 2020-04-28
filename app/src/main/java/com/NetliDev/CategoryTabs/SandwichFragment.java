package com.NetliDev.CategoryTabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.NetliDev.Beans.Food;
import com.NetliDev.R;
import com.NetliDev.RecyclerViewCategory.CategoryAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SandwichFragment extends Fragment {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private CategoryAdapter adapter;

    public SandwichFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sandwich, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoryAdapter(Food.SANDWICHES);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
