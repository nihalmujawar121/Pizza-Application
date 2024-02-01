package com.niit.bej.apigateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PizzaRouteConfig {
    @Bean
    @LoadBalanced
    public RouteLocator locatePizzaMicroserviceRoute(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(routePredicate -> routePredicate
                        .path("/api/v2/pizza/**")
                        .uri("http://localhost:8082")).build();
    }
}
