package com.bignerdranch.android.geoquiz.view;

import android.view.View;

import com.bignerdranch.android.geoquiz.presenter.QuizPresenter;

public class trueFalseClickListener implements View.OnClickListener {
    private QuizPresenter quizPresenter;
    private boolean userPressedTrue;
    private int green;
    private int red;

    public trueFalseClickListener(QuizPresenter quizPresenter, boolean userPressedTrue, int green, int red) {
        this.quizPresenter = quizPresenter;
        this.userPressedTrue = userPressedTrue;
        this.green = green;
        this.red = red;
    }

    @Override
    public void onClick(View v) {
        quizPresenter.checkAnswer(userPressedTrue, green, red);
    }
}
