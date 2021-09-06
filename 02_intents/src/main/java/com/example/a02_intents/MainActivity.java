package com.example.a02_intents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private void navigateToOtherActivity(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        intent.putExtra(EXTRA_MESSAGE, text.getText().toString());
        mStartForResult.launch(intent);
    }

    ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    // Handle the Intent
                    TextView tV = findViewById(R.id.responseView);
                    if (intent != null) {
                        tV.setText(intent.getStringExtra(OtherActivity.EXTRA_REPLY));
                    }
                }
            });

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
}