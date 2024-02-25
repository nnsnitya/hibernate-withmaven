package com.learn.objectstates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learn.Certificate;
import com.learn.Student;

public class StateDemo {

	public static void main(String[] args) {
		//Practical of Hibernate Object States:
		//Transient
		//Persistent
		//Detached
		//Removed
		
		System.out.println("Example : ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student = new Student();
		student.setId(1416);
		student.setName("Rakesh");
		student.setCity("Jhansi");
		student.setCerti(new Certificate("Java Hibernate Course", "2 month"));
		//student: Transient State
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//student: Persistent - session, database
		student.setCity("Lucknow");
		tx.commit();
		s.close();
		//student: Detached State
		
		student.setCity("Rameshwaram");;
		System.out.println(student);
		f.close();
	}

}
