package com.example.a05_recyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a05_recyclerview.adapter.MovieRecyclerAdapter;
import com.example.a05_recyclerview.model.Movie;

import java.util.ArrayList;


public class MovieListFragment extends Fragment {

    private ArrayList<Movie> movieList;
    private RecyclerView movieRecyclerView;

    public MovieListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        movieList = Movie.getMovies();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieRecyclerView = view.findViewById(R.id.movieRecyclerView);

        movieRecyclerView.setAdapter(new MovieRecyclerAdapter(view.getContext(), movieList, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets the position of the item that's clicked
                int position = movieRecyclerView.getChildAdapterPosition(view);

                // Gets the movie based on which item got clicked
                Movie clickedMovie = movieList.get(position);

                // Creates the navigation action, including the uid argument
                NavDirections action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(clickedMovie.getUid());

                // Calls the navigat action, taking us to the MovieDetailFragment
                Navigation.findNavController(view).navigate(action);

                // Creates a toast with the movie that got clicked
                Toast.makeText(view.getContext(), clickedMovie.getTitle() + " clicked", Toast.LENGTH_LONG).show();
            }
        }));

        // Sets the layoutmanager we want to use
        movieRecyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 1));
        //movieRecyclerView.layoutManager = GridLayoutManager(context, 2)
        //movieRecyclerView.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        //movieRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        //movieRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        //movieRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }
}