package com.barmej.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String[] QUESTIONS = {
            "العملة الرسمية لدولة الكويت هي الريال الكويتي ؟",
            "توبقال هي أعلى قمة جبلية في الوطن العربي ؟",
            "الجزائر هي أكبر دولة عربية من حيث المساحة ؟",
            "الدار البيضاء هي عاصمة المغرب ؟"
    };
    private static final boolean[] ANSWERS = {
            false,
            true,
            true,
            false
    };
    private static final String[] ANSWERS_DETAILS = {
            "العملة الرسمية لدولة الكويت هي الدينار الكويتي ",
            "توبقال هي أعلى قمة جبلية في الوطن العربي",
            "الجزائر هي أكبر دولة عربية من حيث المساحة ",
            "الرباط هي عاصمة المغرب "
    };
    TextView mTextViewQuestion;
    private String mCurrentQuestion, mCurrentAnswerDetails;
    private boolean mCurrentAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewQuestion = findViewById(R.id.text_view_question);
        showNewQuestion();

    }

    private void showNewQuestion() {
        Random random = new Random();
        int randomQuestionIndex = random.nextInt(QUESTIONS.length);
        mCurrentQuestion = QUESTIONS[randomQuestionIndex];
        mCurrentAnswer = ANSWERS[randomQuestionIndex];
        mCurrentAnswerDetails = ANSWERS_DETAILS[randomQuestionIndex];
        mTextViewQuestion.setText(mCurrentQuestion);
    }

    public void onChangeQuestionClicked(View view) {
        showNewQuestion();
    }

    public void onTrueClicked(View view) {
        if (mCurrentAnswer == true) {
            Toast.makeText(this, "إجابة صحيحة", Toast.LENGTH_SHORT).show();
            showNewQuestion();
        } else {
            Toast.makeText(this, "إجابة خاطئة", Toast.LENGTH_SHORT).show();
        }
    }

    public void onFalseClicked(View view) {
        if (mCurrentAnswer == false) {
            Toast.makeText(this, "إجابة صحيحة", Toast.LENGTH_SHORT).show();
            showNewQuestion();
        } else {
            Toast.makeText(this, "إجابة خاطئة", Toast.LENGTH_SHORT).show();
        }
    }
}