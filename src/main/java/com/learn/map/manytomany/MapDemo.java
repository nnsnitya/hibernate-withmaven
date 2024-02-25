package com.learn.map.manytomany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
		
		//creating Emp
        Emp e1 = new Emp();
        Emp e2 = new Emp();
        
        e1.setEid(34);
        e1.setName("Ram");

        e2.setEid(35);
        e2.setName("Shyam");

        Project p1 = new Project();
        Project p2 = new Project();
        p1.setPid(117);
        p1.setProjectName("Library Management System");
        p2.setPid(118);
        p2.setProjectName("CHATBOT");
        
        List<Emp> empList = new ArrayList<Emp>();
        List<Project> projectList = new ArrayList<Project>();
        
        empList.add(e1);
        empList.add(e2);
        
        projectList.add(p1);
        projectList.add(p2);
        
        //
        e1.setProjects(projectList);
        p2.setEmps(empList);
        
        //open session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();
		factory.close();
		
		
	}

}
