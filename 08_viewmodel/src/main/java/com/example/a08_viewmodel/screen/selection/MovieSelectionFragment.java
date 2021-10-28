package com.example.a08_viewmodel.screen.selection;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a08_viewmodel.R;
import com.example.a08_viewmodel.databinding.FragmentMovieSelectionBinding;
import com.example.a08_viewmodel.model.Movie;

import java.util.ArrayList;

public class MovieSelectionFragment extends Fragment {

    private FragmentMovieSelectionBinding binding;
    private MovieSelectionViewModel viewModel;

    public MovieSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_selection, container, false);

        viewModel = new ViewModelProvider(this).get(MovieSelectionViewModel.class);

        binding.setSelectionViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getEventSelectionDone().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean changed) {
                if (changed)
                    movieSelectionFinished();
            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    private void movieSelectionFinished() {
        Toast.makeText(this.getActivity(), "Movie selection done", Toast.LENGTH_SHORT).show();

        MovieSelectionFragmentDirections.ActionMovieSelectionToSummary action = MovieSelectionFragmentDirections.actionMovieSelectionToSummary();
        action.setNumberAnswered(viewModel.getNumberAnswered().getValue());
        action.setNumberSeen(viewModel.getNumberSeen().getValue());

        NavHostFragment.findNavController(this).navigate(action);

        viewModel.onSelectionDoneReset();
    }
}

