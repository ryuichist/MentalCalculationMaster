package com.mcm.rsun.mentalcalculationmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DifficultySelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void exit_or_start(View v){
        Intent intent;
        switch(v.getId()){
            case (R.id.select_difficulty_exit_button):
                intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case (R.id.select_difficulty_start_button):
                intent = new Intent(this, GameScreenActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void select_digit(View v){
        switch(v.getId()){
            case R.id.one_digit:
                GameScreenActivity.number_range = 10;
                break;
            case R.id.two_digit:
                GameScreenActivity.number_range = 100;
                break;
            case R.id.three_digit:
                GameScreenActivity.number_range = 1000;
                break;
        }
    }

    public void sign_selection(View v){

    }



}
