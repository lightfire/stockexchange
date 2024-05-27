package com.kadirergun.stockexchange.model;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * DTO for {@link Stock}
 */
@Value
public class StockDto implements Serializable {
    Long id;
    String name;
    String description;
    BigDecimal currentPrice;
    Timestamp lastUpdate;
    List<StockExchange> exchanges;
}