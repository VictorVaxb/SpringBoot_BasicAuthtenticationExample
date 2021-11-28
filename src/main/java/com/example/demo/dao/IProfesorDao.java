package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long> {
	
}
