package com.niit.bej.pizza.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaOrder {
    private int pizzaId;
    private String varietyOfPizza;
    private int priceOfPizza;
    private String sizeOfPizza;
}
