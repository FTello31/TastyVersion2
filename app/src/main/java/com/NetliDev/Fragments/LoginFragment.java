package com.NetliDev.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.NetliDev.Fragments.LoginViewModel;
import com.NetliDev.R;
import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Switch switchRemember;
    private ProgressBar loadingProgressBar;
    private SharedPreferences sharedPref;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    //    A ViewModel is scoped to a ViewModelStoreOwner. You can share data between the fragments
    //    by having a ViewModel scoped to the activity, which implements ViewModelStoreOwner.
    //    In the following example, requireActivity() resolves to MainActivity because MainActivity hosts ProfileFragment:
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        final NavController navController = Navigation.findNavController(view);
        final View root = view;

        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);
        loadingProgressBar = view.findViewById(R.id.loading);
        switchRemember = view.findViewById(R.id.switchRemember);

        sharedPref = getActivity().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
        setPreferencesIfExist();

        loginButton = view.findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                viewModel.authenticate(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());

            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        // is not the appbar arrow back is the black one in the bottom of the screen
                        viewModel.refuseAuthentication();
                        Toast.makeText(getContext(), "popBackStack main_fragment", Toast.LENGTH_LONG).show();
                        navController.popBackStack(R.id.home, false);
                    }
                });


        viewModel.authenticationState.observe(getViewLifecycleOwner(),
                new Observer<LoginViewModel.AuthenticationState>() {
                    @Override
                    public void onChanged(LoginViewModel.AuthenticationState authenticationState) {
                        switch (authenticationState) {
                            case AUTHENTICATED:
                                loadingProgressBar.setVisibility(View.GONE);
                                saveSharedPreferences(usernameEditText.getText().toString(),passwordEditText.getText().toString());
                                navController.popBackStack(); // si es autenticado vuelve a home
                                Toast.makeText(getContext(), "AUTHENTICATED", Toast.LENGTH_SHORT).show();
                                break;
                            case INVALID_AUTHENTICATION:
                                loadingProgressBar.setVisibility(View.GONE);
                                Snackbar.make(root,
                                        "R.string.invalid_credentials",
                                        Snackbar.LENGTH_SHORT
                                ).show();
                                break;
                        }
                    }
                });
    }

    private void setPreferencesIfExist() {
        String email = sharedPref.getString("email", "");
        String pass = sharedPref.getString("pass", "");

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {
            usernameEditText.setText(email);
            passwordEditText.setText(pass);
        }

    }

    private void saveSharedPreferences(String email, String pass) {
        if (switchRemember.isChecked()) {

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("email", email);
            editor.putString("pass", pass);
            // si pongo editor.commit(); solo pasaria a la siguinete linea cuando
            // todo lo anterior se haya ejecutado, es decir cuando se haya guardado todo

            //si pongo solo
            editor.apply();
            // es una accion asincrona, porque se va guardando en segundo plano

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
}
