package com.example.a04_fragments_and_navigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn = view.findViewById(R.id.loginBtn);

        btn.setOnClickListener(nextView -> {
            EditText editTextUsername = view.findViewById(R.id.editTextUsername);
            EditText editTextPassword = view.findViewById(R.id.editTextPassword);

            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (!username.isEmpty() && !password.isEmpty()) {
                // Gets a reference to the navController
                NavController navController = Navigation.findNavController(view);

                // Creates the action we want to perform
                LoginFragmentDirections.ActionLoginFragmentToHomeFragment action = LoginFragmentDirections.actionLoginFragmentToHomeFragment();

                // Insert the arguments we want to send
                action.setUsername(username);

                // Navigates to the HomeFragment
                navController.navigate(action);
            } else Toast.makeText(view.getContext(), "Invalid credentials", Toast.LENGTH_LONG).show();
        });
    }
}