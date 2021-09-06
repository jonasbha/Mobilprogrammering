package com.example.a02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this::navigateToOtherActivity);

        text = findViewById(R.id.editText);

    }

    private void navigateToOtherActivity(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra(EXTRA_MESSAGE, text.getText().toString());
        startActivity(intent);
    }
}