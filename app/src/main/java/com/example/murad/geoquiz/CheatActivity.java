package com.example.murad.geoquiz;

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
    //создаем переменную для ответа от QuizActivity
    private boolean mAnswerIsTrue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Log.d(TAG, "Start CheatActivity--------------------------------");
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
            if(mAnswerIsTrue){
                mAnswerTextView.setText(R.string.true_button);
            }else{
                mAnswerTextView.setText(R.string.false_button);
            }
        }
        });

    }
}
