package com.example.murad.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.murad.geoquiz.extra_answer_is_true";
    private boolean mAnswerIsTrue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
    }
}
