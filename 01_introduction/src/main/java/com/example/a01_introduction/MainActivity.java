package com.example.a01_introduction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Override the onStart() ActivityLifecycle event and add logging
 (Ctrl + O - Override shortcut, android.util.Log - Logger)
 * Override the onResume() ActivityLifecycle event and add logging
 * Override the onPause() ActivityLifecycle event and add logging
 * Override the onStop() ActivityLifecycle event and add logging
 * Override the onRestart() ActivityLifecycle event and add logging
 * Override the onDestroy() ActivityLifecycle event and add logging
 * Create OtherActivity.java with the "New->Activity->Empty activity" dropdown menu
 * Add a TextView to OtherActivity with the text "Hello Android!"
 * Add a navigateToOtherActivity(View view), method for a button-click
 * Create an Intent to start OtherActivity in the navigate... method
 * Start OtherActivity with the intent
 * */

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this::navigateToOtherActivity);

    }

    public void navigateToOtherActivity(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart() ran.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume() ran.");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause() ran.");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop() ran.");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart() ran.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy() ran.");
    }
}