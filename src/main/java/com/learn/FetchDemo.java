package com.learn;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.learn.Address;
import com.learn.Student;

public class FetchDemo {

	public static void main(String[] args) {
		
		//get and load
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        //get-student:101
        Student student = session.get(Student.class, 103);
        System.out.println(student.getCity());
        
        //load - student:102
        Student student2 = session.load(Student.class, 102);
        System.out.println(student2);
        
        Address ad = session.get(Address.class, 1);
        System.out.println(ad);
        
        session.close();
        factory.close();
	}

}
