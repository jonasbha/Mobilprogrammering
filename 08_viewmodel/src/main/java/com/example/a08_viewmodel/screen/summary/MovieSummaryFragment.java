package com.example.a08_viewmodel.screen.summary;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.a08_viewmodel.R;
import com.example.a08_viewmodel.databinding.FragmentMovieSummaryBinding;
import com.example.a08_viewmodel.screen.selection.MovieSelectionViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieSummaryFragment extends Fragment {

    private MovieSummaryViewModel viewModel;

    public MovieSummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MovieSummaryFragmentArgs args = MovieSummaryFragmentArgs.fromBundle(getArguments());

        viewModel = new ViewModelProvider(this).get(MovieSummaryViewModel.class);
        viewModel.setNumberAnswered(args.getNumberAnswered());
        viewModel.setNumberSeen(args.getNumberSeen());

        FragmentMovieSummaryBinding binding = FragmentMovieSummaryBinding.inflate(getLayoutInflater());

        binding.numberSeenOfAnsweredText.setText(getString(R.string.number_seen_of_answered, viewModel.getNumberSeen(), viewModel.getNumberAnswered()));

        binding.progressBar.setMax(viewModel.getNumberAnswered());
        binding.progressBar.setProgress(viewModel.getNumberSeen());

        binding.tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.actionStartSelectionAgainFromSummary);
            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
