package com.niit.bej.apigateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAuthRouteConfig {

    @Bean
    @LoadBalanced
    public RouteLocator locateUserAuthMicroserviceRoute(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(routePredicate -> routePredicate
                        .path("/home/**")
                        .uri("http://localhost:8081"))
                .build();
    }
}
