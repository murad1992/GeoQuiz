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

    public static final String TAG ="CheatActivity";

    //создаем ключ(константу) для определенния активити
    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.example.murad.geoquiz.answer_is_true";

    public static final String EXTRA_ANSWER_SHOWN =
            "com.example.murad.geoquiz.answwer_shown";

    //создаем переменную для ответа от QuizActivity
    private boolean mAnswerIsTrue;

    private void setAnswerShownResult (boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Log.d(TAG, "onCreate   CheatActivity--------------------------------");
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        setAnswerShownResult(false);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
            if(mAnswerIsTrue){
                mAnswerTextView.setText(R.string.true_button);
            }else{
                mAnswerTextView.setText(R.string.false_button);
            }
            setAnswerShownResult(true);
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
}
