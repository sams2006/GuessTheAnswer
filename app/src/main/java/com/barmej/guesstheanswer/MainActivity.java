package com.barmej.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final boolean[] ANSWERS = {
            false,
            true,
            true,
            false,
            true,
            false,
            true,
            true,
            false,
            true,
            false,
            false,
            true
    };
    private String[] QUESTIONS;
    private String[] ANSWERS_DETAILS;

    TextView mTextViewQuestion;
    private String mCurrentQuestion, mCurrentAnswerDetails;
    private boolean mCurrentAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QUESTIONS = getResources().getStringArray(R.array.questions);
        ANSWERS_DETAILS = getResources().getStringArray(R.array.answers_details);

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
            Toast.makeText(this, getString(R.string.true_text), Toast.LENGTH_SHORT).show();
            showNewQuestion();
        } else {
            Toast.makeText(this, getString(R.string.false_text), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AnswerActivity.class);
            intent.putExtra("question_answer", mCurrentAnswerDetails);
            startActivity(intent);
        }
    }

    public void onFalseClicked(View view) {
        if (mCurrentAnswer == false) {
            Toast.makeText(this, getString(R.string.true_text), Toast.LENGTH_SHORT).show();
            showNewQuestion();
        } else {
            Toast.makeText(this, getString(R.string.false_text), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AnswerActivity.class);
            intent.putExtra("question_answer", mCurrentAnswerDetails);
            startActivity(intent);
        }
    }

    public void onShareQuestionClicked(View view) {
        Intent intent = new Intent(MainActivity.this, ShareActivity.class);
        intent.putExtra("question text extra", mCurrentQuestion);
        startActivity(intent);
    }
}