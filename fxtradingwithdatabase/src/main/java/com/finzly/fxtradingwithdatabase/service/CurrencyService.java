package com.finzly.fxtradingwithdatabase.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.finzly.fxtradingwithdatabase.entity.Currency;
import com.finzly.fxtradingwithdatabase.repository.CurrencyRepository;


@Service
public class CurrencyService {

	@Autowired 
	private CurrencyRepository currencyRepository;


	private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);

	public List<Currency> getAllCurrencyPairList() {
		return currencyRepository. getAllCurrencyPairList();
	}
	
	
	public String setOrUpdateCurrency(String currencyPair) {
	return	separateCurrencyPairAndRate(currencyPair);	
	}

	
	private String separateCurrencyPairAndRate(String currencypair) {
	    logger.info("currencypair=" + currencypair);
	    String[] currencyPairArray = currencypair.split("=");
	    String currencyPairPart1 = currencyPairArray[0];
	    double currencyPairPart2 = Double.parseDouble(currencyPairArray[1]);
	    logger.info("currencyPairPart1=" + currencyPairPart1);
	    logger.info("currencyPairPart2=" + currencyPairPart2);
	  
	    Currency newCurrency= new Currency();
    
	    Currency existedCurrency = getCurrencybyCurrencyPair(currencyPairPart1); 

	    logger.info("existedCurrency=" + existedCurrency);

	    if (existedCurrency == null) {    
	        // This means the currency is not in the database
	        newCurrency.setCurrencyCode(currencyPairPart1);
	        newCurrency.setRate(currencyPairPart2);
	       
	        logger.info("newCurrency="+newCurrency);
	        currencyRepository.setOrUpdateCurrency(newCurrency);	        

	        return "New currency is added successfully";
	    } else {
	        // This means that the currency already exists in the database, and you are changing its rate
	        existedCurrency.setCurrencyCode(currencyPairPart1);
	        existedCurrency.setRate(currencyPairPart2);
	        logger.info("existedCurrency="+existedCurrency);


	        currencyRepository.setOrUpdateCurrency(existedCurrency);
	        
	        return "Currency is updated successfully";
	    }
	}

	public Currency getCurrencybyCurrencyPair(String currencyPair) {
		return currencyRepository.getCurrencybyCurrencyPair(currencyPair);
	}	
	
	
	

	 
}
