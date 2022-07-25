package com.cg.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringGatewayConfiguration {

	@Bean
	public RouteLocator gatewaysRoutes(RouteLocatorBuilder builder) {
	      return builder.routes()
	                .route(r -> r.path("/inventory/**")
	                        .uri("lb://inventory-service/"))
	                .route(r -> r.path("/search/**")
	                        .uri("lb://search-service/"))
	                .route(r->r.path("/playlist/**")
	                		.uri("lb://playlist-service/"))
	                .build();
	}
}
