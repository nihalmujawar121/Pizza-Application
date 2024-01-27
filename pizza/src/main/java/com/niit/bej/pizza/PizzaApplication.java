package com.niit.bej.pizza;

import com.niit.bej.pizza.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class PizzaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaApplication.class, args);
    }
    @Bean
    public FilterRegistrationBean filterBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/v2/pizza/addPizza","/api/v2/pizza/deleteOrder/**");
        return filterRegistrationBean;
    }

}
