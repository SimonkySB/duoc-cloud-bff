package com.duoc.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
	private WebClient.Builder webClientBuilder;


    private static final String BASE_URL = "http://ec2-52-23-200-199.compute-1.amazonaws.com:8081/api/patients";

    @GetMapping
    public Mono<ResponseEntity<String>> findAll() {
        return webClientBuilder.build()
                .get()
                .uri(BASE_URL)
                .retrieve()
                .toEntity(String.class);
    }

    
    @GetMapping("/{id}")
    public Mono<ResponseEntity<String>> getById(@PathVariable Long id) {
        return webClientBuilder.build()
                .get()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .toEntity(String.class);
    }

    
    @PostMapping
    public Mono<ResponseEntity<String>> add(@RequestBody String model) {
        return webClientBuilder.build()
                .post()
                .uri(BASE_URL)
                .bodyValue(model)
                .retrieve()
                .toEntity(String.class);
    }

    
    @PutMapping("/{id}")
    public Mono<ResponseEntity<String>> update(@PathVariable Long id, @RequestBody String model) {
        return webClientBuilder.build()
                .put()
                .uri(BASE_URL + "/" + id)
                .bodyValue(model)
                .retrieve()
                .toEntity(String.class);
    }

    
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return webClientBuilder.build()
                .delete()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .toBodilessEntity();
    }


    // Vital Sign For Patient
    @GetMapping("/{id}/vital-signs")
    public Mono<ResponseEntity<String>> getVitalSigns(@PathVariable Long id) {
        return webClientBuilder.build()
                .get()
                .uri(BASE_URL + "/" + id + "/vital-signs")
                .retrieve()
                .toEntity(String.class);
    }

    @PostMapping("/{id}/vital-signs")
    public Mono<ResponseEntity<String>> addVitalSign(@PathVariable Long id, @RequestBody String model) {
        return webClientBuilder.build()
                .post()
                .uri(BASE_URL + "/" + id + "/vital-signs")
                .bodyValue(model)
                .retrieve()
                .toEntity(String.class);
    }
}