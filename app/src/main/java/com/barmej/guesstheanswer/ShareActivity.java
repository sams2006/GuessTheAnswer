package com.barmej.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {

    public EditText mEditTextShareTitle;
    private String mQuestionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mEditTextShareTitle = findViewById(R.id.edit_text_share_title);
        mQuestionText = getIntent().getStringExtra(Constants.QUESTION_TEXT_EXTRA);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.APP_PREF, MODE_PRIVATE);
        String questionTitle = sharedPreferences.getString(Constants.SHARE_TITLE, "");
        mEditTextShareTitle.setText(questionTitle);
    }

    public void onShareQuestionClicked(View view) {

        String questionTitle = mEditTextShareTitle.getText().toString();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, questionTitle + "\n" + mQuestionText);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.APP_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.SHARE_TITLE, questionTitle);
        editor.apply();

    }
}