package com.learn.map.onetomany;

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
		
		//creating question
		Question q1 = new Question();
		q1.setQuestionId(122);
		q1.setQuestion("What is java ?");

		//creating answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(343);
		ans1.setAnswer("Java is a programming language.");
		ans1.setQuestion(q1);
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(313);
		ans2.setAnswer("With the help of java we can create softwares.");
		ans2.setQuestion(q1);
		
		Answer ans3 = new Answer();
		ans3.setAnswerId(23);
		ans3.setAnswer("Java has different type of frameworks.");
		ans3.setQuestion(q1);
		
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(ans1);
		answers.add(ans2);
		answers.add(ans3);
		
		q1.setAnswers(answers);
		
		//creating question
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//save
		s.save(q1);
		s.save(ans1);
		s.save(ans2);
		s.save(ans3);
		
		
		
		tx.commit();
		
		//fetching....
//		Question newQ = s.get(Question.class, 242);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer().getAnswer());
		
		s.close();
		factory.close();
		
		
	}

}
