package com.learn.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java ?");

		//creating answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(343);
		ans1.setAnswer("Java is a programming language.");
		q1.setAnswer(ans1);
		
		//creating question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection Framework ?");
		
		//creating answer
		Answer ans2 = new Answer();
		ans2.setAnswerId(344);
		ans2.setAnswer("API to work with objects in java.");
		q2.setAnswer(ans2);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(q1);
		s.save(q2);
		s.save(ans1);
		s.save(ans2);
		tx.commit();
		s.close();
		factory.close();
		
		
	}

}
