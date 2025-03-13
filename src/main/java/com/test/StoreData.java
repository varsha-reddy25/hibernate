package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	 public static void main(String[] args) {
		
		 //1 create configuration class object
		 
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//2 create SeesionFactory object
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		//3 create Session object
		
		Session session = sf.openSession();
		
		//4 transaction object
		
		Transaction t = session.beginTransaction();
		
		//transient state
		//insert
		Book b =new Book();
		
		b.setB_name("spring");
		b.setB_author("Rodj");
	   b.setB_price(123);			
		
	   //5 execute the object
	  session.save(b);
	 // t.commit();
	  
	  //delete
	  /* 
	   Book bobj=session.get(Book.class,2);
	   session.delete(bobj);
	   t.commit();
	   */
	  
	  
	  //read
	   Book bobj=session.get(Book.class, 1);
	   System.out.println(bobj.getId()+" "+bobj.getB_name()+" "+bobj.getB_author()+" "+bobj.getB_price());;
	  
		//update
	   bobj.setB_name("Hibernate");
	   session.save(bobj);
	   t.commit();
	  //6 close session object
	   session.close();
	 }
}
