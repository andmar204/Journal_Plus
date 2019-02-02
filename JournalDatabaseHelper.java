package com.example.andre.journalplus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;

public class JournalDatabaseHelper extends SQLiteOpenHelper
{
    static final String databaseName = "journal.db";
    String tableName = "entry";
    static final int databaseVersion = 1;
    DateFormat colDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
    Date theDate = new Date();
    private String columnDate = colDateFormatter.format(theDate);

    DateFormat colTimeFormatter = new SimpleDateFormat("h:mm a");
    private String columnTime = colTimeFormatter.format(theDate);
    private String columnEntry;

    private String createTableStatement = "create table " + tableName + " ( " + columnDate + ", " +
            columnTime + ", " + columnEntry + " );";

    public JournalDatabaseHelper(Context context)
    {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
