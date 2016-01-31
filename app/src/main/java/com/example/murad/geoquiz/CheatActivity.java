package com.example.murad.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private static final String TAG = "CheatActivity";

    private static final String KEY_CHEATING_SAVE = "cheating_save";
    public int mCheatingStatus = 0;

    //создаем ключ(константу) для определенния активити
    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.murad.geoquiz.answer_is_true";

    public static final String EXTRA_ANSWER_SHOWN =
            "com.example.murad.geoquiz.answwer_shown";

    //создаем переменную для ответа от QuizActivity
    private boolean mAnswerIsTrue;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mCheatingStatus = savedInstanceState.getInt(KEY_CHEATING_SAVE);
        }
        setContentView(R.layout.activity_cheat);
        Log.d(TAG, "onCreate   CheatActivity--------------------------------");
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);


        if (mCheatingStatus != 0) {
            if (mAnswerIsTrue) {
                mAnswerTextView.setText(R.string.true_button);
            } else {
                mAnswerTextView.setText(R.string.false_button);
            }
            setAnswerShownResult(true);
        } else {
            setAnswerShownResult(false);
        }

        Log.i(TAG, "mCheatingStatus----=====---" + mCheatingStatus);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
                mCheatingStatus = 1;
                Log.i(TAG, "mCheatingStatus----=====---" + mCheatingStatus);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()---------------------called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()---------------------called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()---------------------called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()---------------------called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()--------------------called");
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "savedInstanceState-------------вызвался");
        savedInstanceState.putInt(KEY_CHEATING_SAVE, mCheatingStatus);
    }
}
