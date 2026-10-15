package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String args[]) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating question 1
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is JAVA");

        // Creating answer 1
        Answer answer = new Answer();
        answer.setAnswer_id(343);
        answer.setAnswer("JAVA is a Programming Language");
        answer.setQuestion(q1);;
        q1.setAnswer(answer);

        // Creating question 2
        Question q2 = new Question();
        q2.setQuestionId(1213);
        q2.setQuestion("What is Collections Frameworks");

        // Creating answer 2
        Answer answer1 = new Answer();
        answer1.setAnswer_id(344);
        answer1.setAnswer("API to work with objects in java");
        answer1.setQuestion(q2);
        q2.setAnswer(answer1);

        // Session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        // Save answers first
        s.save(answer);
        s.save(answer1);

        // Save questions
        s.save(q1);
        s.save(q2);

        tx.commit();
        
        
//        fetching......
        Question newQ = (Question)s.get(Question.class,1212);
       System.out.println(newQ.getQuestion());
       System.out.println(newQ.getAnswer().getAnswer());

        s.close();
        factory.close();
    }
}