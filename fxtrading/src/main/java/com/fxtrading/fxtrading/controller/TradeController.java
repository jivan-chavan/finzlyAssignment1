package com.fxtrading.fxtrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxtrading.fxtrading.entity.Trade;
import com.fxtrading.fxtrading.services.TradeService;

@RestController
@RequestMapping("trades")
public class TradeController {

	@Autowired
	private TradeService tradeService;
	
	@PostMapping("/booktrade")
	public String booktrade(@RequestBody Trade newTrade) {			
			return tradeService.makeTrade(newTrade);
	}
	
	@GetMapping("/printtrades")
	public List<Trade> printTrades(){
		return tradeService.getAllTrade();
	}
	

}
