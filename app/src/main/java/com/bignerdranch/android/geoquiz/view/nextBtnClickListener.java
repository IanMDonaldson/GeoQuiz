package com.bignerdranch.android.geoquiz.view;

import android.view.View;

import com.bignerdranch.android.geoquiz.presenter.QuizPresenter;

public class nextBtnClickListener implements View.OnClickListener {
    private QuizView quizView;
    private QuizPresenter quizPresenter;

    public nextBtnClickListener(QuizView quizView, QuizPresenter quizPresenter) {
        this.quizView = quizView;
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void onClick(View v) {
        quizView.gotoNextQuestion(quizPresenter);
    }
}
