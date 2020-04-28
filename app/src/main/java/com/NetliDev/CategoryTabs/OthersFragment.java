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
public class OthersFragment extends Fragment {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private CategoryAdapter adapter;

    public OthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_others, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoryAdapter(Food.VARIOS);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
