package com.cg.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomFilter {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public GlobalFilter globalFilter() {
		return (exchange, chain) -> {

			if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {

				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}

			String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

			String[] parts = authHeader.split(" ");

			if (parts.length != 2 || !"Bearer".equals(parts[0])) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}

//			RestTemplate restTemplate = new RestTemplate();

			String forObject = null;

			try {
				forObject = restTemplate.getForObject("http://localhost:8888/token?v=" + parts[1], String.class);
			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}
			if (!forObject.equals("valid")) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}

			return chain.filter(exchange);
		};
	}
}
