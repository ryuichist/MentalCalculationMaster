package com.mcm.rsun.mentalcalculationmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DifficultySelectionActivity extends AppCompatActivity {
    public static int max_problem_count = 10;
    public static int sign = 1;

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
        TextView digit_selection_note = (TextView)findViewById(R.id.digit_selection_note);

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

    public void select_sign(View v){
        switch(v.getId()){
            case R.id.add_only:
                sign = 1;
                break;
            case R.id.subs_only:
                sign = 2;
                break;
            case R.id.add_subs:
                sign = 3;
                break;
        }
    }

    public void select_problem_count(View v){
        switch(v.getId()){
            case R.id.count_10:
                max_problem_count=10;
                break;
            case R.id.count_20:
                max_problem_count=20;
                break;
            case R.id.count_30:
                max_problem_count=30;
                break;
        }
    }



}
