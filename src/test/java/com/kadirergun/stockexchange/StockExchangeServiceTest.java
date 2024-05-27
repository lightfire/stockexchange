package com.kadirergun.stockexchange;

import com.kadirergun.stockexchange.model.Stock;
import com.kadirergun.stockexchange.model.StockExchange;
import com.kadirergun.stockexchange.repository.StockExchangeRepository;
import com.kadirergun.stockexchange.service.StockExchangeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StockExchangeServiceTest {

    @Mock
    private StockExchangeRepository stockExchangeRepository;

    @InjectMocks
    private StockExchangeService stockExchangeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStockExchangeByName() {
        String exchangeName = "NYSE";
        StockExchange exchange = new StockExchange();
        exchange.setName(exchangeName);
        when(stockExchangeRepository.findByName(exchangeName)).thenReturn(exchange);

        StockExchange retrievedExchange = stockExchangeService.getStockExchangeByName(exchangeName);

        assertNotNull(retrievedExchange);
        assertEquals(exchangeName, retrievedExchange.getName());
        verify(stockExchangeRepository, times(1)).findByName(exchangeName);
    }

    @Test
    public void testAddStockToExchange() {
        String exchangeName = "NYSE";
        Stock stock = new Stock();
        StockExchange exchange = new StockExchange();
        exchange.setName(exchangeName);
        List<Stock> stocks = new ArrayList<>();
        exchange.setStocks(stocks);
        when(stockExchangeRepository.findByName(exchangeName)).thenReturn(exchange);
        when(stockExchangeRepository.save(exchange)).thenReturn(exchange);

        stockExchangeService.addStockToExchange(exchangeName, stock);

        assertTrue(exchange.getStocks().contains(stock));
        assertFalse(exchange.isLiveInMarket());
        verify(stockExchangeRepository, times(1)).findByName(exchangeName);
        verify(stockExchangeRepository, times(1)).save(exchange);
    }

    @Test
    public void testAddStockToExchange_LiveInMarket() {
        String exchangeName = "NYSE";
        Stock stock = new Stock();
        StockExchange exchange = new StockExchange();
        exchange.setName(exchangeName);
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stocks.add(new Stock());
        }
        exchange.setStocks(stocks);
        when(stockExchangeRepository.findByName(exchangeName)).thenReturn(exchange);
        when(stockExchangeRepository.save(exchange)).thenReturn(exchange);

        stockExchangeService.addStockToExchange(exchangeName, stock);

        assertTrue(exchange.getStocks().contains(stock));
        assertTrue(exchange.isLiveInMarket());
        verify(stockExchangeRepository, times(1)).findByName(exchangeName);
        verify(stockExchangeRepository, times(1)).save(exchange);
    }

    @Test
    public void testRemoveStockFromExchange() {
        String exchangeName = "NYSE";
        Stock stock = new Stock();
        StockExchange exchange = new StockExchange();
        exchange.setName(exchangeName);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock);
        exchange.setStocks(stocks);
        when(stockExchangeRepository.findByName(exchangeName)).thenReturn(exchange);
        when(stockExchangeRepository.save(exchange)).thenReturn(exchange);

        stockExchangeService.removeStockFromExchange(exchangeName, stock);

        assertFalse(exchange.getStocks().contains(stock));
        assertFalse(exchange.isLiveInMarket());
        verify(stockExchangeRepository, times(1)).findByName(exchangeName);
        verify(stockExchangeRepository, times(1)).save(exchange);
    }

    @Test
    public void testRemoveStockFromExchange_NotLiveInMarket() {
        String exchangeName = "NYSE";
        Stock stock = new Stock();
        StockExchange exchange = new StockExchange();
        exchange.setName(exchangeName);
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            stocks.add(new Stock());
        }
        exchange.setStocks(stocks);
        when(stockExchangeRepository.findByName(exchangeName)).thenReturn(exchange);
        when(stockExchangeRepository.save(exchange)).thenReturn(exchange);

        stockExchangeService.removeStockFromExchange(exchangeName, stock);

        assertFalse(exchange.getStocks().contains(stock));
        assertFalse(exchange.isLiveInMarket());
        verify(stockExchangeRepository, times(1)).findByName(exchangeName);
        verify(stockExchangeRepository, times(1)).save(exchange);
    }

    @Test
    public void testSaveStockExchange() {
        StockExchange exchange = new StockExchange();
        when(stockExchangeRepository.save(exchange)).thenReturn(exchange);

        StockExchange savedExchange = stockExchangeService.saveStockExchange(exchange);

        assertNotNull(savedExchange);
        verify(stockExchangeRepository, times(1)).save(exchange);
    }
}

