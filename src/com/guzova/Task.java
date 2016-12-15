package com.guzova;

import java.util.List;

public class Task {
    private String question;
    private List<String> answers;
    private int rightAnswer;

    public Task(String question, List<String> answers, int rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String toString() {
        return question + "-" + answers.toString() + "-" + rightAnswer;
    }
}
