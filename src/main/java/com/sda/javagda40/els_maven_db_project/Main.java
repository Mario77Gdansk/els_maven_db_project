package com.sda.javagda40.els_maven_db_project;

import com.sda.javagda40.els_maven_db_project.database.HibernateUtil;
import com.sda.javagda40.els_maven_db_project.handlers.CategoryHandler;
import com.sda.javagda40.els_maven_db_project.handlers.QuestionHandler;
import com.sda.javagda40.els_maven_db_project.handlers.SubjectHandler;
import com.sda.javagda40.els_maven_db_project.handlers.UserHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initial version.");
        HibernateUtil.getSessionFactory();
        System.out.println("Tested hibernate");

        Scanner scanner = new Scanner(System.in);
        UserHandler userHandler = new UserHandler();
        SubjectHandler subjectHandler = new SubjectHandler();
        CategoryHandler categoryHandler = new CategoryHandler();
        QuestionHandler questionHandler = new QuestionHandler();
        String command;

        System.out.println("Cześć zaczynamy...\nmożesz operować na komendach:\n[subject _ category _ question _ user]");
        System.out.println("[add _ list]");

        do {

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
            else if (words[0].equalsIgnoreCase("category")) {
                categoryHandler.handle(words);
            }
            else if (words[0].equalsIgnoreCase("question")) {
                questionHandler.handle(words);
            }
        } while (!command.equalsIgnoreCase("quit"));
    }


}