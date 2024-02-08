package com.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.learn.entities.Certificate;
import com.learn.entities.Student;

public class EmbedDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Student student1 = new Student();
        student1.setId(1123);
        student1.setName("Pankaj Tripathi");
        student1.setCity("Patna");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Hibernate");
        certificate1.setDuration("2 months");
        student1.setCerti(certificate1);
        
        Student student2 = new Student();
        student2.setId(1023);
        student2.setName("Rakesh Bist");
        student2.setCity("Nainital");
		
        Certificate certificate2 = new Certificate();
        certificate2.setCourse("JPA");
        certificate2.setDuration("1 months");
        student2.setCerti(certificate2);
        
        Transaction tx = session.beginTransaction();
        session.save(student1);
        session.save(student2);
        tx.commit();
        
        session.close();
        factory.close();
	}

}
