package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.SampleRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class SampleContoller {
	@Autowired
	private SampleRepository userRepository;
	
	@GetMapping("/sample")
	public List<User> getUser(){
		System.out.println("たどり着いた");
		return userRepository.findAll();
	}
}
