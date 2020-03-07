package com.bignerdranch.android.geoquiz.view;

import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.android.geoquiz.presenter.QuizPresenter;

import org.w3c.dom.Text;

public interface IfaceView {
    void reset();

    void updateQuestionView(QuizPresenter quizPresenter);

    void onQuestionAnswered();

    void gotoNextQuestion(QuizPresenter quizPresenter);
}