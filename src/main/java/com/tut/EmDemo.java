package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmDemo {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student1=new Student();
        student1.setId(14134);
        student1.setName("Priyanshu Sharma");
        student1.setCity("LKO");
        
        
        Certificate certificate= new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 Months");
        student1.setCerti(certificate);
        
        Student student2=new Student();
        student2.setId(14133);
        student2.setName("Divya Chauhan");
        student2.setCity("Ghaziabad");
        
        
        Certificate certificate1= new Certificate();
        certificate1.setCourse("hibernate");
        certificate1.setDuration("3 Months");
        student2.setCerti(certificate1);
        
        Session s =factory.openSession();
        Transaction tx=s.beginTransaction();
        
//        objects save;
        s.save(student1);
        s.save(student2);
        
        
        tx.commit();
        s.close();
        factory.close();
      }

}
