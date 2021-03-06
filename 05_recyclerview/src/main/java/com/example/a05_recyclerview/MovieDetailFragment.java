package com.example.a05_recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a05_recyclerview.model.Movie;

public class MovieDetailFragment extends Fragment {


    public MovieDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Creates a MovieDetailFragmentArgs based on the bundle
        MovieDetailFragmentArgs arguments = MovieDetailFragmentArgs.fromBundle(getArguments());

        // Retreived the uid for the movie that's going to be displayed
        int movieUid = arguments.getUid();

        // Gets the movie with the uid (just a number in the list in this case)
        Movie movie = Movie.getMovies().get(movieUid);

        // Gets a reference to all the views
        TextView movieTitleTextView = view.findViewById(R.id.movieTitleTV);
        ImageView moviePosterImageView = view.findViewById(R.id.moviePosterIV);
        TextView movieDescriptionTextView = view.findViewById(R.id.movieDescTV);

        // Filles up the views with the movie-information
        movieTitleTextView.setText(movie.getTitle());
        moviePosterImageView.setImageResource(movie.getPosterUrl());
        movieDescriptionTextView.setText(movie.getDescription());
    }
}