package com.example.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attempts to launch an activity within our own app
        Button secondActivity = (Button) findViewById(R.id.secondActivity);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                startIntent.putExtra("com.example.quicklauncher.SOMETHING","HELLO WORLD");
                //show how to pass info to another activity
                startActivity(startIntent);
            }
        });

        //Attempt to launch app outside our app
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google);
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW,webAddress);
                if(goToGoogle.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(goToGoogle);
                }

            }
        });
    }
}
