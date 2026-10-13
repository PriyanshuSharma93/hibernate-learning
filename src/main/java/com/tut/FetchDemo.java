package com.tut;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session; 
public class FetchDemo {
	public static void main(String args[]) {
//		get,load
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session=factory.openSession();
//       get-student:102
        Student student = (Student)session.load(Student.class,102);
        System.out.println(student.getName());
        
        Address ad=(Address)session.get(Address.class,1);
        System.out.println(ad.getStreet()+" : " +ad.getCity());
        
        factory.close();
        session.close();
        
	}

}
