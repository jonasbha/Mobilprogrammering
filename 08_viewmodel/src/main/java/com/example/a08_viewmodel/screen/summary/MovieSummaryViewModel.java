package com.example.a08_viewmodel.screen.summary;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MovieSummaryViewModel extends ViewModel {
    private int numberAnswered = 0;
    private int numberSeen = 0;

    public MovieSummaryViewModel() {
        Log.i("SummaryViewModel", "SummaryViewModel created");
    }

    public int getNumberAnswered() {
        return numberAnswered;
    }

    public void setNumberAnswered(int numberAnswered) {
        this.numberAnswered = numberAnswered;
    }

    public int getNumberSeen() {
        return numberSeen;
    }

    public void setNumberSeen(int numberSeen) {
        this.numberSeen = numberSeen;
    }
}
