package com.cricket.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MAINSHS 
{
public static void main(String[] args)
{
	SessionFactory sf= new Configuration().configure().buildSessionFactory();
	
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
		Batsman bs=new Batsman();
		bs.setFours(0);
		Bowler bo =new Bowler();
		bo.setBalls(1);
		session.save(bo);
		tx.commit();
	
}
}
