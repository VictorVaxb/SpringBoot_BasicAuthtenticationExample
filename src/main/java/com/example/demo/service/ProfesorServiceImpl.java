package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProfesorDao;
import com.example.demo.entity.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	IProfesorDao profeDao;
	
	@Override
	public List<Profesor> findAllProfesors() {
		return (List<Profesor>) profeDao.findAll();
	}
	
	
	
}
