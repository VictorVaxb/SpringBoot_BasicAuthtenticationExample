package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {

	@Autowired
	IProfesorService profeServ;
	
	@GetMapping(value = "/find_all_public") //en SecurityConfig se setea a publico con permitAll()
	public ResponseEntity<?> findAllProfesor(){
		List<Profesor> lstProfe = profeServ.findAllProfesors();
		
		if(lstProfe != null && lstProfe.size() > 0) {
			return new ResponseEntity<>(lstProfe, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/find_all_user") //en SecurityConfig se setea a publico con 
	public ResponseEntity<?> findAllProfesorUser(){
		List<Profesor> lstProfe = profeServ.findAllProfesors();
		
		if(lstProfe != null && lstProfe.size() > 0) {
			return new ResponseEntity<>(lstProfe, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/find_all_admin") //en SecurityConfig se setea permiso solo admin con
	public ResponseEntity<?> findAllProfesorAdmin(){
		List<Profesor> lstProfe = profeServ.findAllProfesors();
		
		if(lstProfe != null && lstProfe.size() > 0) {
			return new ResponseEntity<>(lstProfe, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
