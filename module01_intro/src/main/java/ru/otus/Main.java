package ru.otus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import ru.otus.domain.model.Quiz;
import ru.otus.service.QuizService;

public class Main {

  public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    QuizService quizService = context.getBean(QuizService.class);

    Resource resource = context.getResource(quizService.getFilename());
    Path path = Paths.get(resource.getURI());
    List<String> lines = Files.readAllLines(path);

    quizService.startQuiz(new Quiz(lines));
  }
}
