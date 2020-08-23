package com.sda.javagda40.els_maven_db_project.handlers;

import com.sda.javagda40.els_maven_db_project.database.EntityDao;
import com.sda.javagda40.els_maven_db_project.model.Category;
import com.sda.javagda40.els_maven_db_project.model.Questions;
import com.sda.javagda40.els_maven_db_project.model.Subject;

import java.util.Optional;
import java.util.Scanner;

public class QuestionHandler {
    private Scanner scanner = new Scanner(System.in);
    private EntityDao<Questions> questionsEntityDao = new EntityDao<>();
    private EntityDao<Category> categoryEntityDao = new EntityDao<>();
    private EntityDao<Subject> subjectEntityDao = new EntityDao<>();

    public void handle(String[] words) {
        if (words[1].equalsIgnoreCase("list")) {
            handleListQuestions();
        } else if (words[1].equalsIgnoreCase("add")) {
            handleAddQuestion();
        }
    }

    private void handleAddQuestion() {
        System.out.println("Podaj treść pytania:");
        String newQuestionBody = scanner.nextLine();
        System.out.println("Podaj własciwą odpowiedź");
        String newAnswerBody = scanner.nextLine();

        Questions question = Questions.builder()
                .question(newQuestionBody)
                .answer(newAnswerBody)
                .category(provideCategory())
                .build();

        questionsEntityDao.saveOrUpdate(question);
    }

    private Category provideCategory() {
        Category category = null;
        do {
            System.out.println("Lista kategorii:");
            categoryEntityDao
                    .findAll(Category.class)
                    .forEach(System.out::println);
            System.out.println("Wybierz id:");
            Long id = Long.parseLong(scanner.nextLine());

            Optional<Category> optionalCategory = categoryEntityDao.findById(Category.class, id);
            if (optionalCategory.isPresent()) {
                category = optionalCategory.get();
            }
        } while (category == null);

        return category;
    }

    private void handleListQuestions() {
        questionsEntityDao
                .findAll(Questions.class)
                .forEach(System.out::println);
    }
}
