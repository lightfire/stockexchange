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

    /**
     * Retrieves a stock exchange by its name.
     *
     * @param name the name of the stock exchange
     * @return the stock exchange with the given name
     */
    @Transactional
    public StockExchange getStockExchangeByName(String name) {
        return stockExchangeRepository.findByName(name);
    }

    /**
     * Adds a stock to a stock exchange and updates the liveInMarket status.
     * If the number of stocks in the exchange is 5 or more, the exchange is set to liveInMarket.
     *
     * @param exchangeName the name of the stock exchange
     * @param stock the stock to be added
     */
    @Transactional
    public void addStockToExchange(String exchangeName, Stock stock) {
        StockExchange exchange = stockExchangeRepository.findByName(exchangeName);
        exchange.getStocks().add(stock);
        if (exchange.getStocks().size() >= 5) {
            exchange.setLiveInMarket(true);
        }
        stockExchangeRepository.save(exchange);
    }

    /**
     * Removes a stock from a stock exchange and updates the liveInMarket status.
     * If the number of stocks in the exchange is less than 5, the exchange is set to not liveInMarket.
     *
     * @param exchangeName the name of the stock exchange
     * @param stock the stock to be removed
     */
    @Transactional
    public void removeStockFromExchange(String exchangeName, Stock stock) {
        StockExchange exchange = stockExchangeRepository.findByName(exchangeName);
        exchange.getStocks().remove(stock);
        if (exchange.getStocks().size() < 5) {
            exchange.setLiveInMarket(false);
        }
        stockExchangeRepository.save(exchange);
    }

    /**
     * Saves a stock exchange to the repository.
     *
     * @param exchange the stock exchange to be saved
     * @return the saved stock exchange
     */
    @Transactional
    public StockExchange saveStockExchange(StockExchange exchange) {
        return stockExchangeRepository.save(exchange);
    }
}
