package com.sda.javagda40.els_maven_db_project.handlers;

import com.sda.javagda40.els_maven_db_project.database.EntityDao;
import com.sda.javagda40.els_maven_db_project.model.Category;
import com.sda.javagda40.els_maven_db_project.model.Subject;

import java.util.Optional;
import java.util.Scanner;

public class CategoryHandler {
    private Scanner scanner = new Scanner(System.in);
    private EntityDao<Category> categoryEntityDao = new EntityDao<>();
    private EntityDao<Subject> subjectEntityDao = new EntityDao<>();

    public void handle(String[] words) {
        if (words[1].equalsIgnoreCase("list")) {
            handleListCategory();
        } else if (words[1].equalsIgnoreCase("add")) {
            handleAddCategory();
        }
    }

    private void handleAddCategory() {
        System.out.println("Podaj nazwe kategorii:");
        String newCategoryName = scanner.nextLine();

        Category category = Category.builder()
                .categoryName(newCategoryName)
                .subject(provideSubject())
                .build();

        categoryEntityDao.saveOrUpdate(category);
    }

    private Subject provideSubject() {
        Subject subject = null;
        do {
            System.out.println("Lista tematów:");
            subjectEntityDao
                    .findAll(Subject.class)
                    .forEach(System.out::println);
            System.out.println("Wybierz id:");
            Long id = Long.parseLong(scanner.nextLine());

            Optional<Subject> optionalSubject = subjectEntityDao.findById(Subject.class, id);
            if (optionalSubject.isPresent()) {
                subject = optionalSubject.get();
            }
        } while (subject == null);

        return subject;
    }

    private void handleListCategory() {
        categoryEntityDao
                .findAll(Category.class)
                .forEach(System.out::println);
    }
}
