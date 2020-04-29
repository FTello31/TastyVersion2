package com.NetliDev.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.NetliDev.R;
import com.NetliDev.RecyclerViewHome.HomeAdapter;


public class HomeFragment extends Fragment {
    private LoginViewModel viewModel;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private HomeAdapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setUpRecyclerView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new HomeAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }

    // TODO Move the logic to MAIN ACTIVITY
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

        final NavController navController = Navigation.findNavController(view);
        viewModel.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(LoginViewModel.AuthenticationState authenticationState) {
                        switch (authenticationState) {
                            case AUTHENTICATED:
//                                showWelcomeMessage();
//                                Toast.makeText(getContext(), "HOME FRAGMENT AUHTENTICATED", Toast.LENGTH_SHORT).show();
                                break;
                            case UNAUTHENTICATED:
                                Toast.makeText(getContext(), "HOME FRAGMENT UNAUTHENTICATED", Toast.LENGTH_SHORT).show();
                                navController.navigate(R.id.action_global_loginFragment);
                                break;
                            case INVALID_AUTHENTICATION:
                                Toast.makeText(getContext(), "HOME FRAGMENT INVALID_AUTHENTICATION", Toast.LENGTH_SHORT).show();
                                navController.navigate(R.id.action_global_loginFragment);
                                break;
                        }
                    }
                });

    }
}
