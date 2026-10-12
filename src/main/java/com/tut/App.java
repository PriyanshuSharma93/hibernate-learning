package com.tut;

import java.io.FileInputStream;
import java.util.Date;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Project started.....");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        // Creating student
        Student st = new Student();
        st.setId(102);
        st.setName("Aditya");
        st.setCity("Noida");

        System.out.println(st);

        // creating address object
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);

//        Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/com/tut/pic.jfif");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        factory.close();

        System.out.println("done");
    }
}