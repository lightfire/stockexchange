package com.kadirergun.stockexchange.service;

import com.kadirergun.stockexchange.model.StockExchange;
import com.kadirergun.stockexchange.model.Stock;
import com.kadirergun.stockexchange.repository.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Transactional
    public StockExchange getStockExchangeByName(String name) {
        return stockExchangeRepository.findByName(name);
    }

    @Transactional
    public void addStockToExchange(String exchangeName, Stock stock) {
        StockExchange exchange = stockExchangeRepository.findByName(exchangeName);
        exchange.getStocks().add(stock);
        if (exchange.getStocks().size() >= 5) {
            exchange.setLiveInMarket(true);
        }
        stockExchangeRepository.save(exchange);
    }

    @Transactional
    public void removeStockFromExchange(String exchangeName, Stock stock) {
        StockExchange exchange = stockExchangeRepository.findByName(exchangeName);
        exchange.getStocks().remove(stock);
        if (exchange.getStocks().size() < 5) {
            exchange.setLiveInMarket(false);
        }
        stockExchangeRepository.save(exchange);
    }

    @Transactional
    public StockExchange saveStockExchange(StockExchange exchange) {
        return stockExchangeRepository.save(exchange);
    }
}
