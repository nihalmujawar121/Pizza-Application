package com.niit.bej.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PizzaRouteConfig {
    public RouteLocator locatePizzaMicroserviceRoute(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder
                .routes()
                .route(routePredicate -> routePredicate
                        .path("/api/v2/pizza/**")
                        .uri("lb://PizzaApplication")).build();
    }
}
