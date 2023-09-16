package com.finzly.fxtradingwithdatabase.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtradingwithdatabase.entity.Currency;


@Repository
public class CurrencyRepository {

	@Autowired
	private SessionFactory sessionFactory;


	private static final Logger logger = LoggerFactory.getLogger(CurrencyRepository.class);

	public List<Currency> getAllCurrencyPairList() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Currency.class);
		return criteria.list();
	}
	public void setOrUpdateCurrency(Currency newCurrency) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(newCurrency);
		session.getTransaction().commit();		
		session.close();	
	}
	
	public Currency getCurrencybyCurrencyPair(String currencyPair) {
		Session session = sessionFactory.openSession();
	    Criteria criteria = session.createCriteria(Currency.class);
	    criteria.add(Restrictions.eq("currencyCode", currencyPair));    
	    Currency currency = (Currency) criteria.uniqueResult(); 
	    
	    return currency;
	}


}
