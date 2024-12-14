package ru.otus.service;

import ru.otus.domain.model.Quiz;
import ru.otus.domain.usecase.QuestionUsecase;

public class QuizServiceImpl implements QuizService {

  private final QuestionUsecase questionUsecase;
  private String filename;

  public QuizServiceImpl(QuestionUsecase questionUsecase) {
    this.questionUsecase = questionUsecase;
  }

  @Override
  public void startQuiz(Quiz quiz) {
    quiz.getQuestions().forEach(questionUsecase::printQuestion);
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
