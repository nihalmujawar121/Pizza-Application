package com.niit.bej.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrder {
    @MongoId
    private int pizzaId;
    private String varietyOfPizza;
    private int priceOfPizza;
    private String sizeOfPizza;
}
