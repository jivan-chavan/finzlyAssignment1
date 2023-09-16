package com.finzly.fxtradingwithdatabase.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtradingwithdatabase.entity.Currency;
import com.finzly.fxtradingwithdatabase.service.CurrencyService;



@RestController
@RequestMapping("/currency")
public class CurrencyController {



	@Autowired
	private CurrencyService currencyService;
	
	// example currencyPair => usdinr=60
	@PostMapping("/{currencypair}")
	public String setOrUpdateCurrency(@PathVariable String currencypair) {
		return currencyService.setOrUpdateCurrency(currencypair);
		}
	
	@GetMapping("/getallcurrency")
	public List<Currency> getAllCurrencyPairList() {
		
		return currencyService.getAllCurrencyPairList();
	}

}
