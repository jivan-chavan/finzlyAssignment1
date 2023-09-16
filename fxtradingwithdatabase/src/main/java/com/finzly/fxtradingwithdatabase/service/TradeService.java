package com.finzly.fxtradingwithdatabase.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtradingwithdatabase.entity.Currency;
import com.finzly.fxtradingwithdatabase.entity.Trade;
import com.finzly.fxtradingwithdatabase.exception.CurrencyPairNotFoundException;
import com.finzly.fxtradingwithdatabase.exception.InvalidAmountException;
import com.finzly.fxtradingwithdatabase.repository.TradeRepository;




@Service
public class TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	
	@Autowired
	private CurrencyService currencyService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

	public String exchange(Trade newTrade) {
		
		
		if(isCurrencyPairExist(newTrade)) {
			
			Currency currency=currencyService.getCurrencybyCurrencyPair(newTrade.getCurrencyPair());
			
			
				if(!validateAmount(newTrade.getAmount())) {

					throw new InvalidAmountException("The amount you have entered is invalid.");
				} 
				else
				{
					double exchangedAmount = newTrade.getAmount() * currency.getRate();
	                newTrade.setAmount(exchangedAmount);

	                tradeRepository.exchange(newTrade);        
	                
	    	        String transferredCurrency=currency.getCurrencyCode().toUpperCase();
	    	        logger.info("transferredCurrency="+transferredCurrency);
	    	        
	    	        //Here divide the actual length of currencyPair by 2 to get half of currencyPair  
	    	        int transferredCurrencyLength=transferredCurrency.length()/2;
	    	        logger.info("transferredCurrencyLength="+transferredCurrencyLength);

	    	        String message=" Trade for USDINR has been booked with rate " + currency.getRate() + ". The amount of  "
	    	        		+transferredCurrency.substring(transferredCurrencyLength)+" "+
	    					+ newTrade.getAmount() + " will be transferred in 2 working days to " + newTrade.getCustomerName() + " .";
	    			return message;
				}
							
			
		}else {
			throw new CurrencyPairNotFoundException("Fx-trading for this currency pair is not available.");
		}	
		
	}
	// currency pair validation
		private Boolean isCurrencyPairExist(Trade newTrade) {

	        List<Currency> currencyList = currencyService.getAllCurrencyPairList();
			for (Currency currency : currencyList) {
	            if (currency.getCurrencyCode().equalsIgnoreCase(newTrade.getCurrencyPair())) {
	            	return true;
	            }
	        }		
					return false;
		}

		// amount validation
		
		private boolean validateAmount(double amount) {
			if(amount<=0) {
				return false;
			}else {
				return true;
			}
		}
		
		


		public List<Trade> getAllTradeList() {

			return tradeRepository.getAllTradeList();
		}
	
}
