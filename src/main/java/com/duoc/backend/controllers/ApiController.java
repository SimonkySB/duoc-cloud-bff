package com.duoc.backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    

    @GetMapping("/api")
	public String mensaje() {
		System.out.println("Backend llamado");
		return "{\"mensaje\": \"Integración OK al backend\"}";
	}
}
