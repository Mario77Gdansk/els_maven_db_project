package com.sda.javagda40.els_maven_db_project;

import com.sda.javagda40.els_maven_db_project.database.EntityDao;
import com.sda.javagda40.els_maven_db_project.database.HibernateUtil;
import com.sda.javagda40.els_maven_db_project.model.AppUser;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initial version.");
        HibernateUtil.getSessionFactory();
        System.out.println("Tested hibernate");

        EntityDao<AppUser> appUserEntityDao = new EntityDao<>();
        appUserEntityDao.saveOrUpdate(new AppUser("Marian","Paździoch"));
        }
}