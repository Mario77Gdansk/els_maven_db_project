package com.sda.javagda40.els_maven_db_project.database;

import com.sda.javagda40.els_maven_db_project.model.AppUser;
import com.sda.javagda40.els_maven_db_project.model.UserLoginData;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

//te dane są zaimportowane z git od Pawła
public class LogUserDao {
    public boolean existsUserWithLogin(String searchedLogin) {
        List<UserLoginData> list = new ArrayList<>();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<UserLoginData> criteriaQuery = cb.createQuery(UserLoginData.class);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<UserLoginData> rootTable = criteriaQuery.from(UserLoginData.class);

            // wykonanie zapytania o login z klasy UserLoginData
            criteriaQuery
                    .select(rootTable) // select * from rootTable
                    .where(
                            cb.equal(rootTable.get("login"), searchedLogin )
                    );
//            criteriaQuery
//                    .select(rootTable)
//                    .where(
//                            cb.and(
//                                    cb.equal(rootTable.get("firstName"), searchedFirstName ),
//                                    cb.equal(rootTable.get("lastName"), searchedLastName )
//                            )
//                    ).orderBy(cb.asc(rootTable.get("firstName")));

            // specification
            list.addAll(session.createQuery(criteriaQuery).list());

            // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
            // używanie klas których będziecie używać na JPA (Spring)

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return !list.isEmpty();
    }
}
