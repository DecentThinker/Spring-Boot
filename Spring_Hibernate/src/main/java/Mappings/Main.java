package Mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Laptop.class);
        SessionFactory sessionFactory  = configuration.buildSessionFactory();
        Session session  = sessionFactory.openSession();

        session.getTransaction().begin();
        Employee employee = new Employee(1,"Ankit","ankit@aetna.com", null);
        session.save(employee);
        Laptop laptop1 = new Laptop(1001, "HP Omen");
        Laptop laptop2 = new Laptop(1002, "Macbook");
        laptop1.setEmployee(employee);
        laptop2.setEmployee(employee);
        session.save(laptop1);
        session.save(laptop2);
        session.getTransaction().commit();
        System.out.println("Mapping done");
    }



}
