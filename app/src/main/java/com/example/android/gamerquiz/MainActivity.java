package com.example.android.gamerquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
         @Result = the score of quiz
         @parRes = parzial score of RadioBox question
    */

    int Result = 0;
    int parRes = 0;

    /*
        onRadioButtonClicked is a method that verify first question
    */

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio1:
                if (checked)
                    parRes = 0;
                    break;
            case R.id.radio2:
                if (checked)
                    parRes++;
                break;
        }
    }

    /*
         submit method verify the last three question and show the result of quiz
         @Finish = contain final message
         @namefield1 = contain answer of question 2
         @name1 = is a String for verify answer of question 2
         @namefield2 = contain answer of question 3
         @name2 = String for verify answer of question 3
         All Checkbox variable cotain one of the status of one checkbox
         All boolean variable cotain verify of checking of one checkbox
         @quantityTextView = is the text that reveal the score of the quiz
     */

    public void submit (View view) {

        String Finish;
        Result = parRes;

        EditText namefield1 = (EditText) findViewById(R.id.et_question2_Ratchet);
        String name1 = namefield1.getText().toString();
        if (name1.contentEquals("Ratchet")) Result++;

        EditText namefield2 = (EditText) findViewById(R.id.et_question3_Pikachu);
        String name2 = namefield2.getText().toString();
        if (name2.contentEquals("Pikachu")) Result++;

        CheckBox red = (CheckBox) findViewById(R.id.cb_question_4_option_1_red);
        boolean Red = red.isChecked();

        CheckBox yellow = (CheckBox) findViewById(R.id.cb_question_4_option_2_yellow);
        boolean Yellow = yellow.isChecked();

        CheckBox blue = (CheckBox) findViewById(R.id.cb_question_4_option_3_blue);
        boolean Blue = blue.isChecked();

        CheckBox black = (CheckBox) findViewById(R.id.cb_question_4_option_4_black);
        boolean Black = black.isChecked();

        if (Yellow==true && Red==true && Blue==true && Black==false) Result++;

        Context context = getApplicationContext();
        if(Result == 0) Finish = "Very Bad. Your Result is: " + Result;
        else if (Result == 1) Finish = "Bad. Your Result is: " + Result;
        else if (Result == 2) Finish = "Good. Your Result is: " + Result;
        else if (Result == 3) Finish = "Very Good. Your Result is: " + Result;
        else Finish = "Awasome. Your Result is: " + Result;
        CharSequence text = Finish;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Result = parRes;
    }
}
