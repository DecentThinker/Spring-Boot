package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // To read hibernate.cfg.xml file and do the configuration.
        Configuration configuration = new Configuration();
        configuration.configure();

        // Let the configuration know of the Entity class.
        configuration.addAnnotatedClass(Student.class);

        //Configuration will provide Session factory. It helps in managing sessions with database.
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Session factory provides session to communicate with Database
        Session session = sessionFactory.openSession();

        //In Hibernate we just need to create the Object of Entity Class and
        // do the save to insert into database table

        Student student1 = new Student(1, "Aman","aman@gmail.com");
        Student student2 = new Student(2, "Laxmi","laxmi@gmail.com");

        // In order to perform operations in database we have to do inside a transaction.
        // A Transaction ensures ACID properties. if an exception all executed queries will be roll back.

        //Insert Query
//        session.getTransaction().begin();
//        session.save(student1);
//        //int a = 10/0;
//        session.save(student2);
//        session.getTransaction().commit();

         // Delete Query.
//        session.getTransaction().begin();
//        session.delete(student);
//        session.getTransaction().commit();

        //Update Query
//        session.getTransaction().begin();
//        Student updateStudent = session.get(Student.class, 2);
//        updateStudent.setUsername("Mehwish");
//        updateStudent.setEmail("Mehwish@gmail.com");
//        session.save(updateStudent);
//        session.getTransaction().commit();

        //All crud operations done till here.

        //Embeddable Annotation usage for Address

        session.getTransaction().begin();
        Address address1 = new Address("123","Okhla Vihar");
        Address address2 = new Address("456","Abul Fazal");
        student1.setAddress(address1);
        student2.setAddress(address2);
        session.save(student1);
        session.save(student2);
        session.getTransaction().commit();
    }
}
