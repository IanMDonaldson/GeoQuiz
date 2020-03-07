package com.bignerdranch.android.geoquiz.presenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.IconCompat;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.model.Question;
import com.bignerdranch.android.geoquiz.model.Quiz;
import com.bignerdranch.android.geoquiz.view.QuizView;

public class QuizPresenter extends AppCompatActivity implements IfacePresenter {
    private Quiz quiz;
    private Question question;
    private QuizView quizView;

    public QuizPresenter(QuizView quizView) {
        this.quiz = new Quiz();
        this.quizView = quizView;
    }

    @Override
    public Question getQuestion() {
        return quiz.getCurrentQuestion();
    }

    @Override
    public Question getNextQuestion() {
        quiz.nextQuestion();
        return quiz.getCurrentQuestion();
    }

    @Override
    public Quiz getQuiz() {
        return quiz;
    }

    @Override
    public void checkAnswer(boolean userPressedTrue, int green, int red) {
        int answerColor;
        boolean answerIsTrue = quiz.getCurrentQuestion().isAnswerTrue();
        int messageResId;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            answerColor = green;
        } else {
            messageResId = R.string.incorrect_toast;
            answerColor = red;
        }

        quizView.getmResultTextView().setText(messageResId);
        quizView.getmResultTextView().setTextColor(answerColor);
        quizView.onQuestionAnswered();
    }
}
