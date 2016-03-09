package com.mcm.rsun.mentalcalculationmaster;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    public static int current_count = 0;
    public static int correct_count = 0;
    public static int difficulty_level = 0;
    public static int number_range = 10;
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static int sign = 1;
    public static boolean game_over = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        reset_game_data();
        initialize_screen();
        generate_question();
    }

    public void keyboard_clicked(View v){
        if(game_over){
            return;
        }
        check_sign(v);
        update_user_input(v);
        reset_or_enter(v);
    }
    public void check_sign(View v){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        if(v.getId() == R.id.change_sign_btn || v.getId() == R.id.change_sign_btn_2){
            sign *= -1;
            user_result *= -1;
            if(user_result == 0){
                switch(sign){
                    case 1:
                        user_result_view.setText("");
                        break;
                    case -1:
                        user_result_view.setText("-");
                        break;
                }
            }else{
                user_result_view.setText(Integer.toString(user_result));
            }
            
        }
    }

    public void update_user_input(View v){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        switch (v.getId()) {
            case R.id.button1:
                user_result = (user_result * 10 + 1) * sign;
                break;
            case R.id.button2:
                user_result = (user_result * 10 + 2) * sign;
                break;
            case R.id.button3:
                user_result = (user_result * 10 + 3) * sign;
                break;
            case R.id.button4:
                user_result = (user_result * 10 + 4) * sign;
                break;
            case R.id.button5:
                user_result = (user_result * 10 + 5) * sign;
                break;
            case R.id.button6:
                user_result = (user_result * 10 + 6) * sign;
                break;
            case R.id.button7:
                user_result = (user_result * 10 + 7) * sign;
                break;
            case R.id.button8:
                user_result = (user_result * 10 + 8) * sign;
                break;
            case R.id.button9:
                user_result = (user_result * 10 + 9) * sign;
                break;
            case R.id.button0:
                if (user_result != 0) {
                    user_result *= 10;
                }
                break;
        }
        user_result_view.setText(Integer.toString(user_result));
    }

    public void reset_or_enter(View v){
        switch (v.getId()){
            case R.id.button_reset:
                reset_input();
                break;
            case R.id.button_enter:
                judge_answer();
                if(current_count < DifficultySelectionActivity.max_problem_count){
                    generate_question();
                }else{
                    game_over = true;
                }
//                System.out.println("current_count " + current_count + "~~~~~~~~~~~~~~~~~~~~~~~~~~" );
                break;
        }
    }

    public void initialize_screen(){
        TextView current_process = (TextView) findViewById(R.id.current_process);
        current_process.setText(0 + " / " + DifficultySelectionActivity.max_problem_count);

        TextView correct_rate = (TextView) findViewById(R.id.correct_rate);
        correct_rate.setText(0 + " / " + DifficultySelectionActivity.max_problem_count);
    }

    public void generate_question(){
        sign = 1;
        reset_input();
        current_count++;
        TextView current_process = (TextView) findViewById(R.id.current_process);
        current_process.setText(current_count + " / " + DifficultySelectionActivity.max_problem_count);

        //generate numbers
        Random r = new Random();
        num1 = r.nextInt(number_range);
        num2 = r.nextInt(number_range);

        //display numbers
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

    public void judge_answer(){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        TextView correct_rate = (TextView) findViewById(R.id.correct_rate);
        user_result = Integer.parseInt(user_result_view.getText().toString());
            if(user_result == correct_answer){
                System.out.println("CORRECT");
                correct_count++;
                correct_rate.setText(correct_count + " / " + DifficultySelectionActivity.max_problem_count);
            }else{
                System.out.println("WRONG");
            }
    }

    public void reset_input(){
        EditText user_result_view = (EditText)findViewById(R.id.user_result);
        user_result = 0;
        user_result_view.setText("");
    }

    public void reset_game_data(){
        current_count = 0;
        correct_count = 0;
        game_over = false;
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
