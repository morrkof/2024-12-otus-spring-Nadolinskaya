package ru.otus.service;

import ru.otus.domain.model.Quiz;

public interface QuizService {

  void startQuiz(Quiz quiz);

  String getFilename();
}
