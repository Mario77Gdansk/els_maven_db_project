package com.sda.javagda40.els_maven_db_project;

import com.sda.javagda40.els_maven_db_project.database.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initial version.");
        HibernateUtil.getOurSessionFactory();
        System.out.println("Tested hibernate");
        }
}