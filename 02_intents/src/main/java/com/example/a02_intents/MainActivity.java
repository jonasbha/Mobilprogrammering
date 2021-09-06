package com.example.a02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

        Button sendBtn = findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this::navigateToOtherActivity);

        Button webBtn = findViewById(R.id.webBtn);
        webBtn.setOnClickListener(this::navigateToWebcontent);

        findViewById(R.id.geoBtn).setOnClickListener(this::navigateToGeoLocation);

        text = findViewById(R.id.editText);

    }

    private void navigateToGeoLocation(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:59.128708,11.353176"));
        startActivity(i);
    }

    private void navigateToWebcontent(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.no/?gws_rd=ssl"));
        startActivity(i);
    }

    private void navigateToOtherActivity(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra(EXTRA_MESSAGE, text.getText().toString());
        startActivity(intent);
    }
}