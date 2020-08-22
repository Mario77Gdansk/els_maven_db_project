package com.sda.javagda40.els_maven_db_project.database;

import com.sda.javagda40.els_maven_db_project.model.AppUser;
import com.sda.javagda40.els_maven_db_project.model.LearningProcess;
import com.sda.javagda40.els_maven_db_project.model.Subject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

//te dane są przerobione z AppUserDao
public class LearningProcessDao {
    public List<LearningProcess> findWithClosestRepetitionDate(AppUser user) {
        List<LearningProcess> list = new ArrayList<>();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<LearningProcess> criteriaQuery = cb.createQuery(LearningProcess.class);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<LearningProcess> rootTable = criteriaQuery.from(LearningProcess.class);

            // wykonanie zapytania o NextRepetitionDate z klasy LearningProcess
            criteriaQuery
                    .select(rootTable) // select * from rootTable
                    .where(
                            cb.equal(rootTable.get("appUser"), user)
                    ).orderBy(
                    cb.asc(rootTable.get("nextRepetition")
                    )
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

        return list;
    }
}
