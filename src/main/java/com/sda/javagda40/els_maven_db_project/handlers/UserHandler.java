package com.sda.javagda40.els_maven_db_project.handlers;

import com.sda.javagda40.els_maven_db_project.database.EntityDao;
import com.sda.javagda40.els_maven_db_project.model.AppUser;
import com.sda.javagda40.els_maven_db_project.model.Subject;

import java.util.Scanner;

public class UserHandler {
    private Scanner scanner = new Scanner(System.in);
    private EntityDao<AppUser> appUserEntityDao = new EntityDao<>();
    public void handle(String[] words) {
        if (words[1].equalsIgnoreCase("list")) {
            handleListUsers();
        } else if (words[1].equalsIgnoreCase("add")) {
            handleAddUser(words);
        }
    }

    private void handleAddUser(String[] words) {

        AppUser appUser = AppUser.builder()
                .firstName(words[2])
                .lastName(words[3])
                .build();
    }

    private void handleListUsers() {
        appUserEntityDao
                .findAll(AppUser.class)
                .forEach(System.out::println);
    }
}
