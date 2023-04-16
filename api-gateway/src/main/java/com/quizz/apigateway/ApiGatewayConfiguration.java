package com.quizz.apigateway;

import com.quizz.apigateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Autowired
    AuthenticationFilter authenticationFilter;
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path("/auth/**").uri("lb://user-service"))
                .route(p -> p.path("/user/**").filters(f-> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config()))).uri("lb://user-service"))
                .route(p -> p.path("/questions/**").filters(f-> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config()))).uri("lb://question-definition-service"))
                .route(p -> p.path("/quiz/**").filters(f-> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config()))).uri("lb://quiz-service"))
                .build();
    }
}
