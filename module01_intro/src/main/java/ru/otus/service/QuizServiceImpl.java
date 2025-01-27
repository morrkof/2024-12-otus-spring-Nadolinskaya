package ru.otus.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import ru.otus.domain.model.Quiz;
import ru.otus.domain.usecase.QuestionUsecase;

public class QuizServiceImpl implements QuizService {

  private final QuestionUsecase questionUsecase;
  private String filename;

  public QuizServiceImpl(QuestionUsecase questionUsecase) {
    this.questionUsecase = questionUsecase;
  }

  @Override
  public void startQuiz() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        "/spring-context.xml");
    Resource resource = context.getResource(this.getFilename());
    List<String> lines = new ArrayList<>();
    try {
      Path path = Paths.get(resource.getURI());
      lines = Files.readAllLines(path);
    } catch (Exception e) {
      System.out.println("Ошибка при чтении файла с вопросами");
    }
    Quiz quiz = new Quiz(lines);
    quiz.getQuestions().forEach(questionUsecase::printQuestion);
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }
}
