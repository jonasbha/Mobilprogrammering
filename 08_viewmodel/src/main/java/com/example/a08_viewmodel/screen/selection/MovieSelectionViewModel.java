package com.example.a08_viewmodel.screen.selection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a08_viewmodel.model.Movie;

import java.util.ArrayList;

public class MovieSelectionViewModel extends ViewModel {

    private MutableLiveData<Movie> currentMovie = new MutableLiveData<>();

    private MutableLiveData<Integer> numberAnswered = new MutableLiveData<>();
    private MutableLiveData<Integer> numberSeen = new MutableLiveData<>();

    private ArrayList<Movie> movieList;

    private MutableLiveData<Boolean> eventSelectionDone = new MutableLiveData<>();

    public MovieSelectionViewModel() {
        numberAnswered.setValue(0);
        numberSeen.setValue(0);
        eventSelectionDone.setValue(false);
        retrieveMovieList();
        nextMovie();
    }

    private void nextMovie() {
        if (!movieList.isEmpty()) {
            currentMovie.setValue(movieList.remove(0));
        }
        else
            onSelectionDone();
    }

    private void retrieveMovieList() {
        movieList = Movie.getMovies();
    }

    public void seenMovie() {
        numberSeen.setValue(numberSeen.getValue()+1);
        numberAnswered.setValue(numberAnswered.getValue()+1);
        nextMovie();
    }

    public void notSeenMovie() {
        numberAnswered.setValue(numberAnswered.getValue()+1);
        nextMovie();
    }

    /** Method for when we are done with the selection **/
    public void onSelectionDone() {
        eventSelectionDone.setValue(true);
    }

    public void onSelectionDoneReset() {
        eventSelectionDone.setValue(false);
    }

    public LiveData<Movie> getCurrentMovie() {
        return currentMovie;
    }

    public LiveData<Integer> getNumberSeen() {
        return numberSeen;
    }

    public LiveData<Integer> getNumberAnswered() {
        return numberAnswered;
    }

    public LiveData<Boolean> getEventSelectionDone() { return eventSelectionDone; }
}
