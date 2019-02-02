package com.example.andre.journalplus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JournalPage extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal_page_layout);
        final Button saveEntryButton = findViewById(R.id.saveEntryBtn);

        /*SET THE VALUE OF THE CURRENT DATE FOR THE DATE WIDGET ON THE UPPER LEFT*/
        final TextView dateTV = findViewById(R.id.dateTextView);
        DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        String currentDateStr = dateFormatter.format(currentDate);
        dateTV.setText(currentDateStr);

        /*SET THE VALUE OF THE CURRENT TIME FOR THE TIME WIDGET ON THE UPPER RIGHT
        * (I had to do some minor math to make sure the time wouldn't come out in military
        * time or like "05:36". I want it to look like "5:36". I type that as I'm coding this
        * at 5:36 AM after a whole night of not sleeping. I can really use a hot cup of Joe...)
        * 9:13 AM update: I realized that using "HH:mm" is ridiculous. As I can just use "hh:mm a"
        * to do all the math work I did for me!
        * 9:16 AM update: Using "hh:mm a" is ridiculous, since I can use "h:mm a" and not even have
        * to worry about zeroes being in front of my time, like I mentioned earlier. */
        final TextView timeTV = findViewById(R.id.timeTextView);
        DateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        Date currentTime = new Date();
        String currentTimeStr = timeFormatter.format(currentTime);
        Toast.makeText(getApplicationContext(), currentTimeStr, Toast.LENGTH_LONG).show();
        timeTV.setText(currentTimeStr);

        saveEntryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = getIntent();
            }
        });

        final Button clearEntryButton = findViewById(R.id.clearEntryBtn);
        final EditText entryBodyET = findViewById(R.id.entryBodyEditText);

        clearEntryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                entryBodyET.setText("");
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
