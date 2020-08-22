//package com.sda.javagda40.els_maven_db_project.database;
//
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
//// Ta klasa załaduje naszą konfigurację bazodanową
//public class HibernateUtil {
//    private static final SessionFactory ourSessionFactory;
//
//    // blok statyczny - fragment kodu który wykonuje się 1 raz przy starcie klasy
//    static {
//        try {
//            System.out.println("Konfiguruję hibernate.");
//
//            /// ta klasa domyślnie odwołuje się do pliku konfiguracyjnego hibernate w formacie podanym w resources
//            Configuration configuration = new Configuration();
//            configuration.configure("/hibernate.cfg.xml");
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        }catch (HibernateException he){
//            System.err.println(he.getMessage());
//            throw he;
//        }
//    }
//
//    // wygenerowany getter
//    public static SessionFactory getOurSessionFactory() {
//        return ourSessionFactory;
//    }
//}


package com.sda.javagda40.els_maven_db_project.database;

        import com.sda.javagda40.els_maven_db_project.model.AppUser;
        import com.sun.tools.javac.file.Locations;
        import org.hibernate.SessionFactory;
        import org.hibernate.boot.registry.StandardServiceRegistry;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
        import org.hibernate.cfg.Configuration;

        import javax.swing.plaf.synth.Region;

public class HibernateUtil {
    private static Configuration getHibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:db-data/els_maven_db_demo");
        configuration.setProperty("hibernate.connection.username", "user");
        configuration.setProperty("hibernate.connection.password", "user");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true"); // pokaże co jest pod spodem w sql
        configuration.setProperty("hibernate.connection.autocommit", "true"); // automatyczny committ
        configuration.addAnnotatedClass(AppUser.class); //wskazanie ścieżki do klasy entity jest właśnie tutaj
//        configuration.addAnnotatedClass(Locations.class); //wskazanie ścieżki do klasy entity jest właśnie tutaj
//        configuration.addAnnotatedClass(Departments.class); //wskazanie ścieżki do klasy entity jest właśnie tutaj
        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}