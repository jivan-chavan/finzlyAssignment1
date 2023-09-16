package com.finzly.fxtradingwithdatabase.repository;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtradingwithdatabase.entity.Trade;


@Repository
public class TradeRepository {

	@Autowired
	private SessionFactory sessionFactory;
	

	public void exchange(Trade newTrade) {
		
		Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.save(newTrade);
			session.getTransaction().commit();
			session.close();
			  
	}


	public List<Trade> getAllTradeList() {
		Session session = sessionFactory.openSession();		
		Criteria criteria=session.createCriteria(Trade.class);
		return criteria.list();
	}


	
	
}
