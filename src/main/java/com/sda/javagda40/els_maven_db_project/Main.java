package com.sda.javagda40.els_maven_db_project;

import com.sda.javagda40.els_maven_db_project.database.EntityDao;
import com.sda.javagda40.els_maven_db_project.database.HibernateUtil;
import com.sda.javagda40.els_maven_db_project.handlers.SubjectHandler;
import com.sda.javagda40.els_maven_db_project.handlers.UserHandler;
import com.sda.javagda40.els_maven_db_project.model.AppUser;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initial version.");
        HibernateUtil.getSessionFactory();
        System.out.println("Tested hibernate");

        Scanner scanner = new Scanner(System.in);
        UserHandler userHandler = new UserHandler();
        SubjectHandler subjectHandler = new SubjectHandler();
        String command;

        do {
            System.out.println("Cześć zaczynamy...\nmożesz operować na słowach:\n\"subject\"\t\"user\"");
            System.out.println("Wprowadz komende: "); //może być wypisanie wszystkich opcji
            command = scanner.nextLine();  //do Stringa o nazwie command dodaję to co jest w nextLine
            String[] words = command.split(" ");
            //words jest wektorem String[] podzielonym przez split(" ")
            //argumentem split jest regex w postaci pojedynczej spacji
            // jeżeli ktyoś wpisze: "serwis aukcyjny allegro" to otrzyma
            // words = { "serwis", "aukcyjny", "allegro"}

            // user list
            if (words[0].equalsIgnoreCase("user")) {
                userHandler.handle(words);
            }else if (words[0].equalsIgnoreCase("subject")) {
               subjectHandler.handle(words);
            }
        } while (!command.equalsIgnoreCase("quit"));
    }


}