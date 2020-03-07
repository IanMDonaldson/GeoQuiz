package com.bignerdranch.android.geoquiz.presenter;

import androidx.appcompat.app.AppCompatActivity;

import com.bignerdranch.android.geoquiz.model.Question;
import com.bignerdranch.android.geoquiz.model.Quiz;

public interface IfacePresenter {
    Question getQuestion();//quiz getcurrentQuestion --

    Question getNextQuestion();//quiz nextQuestion

    Quiz getQuiz();

    void checkAnswer(boolean userPressedTrue, int green, int red);
}
