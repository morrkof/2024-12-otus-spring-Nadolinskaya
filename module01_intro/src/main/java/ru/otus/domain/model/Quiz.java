package ru.otus.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {

  private List<Question> questions;

  public List<Question> getQuestions() {
    return questions;
  }

  public Quiz(List<String> lines) {
    questions = new ArrayList<>();
    for (String line : lines) {
      String[] parts = line.split(",");
      List<String> answers = Arrays.stream(parts, 1, parts.length - 1).collect(Collectors.toList());
      questions.add(new Question(parts[0], answers, Integer.parseInt(parts[parts.length - 1])));
    }
  }
}
