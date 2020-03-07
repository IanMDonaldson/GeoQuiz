package com.bignerdranch.android.geoquiz.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.model.Quiz;
import com.bignerdranch.android.geoquiz.presenter.QuizPresenter;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TextView mResultTextView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mQuestionTextView = findViewById(R.id.question_text_view);
        mResultTextView = findViewById(R.id.result_text_view);
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mNextButton = findViewById(R.id.next_button);
        int green = getResources().getColor(R.color.green);
        int red = getResources().getColor(R.color.red);
        QuizView quizView = new QuizView(mQuestionTextView, mResultTextView, mTrueButton, mFalseButton, mNextButton);
        QuizPresenter quizPresenter = new QuizPresenter(quizView);

        mTrueButton.setOnClickListener(new trueFalseClickListener(quizPresenter, true, green, red));


        mFalseButton.setOnClickListener(new trueFalseClickListener(quizPresenter, false, green, red));

        mNextButton.setOnClickListener(new nextBtnClickListener(quizView, quizPresenter));

        Quiz quiz = quizPresenter.getQuiz();
        quizView.updateQuestionView(quizPresenter);
        quizView.reset();
    }

    /*private void checkAnswer(boolean userPressedTrue) {
        int answerColor;
        boolean answerIsTrue = quiz.getCurrentQuestion().isAnswerTrue();
        int messageResId;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            answerColor = getResources().getColor(R.color.green);
        } else {
            messageResId = R.string.incorrect_toast;
            answerColor = getResources().getColor(R.color.red);
        }

        mResultTextView.setText(messageResId);
        mResultTextView.setTextColor(answerColor);
        onQuestionAnswered();
    }*/
}

