package com.fxtrading.fxtrading.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fxtrading.fxtrading.entity.Trade;

@Service
public class TradeService {

	private List<Trade> tradeList = new ArrayList<>();
	private static long tradeCount=0;
	private static final double rateForUSDToINR=66.00;
	
	public String makeTrade(Trade newTrade) {
		tradeCount++;
		double convertedAmount =exchange(newTrade);
		
		System.out.println("convertedAmount "+convertedAmount);
		
		newTrade.setAmount(convertedAmount);
		newTrade.setTradeNo(tradeCount);
		
		if(convertedAmount>0) {
			tradeList.add(newTrade);
			
			System.out.println("new trade is saved..!");
			String message="Trade for USDINR has been booked with rate " + newTrade.getRate() + ". The amount of INR "
					+ newTrade.getAmount() + " will  be transferred in 2 working days to " + newTrade.getCustomerName() + " .";
			return message;
			
		}else {
			return "Trading is failed.";
		}		
	}

	
	public List<Trade> getAllTrade(){
		return tradeList;
	}
	
	private double exchange(Trade newTrade) {
		if(newTrade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
			newTrade.setRate(rateForUSDToINR);
			return newTrade.getAmount()*newTrade.getRate();
		}else {
			return 0.0;
		}
	}
	
	
	
}
