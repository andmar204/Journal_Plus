package com.example.andre.journalplus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity
{
    Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appContext = getApplicationContext();


        final Button startJournBtn = findViewById(R.id.startJournalBtn);
        startJournBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addJournalIntent = new Intent(getApplicationContext(), JournalPage.class);

                startActivity(addJournalIntent); 
            }
        });
    }
}
