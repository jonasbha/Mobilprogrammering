package com.example.a04_fragments_and_navigationcomponent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        // Get the bundle with the arguments
        Bundle arguments = getArguments();

        // Checks if we actually get some arguments
        if (arguments != null) {
            // Retrieves a reference to the TextView
            TextView usernameTextView = view.findViewById(R.id.textViewUsername);

            // Retrieves the username from arguments with the help of the Safe Args generated file HomeFragmentArgs
            String username = HomeFragmentArgs.fromBundle(arguments).getUsername();

            // Sets the username
            usernameTextView.setText(username);
        }
    }
}