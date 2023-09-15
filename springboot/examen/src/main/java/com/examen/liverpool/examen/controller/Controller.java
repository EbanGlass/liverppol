package com.examen.liverpool.examen.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/controller")
public class Controller {

	private static final String nuevoFolio = "{\"nuevoFolio\":\"%s\"}";

	@GetMapping(value = "/processFolio", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String>  processFolio(@RequestParam String folio) {
		
		
		if(folio == null || folio.isBlank()) {
			return new ResponseEntity<>("el parametro folio no puede ser vacio o null", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String suffix = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMddHHmmss"));
		
		System.out.println("suffix: " + suffix);
		System.out.println(folio.concat(suffix));
		
		return ResponseEntity.ok(String.format(nuevoFolio, folio.concat(suffix)));
		
	}
	
}
