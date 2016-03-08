package com.mcm.rsun.mentalcalculationmaster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class GameScreenActivity extends AppCompatActivity {
    public static int user_result =0;
    public static int multiplier = 10;
    public static int num1;
    public static int num2;
    public static int correct_answer;
    public static int current_count = 0;
    public static int correct_count = 0;
    public static int difficulty_level = 0;
    public static int number_range = 10;
    public static final String PLUS = "+";
    public static final String MINUS = "-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        reset_count();
        generate_question();
    }

    public void clicked(View v){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        switch (v.getId()){
            case R.id.change_sign_btn:
                if(user_result != 0){
                    user_result *= -1;
                    user_result_view.setText(Integer.toString(user_result));
                }
                break;
            case R.id.change_sign_btn_2:
                if(user_result != 0){
                    user_result *= -1;
                    user_result_view.setText(Integer.toString(user_result));
                }
                break;
            case R.id.button1:
                user_result = user_result *10 + 1;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button2:
                user_result = user_result *10 + 2;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button3:
                user_result = user_result *10 + 3;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button4:
                user_result = user_result *10 + 4;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button5:
                user_result = user_result *10 + 5;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button6:
                user_result = user_result *10 + 6;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button7:
                user_result = user_result *10 + 7;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button8:
                user_result = user_result *10 + 8;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button9:
                user_result = user_result *10 + 9;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button0:
                if(user_result != 0){
                    user_result *=10;
                }
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button_reset:
                reset_input();
                break;
            case R.id.button_enter:
                user_result = Integer.parseInt(user_result_view.getText().toString());
                if(user_result == correct_answer){
                    System.out.println("CORRECT");
                    correct_count++;
                }else{
                    System.out.println("WRONG");
                }
                generate_question();
                break;
        }
    }


    public void generate_question(){
        System.out.println("current_count " + current_count + "~~~~~~~~~~~~~~~~~~~~~~~~~~" );
        if(current_count > DifficultySelectionActivity.max_problem_count){
            GridLayout keyboard = (GridLayout)findViewById(R.id.keyboard);
            keyboard.setClickable(false);
            System.out.println("1111111111111111111111111111");
        }else{
            reset_input();
            current_count++;
            TextView current_process = (TextView) findViewById(R.id.current_process);
            TextView correct_rate = (TextView) findViewById(R.id.correct_rate);
            current_process.setText(current_count + " / " + DifficultySelectionActivity.max_problem_count);
            correct_rate.setText(correct_count + " / " + DifficultySelectionActivity.max_problem_count);

            Random r = new Random();
            num1 = r.nextInt(number_range);
            num2 = r.nextInt(number_range);
            TextView num1_view = (TextView) findViewById(R.id.num1);
            TextView num2_view = (TextView) findViewById(R.id.num2);
            num1_view.setText(Integer.toString(num1));
            num2_view.setText(Integer.toString(num2));

            TextView sign = (TextView)findViewById(R.id.sign);
            switch(DifficultySelectionActivity.sign){
                case 1:
                    correct_answer = num1+num2;
                    sign.setText(PLUS);
                    break;
                case 2:
                    correct_answer = num1-num2;
                    sign.setText(MINUS);
                    break;
                case 3:
                    int s = r.nextInt(2);
                    if(s == 0){
                        correct_answer = num1+num2;
                        sign.setText(PLUS);
                    }else{
                        correct_answer = num1-num2;
                        sign.setText(MINUS);
                    }
                    break;
            }
        }
    }

    public void reset_input(){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        user_result = 0;
        user_result_view.setText("");
    }

    public void reset_count(){
        current_count = 0;
        correct_count = 0;
    }

    public void exit_clicked(View v) {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }


}
