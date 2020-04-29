package com.NetliDev.Fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.NetliDev.Fragments.LoginViewModel;
import com.NetliDev.R;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;

    public LoginFragment() {
        // Required empty public constructor
        usernameEditText = getView().findViewById(R.id.username);
        passwordEditText = getView().findViewById(R.id.password);
        loginButton = getView().findViewById(R.id.login);
        loadingProgressBar = getView().findViewById(R.id.loading);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //    A ViewModel is scoped to a ViewModelStoreOwner. You can share data between the fragments
    //    by having a ViewModel scoped to the activity, which implements ViewModelStoreOwner.
    //    In the following example, requireActivity() resolves to MainActivity because MainActivity hosts ProfileFragment:
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        Toast.makeText(this.getContext(), "a" + LoginViewModel.class, Toast.LENGTH_SHORT).show();

        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.authenticate(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        viewModel.refuseAuthentication();
                        navController.popBackStack(R.id.main_fragment, false);
                    }
                });

        final NavController navController = Navigation.findNavController(view);
        final View root = view;
        viewModel.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(LoginViewModel.AuthenticationState authenticationState) {
                        switch (authenticationState) {
                            case AUTHENTICATED:
                                navController.popBackStack();
                                break;
                            case INVALID_AUTHENTICATION:
                                Snackbar.make(root,
                                        "invalid_credentials",
                                        Snackbar.LENGTH_SHORT
                                ).show();
                                break;
                        }
                    }
                });

        return view;

    }
}
