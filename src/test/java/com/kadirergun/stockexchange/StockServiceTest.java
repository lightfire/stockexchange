package com.kadirergun.stockexchange;


import com.kadirergun.stockexchange.exception.ResourceNotFoundException;
import com.kadirergun.stockexchange.model.Stock;
import com.kadirergun.stockexchange.repository.StockRepository;
import com.kadirergun.stockexchange.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveStock() {
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock savedStock = stockService.saveStock(stock);

        assertNotNull(savedStock);
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void testDeleteStock() {
        Long stockId = 1L;
        doNothing().when(stockRepository).deleteById(stockId);

        stockService.deleteStock(stockId);

        verify(stockRepository, times(1)).deleteById(stockId);
    }

    @Test
    public void testUpdateStockPrice() {
        Long stockId = 1L;
        BigDecimal newPrice = BigDecimal.valueOf(100.00);
        Stock stock = new Stock();
        stock.setId(stockId);
        stock.setCurrentPrice(BigDecimal.valueOf(50.00));
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock updatedStock = stockService.updateStockPrice(stockId, newPrice);

        assertNotNull(updatedStock);
        assertEquals(newPrice, updatedStock.getCurrentPrice());
        verify(stockRepository, times(1)).findById(stockId);
        verify(stockRepository, times(1)).save(stock);
    }

    @Test
    public void testUpdateStockPrice_StockNotFound() {
        Long stockId = 1L;
        BigDecimal newPrice = BigDecimal.valueOf(100.00);

        when(stockRepository.findById(stockId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            stockService.updateStockPrice(stockId, newPrice);
        });

        String expectedMessage = "Stock not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(stockRepository, times(1)).findById(stockId);
    }
}
