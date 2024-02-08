package com.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learn.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Project Started...");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(101);
        st.setName("Sumit");
        st.setCity("Delhi");
        System.out.println(st);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        session.close();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}
