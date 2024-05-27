package com.kadirergun.stockexchange.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal currentPrice;
    private Timestamp lastUpdate;

    @ManyToMany(mappedBy = "stocks")
    @JsonBackReference
    private List<StockExchange> exchanges;

}
