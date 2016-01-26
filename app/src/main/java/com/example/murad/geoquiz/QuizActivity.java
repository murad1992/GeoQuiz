package com.example.murad.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;
    // Ключ для LogCat (константа)
    private static final String TAG = "QuizActivity";
    // Ключ пара = значение для сохранения в Bundle
    private static final String KEY_INDEX = "index";

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;

    private void updateQuestion() {
//Логирование с исключением
//Log.d(TAG, "Updating question text for  question:" + mCurrentIndex, new Exception());

        //Проверка на исключения выхода за границы массива
        try {
            mQuestionBank[mCurrentIndex].getQuestion();
        } catch (ArrayIndexOutOfBoundsException ex) {
            Log.e(TAG, "Index was out of bounds" + ex);
        }
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);

    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_tosat;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ////////////////////////////////////////////////////////////////////////////////////
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle)----------------вызвалось блеять");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        //находим кнопки и привызываем их к переменным типа Button
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this, R.string.correct_tosat, Toast.LENGTH_LONG).show();
                checkAnswer(true);
                Log.d(TAG, "Current question index:" + mCurrentIndex);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
                checkAnswer(false);
                Log.d(TAG, "Current question index:" + mCurrentIndex);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getQuestion();
//                mQuestionTextView.setText(question);
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                Log.d(TAG, "Current question index:" + mCurrentIndex);
            }
        });

        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                //включаем дополнения в интент
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,answerIsTrue);
                startActivity(i);
            }
        });

        //////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //Проверка наличия сохраненных данных в savedInstanceState
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();

        /////////////////////////////////////////////////////////////////////////////////////
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

    //Переопределение методода onSaveInstanceState при изменение конфигруации времени выполнения
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "savedInstanceState-------------вызвался");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }


}
