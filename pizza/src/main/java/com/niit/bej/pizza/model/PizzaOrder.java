package com.niit.bej.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrder {
    private int pizzaId;
    private String varietyOfPizza;
    private int priceOfPizza;
    private String sizeOfPizza;
}
