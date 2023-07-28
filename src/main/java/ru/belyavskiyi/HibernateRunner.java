package ru.belyavskiyi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import ru.belyavskiyi.entity.User;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {

            session.beginTransaction();
            User user = User.builder()
                    .username("igor@gmamil.com")
                    .firstname("igor")
                    .lastname("belyavskiy")
                    .birthDate(LocalDate.of(2000, 1, 23))
                    .age(23)
                    .build();

            session.save(user);

            session.getTransaction().commit();
        }

    }
}
