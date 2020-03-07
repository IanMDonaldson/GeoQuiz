package com.bignerdranch.android.geoquiz.view;

import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.android.geoquiz.presenter.QuizPresenter;

public class QuizView implements IfaceView {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TextView mResultTextView;

    public Button getmTrueButton() {
        return mTrueButton;
    }

    public Button getmFalseButton() {
        return mFalseButton;
    }

    public Button getmNextButton() {
        return mNextButton;
    }

    public TextView getmResultTextView() {
        return mResultTextView;
    }

    public TextView getmQuestionTextView() {
        return mQuestionTextView;
    }

    public QuizView(TextView mQuestionTextView, TextView mResultTextView,
                    Button mTrueButton, Button mFalseButton, Button mNextButton) {
        this.mQuestionTextView = mQuestionTextView;
        this.mResultTextView = mResultTextView;
        this.mTrueButton = mTrueButton;
        this.mFalseButton = mFalseButton;
        this.mNextButton = mNextButton;
    }

    @Override
    public void reset() {
        mResultTextView.setText("");
        mTrueButton.setEnabled(true);
        mFalseButton.setEnabled(true);
        mNextButton.setEnabled(false);
    }

    @Override
    public void updateQuestionView(QuizPresenter quizPresenter) {
        mQuestionTextView.setText(quizPresenter.getQuestion().getTextResId());
    }

    @Override
    public void onQuestionAnswered() {
        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
        mNextButton.setEnabled(true);
    }

    @Override
    public void gotoNextQuestion(QuizPresenter quizPresenter) {
        quizPresenter.getNextQuestion();//go to next quesiton in quiz array
        updateQuestionView(quizPresenter);
        reset();
    }
}
