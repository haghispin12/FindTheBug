package com.example.findthebug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FourthStage extends AppCompatActivity {

    private EditText etName,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        setContentView(R.layout.activity_fourth_stage);
        compareIntentAndSharedPref();

    }

    //compare between data in shared preferences and intent received
    // if not equal activity finished  and returns to previous
    private void compareIntentAndSharedPref()
    {
        Intent intent =getIntent();
        int age = intent.getIntExtra("age",0);
        String name=intent.getStringExtra("name");

        SharedPreferences sharedPreferences = this.getSharedPreferences("my_details",MODE_PRIVATE);

        int spAge = sharedPreferences.getInt("age",0);
        String spName = sharedPreferences.getString("name","");
        //if the are not equal finish
        if(age!= spAge || spName != name)
        {
            finish();
        }
        // else set the fields accordingly
        else
        {
            etAge.setText(age);
            etAge.setText(name);

        }

    }

    private void initViews()
    {

        etName=findViewById(R.id.etFourthName);
        etAge=findViewById(R.id.etFourthAge);

    }

    public void onClick(View view)
    {
        //TODO - implement here so you can move to fifth
    }
}