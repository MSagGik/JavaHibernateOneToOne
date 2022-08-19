package ru.msaggik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.msaggik.hibernate.model.Passport;
import ru.msaggik.hibernate.model.Person;

public class App {
    public static void main( String[] args ) {
        // подключение файла конфигурации hibernate.properties и классов Person и Passport
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        // создание сессии из configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // сессия
        Session session = sessionFactory.getCurrentSession();

        try {
            // начало транзакции
            session.beginTransaction();

//            // генерация новых пользователя и паспорта:
//            // 1) генерация данных нового пользователя
//            Person person = new Person("Tim", 50);
//            // 2) генерация данных нового паспорта
//            Passport passport = new Passport(12345);
//            // присваивание пользователю данного паспорта
//            person.setPassport(passport); // балансировка кэша
//            // 3) сохранение в БД сгенерированных данных
//            session.save(person);

//            // получим из БД пользователя и по этим данным определим паспорт:
//            // 1) получение из БД пользователя с id=1
//            Person person1 = session.get(Person.class, 1);
//            // 2) получение и отображение по этим данным номера паспорта
//            System.out.println(person1.getPassport().getPassportNumber());

//            // получим из БД паспорт и по этим данным определим пользователя:
//            // 1) получение из БД номер паспорта с id=1
//            Passport passport1 = session.get(Passport.class, 1);
//            // 2) получение и отображение по этим данным имени пользователя
//            System.out.println(passport1.getPerson().getName());

//            // изменение номера паспорта у пользователя с id=1:
//            // 1) получение из БД пользователя с id=1
//            Person person2 = session.get(Person.class, 1);
//            // 2) изменение по этим данным номера паспорта
//            person2.getPassport().setPassportNumber(678910);

//            // удаление пользователя с id=1 из БД и каскадное удаление
//            // всех связанных с ним сущностей на уровне БД:
//            // 1) получение из БД пользователя с id=1
//            Person person3 = session.get(Person.class, 1);
//            // 2) удаление пользователя с id=1 из БД
//            session.remove(person3);

            // закрытие транзакции
            session.getTransaction().commit();
        } finally {
            // закрытие сессии
            sessionFactory.close();
        }
    }
}