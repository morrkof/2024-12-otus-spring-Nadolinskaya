package ru.otus.domain.usecase;

import ru.otus.domain.model.Question;

public class QuestionUsecase {

  public void printQuestion(Question question) {
    System.out.println(question.getQuestion());
    for (int i = 0; i < question.getAnswers().size(); i++) {
      System.out.println("     " + (i + 1) + ") " + question.getAnswers().get(i));
    }
    System.out.println("Correct: " + question.getCorrectAnswer());
  }
}
