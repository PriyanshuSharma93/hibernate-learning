package com.states;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
	public static void main(String args[]) {
//		practical of Hibernate Objects States:
//		transient 
//		persistent
//		detached
//		removed
		System.out.println("Example");
		
		SessionFactory f= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
//		creating student object
		Student student = new Student();
		student.setId(1214);
		student.setName("Divya");
		student.setCity("SanjayNagar");
		student.setCerti(new Certificate("Java Hibernate Course","2 Months"));
//		student:Transient
		
		
		Session s=f.openSession();
		Transaction tx =s.beginTransaction();
		s.save(student);
//		student:persistent - Session,database	
		student.setName("Priyanshu");
		
		tx.commit();
				
		s.close();
//		student:Detached
		student.setName("Mummy");
		System.out.println(student);
		f.close();
	}

}
