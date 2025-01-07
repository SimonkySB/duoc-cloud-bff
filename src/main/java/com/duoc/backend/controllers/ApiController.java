package com.duoc.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ApiController {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@GetMapping("/api/products")
	public Mono<ResponseEntity<String>> proxyToProducts() {
		System.out.println("Proxying request to product service...");

		// URL del servicio de productos
		String productsServiceUrl = "http://localhost:8081/api/products";

		// Pasa la solicitud y devuelve la respuesta
		return webClientBuilder.build()
				.get()
				.uri(productsServiceUrl)
				.retrieve()
				.toEntity(String.class);
	}
}
