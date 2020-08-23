package com.sda.javagda40.els_maven_db_project.handlers;

import com.sda.javagda40.els_maven_db_project.database.EntityDao;
import com.sda.javagda40.els_maven_db_project.model.AppUser;
import com.sda.javagda40.els_maven_db_project.model.Subject;

import java.util.Scanner;

public class SubjectHandler {
    private Scanner scanner = new Scanner(System.in);
    private EntityDao<Subject> subjectEntityDao = new EntityDao<>();
    public void handle(String[] words) {
        if (words[1].equalsIgnoreCase("list")) {
            handleListSubject();
        } else if (words[1].equalsIgnoreCase("add")) {
            handleAddSubject(words);
        }
    }

    private void handleAddSubject(String[] words) {
        Subject subject = Subject.builder()
                .subjectName(words[2])
                .build();
        subjectEntityDao.saveOrUpdate(subject);
       }

    private void handleListSubject() {
        subjectEntityDao
                .findAll(Subject.class)
                .forEach(System.out::println);
    }
}
