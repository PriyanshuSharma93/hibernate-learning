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

//        // Creating question 1
//        Question q1 = new Question();
//        q1.setQuestionId(1213);
//        q1.setQuestion("What is JAVA");
//
//        // Creating answer 1
//        Answer answer = new Answer();
//        answer.setAnswer_id(33);
//        answer.setAnswer("JAVA is a Programming Language");
//        answer.setQuestion(q1);
//        
//        Answer answer1 = new Answer();
//        answer1.setAnswer_id(34);
//        answer1.setAnswer("With the help of java we can create Softwares");
//        answer1.setQuestion(q1);
//        
//        
//        Answer answer2 = new Answer();
//        answer2.setAnswer_id(343);
//        answer2.setAnswer("JAVA have different types of framesworks");
//        answer2.setQuestion(q1);
//        
//        List<Answer> list =new ArrayList<Answer>();
//        list.add(answer);
//        list.add(answer1);
//        list.add(answer2);        
//        q1.setAnswers(list);
//      
        // Session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        // Save question
//        s.save(q1);
//        s.save(answer);
//        s.save(answer1);
//        s.save(answer2);
        
        
        Question q=(Question)s.get(Question.class,1213);
        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());
        //lazy
        System.out.println(q.getAnswers().size());
        
//        for(Answer a:q.getAnswers()) {
//        	   System.out.println(a.getAnswer());
//        }

        tx.commit();
        
        
//        fetching......
//        Question newQ = (Question)s.get(Question.class,1212);
//       System.out.println(newQ.getQuestion());
//       System.out.println(newQ.getAnswer().getAnswer());

        s.close();
        factory.close();
    }
}