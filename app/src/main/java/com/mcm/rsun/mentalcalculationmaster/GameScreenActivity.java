package com.mcm.rsun.mentalcalculationmaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameScreenActivity extends AppCompatActivity {
    public static int user_result =0;
    public static int multiplier = 10;
    public static int num1;
    public static int num2;
    public static int correct_answer;
    public static final int MAX_PROBLEM_COUNT = 5;
    public static int current_count = 0;
    public static int correct_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        generate_question();
    }

    public void clicked(View v){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        switch (v.getId()){
            case R.id.button1:
//                System.out.println("1 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 1;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button2:
//                System.out.println("2 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 2;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button3:
//                System.out.println("3 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 3;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button4:
//                System.out.println("4 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 4;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button5:
//                System.out.println("5 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 5;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button6:
//                System.out.println("6 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 6;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button7:
//                System.out.println("7 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 7;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button8:
//                System.out.println("8 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 8;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button9:
//                System.out.println("9 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = user_result *10 + 9;
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button0:
//                System.out.println("0 clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                if(user_result != 0){
                    user_result *=10;
                }
                user_result_view.setText(Integer.toString(user_result));
                break;
            case R.id.button_reset:
//                System.out.println("reset clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                reset_input();
                break;
            case R.id.button_enter:
//                System.out.println("enter clicked!!!!!!!!!!!!!!>>>>>>>>>>>>>>");
                user_result = Integer.parseInt(user_result_view.getText().toString());
                System.out.println("user input " + user_result);
                if(user_result == correct_answer){
                    System.out.println("CORRECT");
                    correct_count++;
                }else{
                    System.out.println("WRONG");
                }
                generate_question();
                break;
        }
//        System.out.println("current value = " + user_result + "////////////////");
    }


    public void generate_question(){
        current_count++;
        TextView current_process = (TextView) findViewById(R.id.current_process);
        TextView correct_rate = (TextView) findViewById(R.id.correct_rate);
        current_process.setText(current_count + " / " + MAX_PROBLEM_COUNT);
        correct_rate.setText(correct_count + " / " + MAX_PROBLEM_COUNT);
        reset_input();
        Random r = new Random();
        num1 = r.nextInt(10);
        num2 = r.nextInt(10);
        TextView num1_view = (TextView) findViewById(R.id.num1);
        TextView num2_view = (TextView) findViewById(R.id.num2);
        num1_view.setText(Integer.toString(num1));
        num2_view.setText(Integer.toString(num2));
        correct_answer = num1+num2;
    }

    public void reset_input(){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        user_result = 0;
        user_result_view.setText("");
    }
}
