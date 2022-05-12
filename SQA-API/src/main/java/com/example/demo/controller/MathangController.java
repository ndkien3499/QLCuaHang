package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Mathang;
import com.example.demo.repository.MathangRepository;


@RestController
@RequestMapping(path = "/mathang", produces = "application/json")
@CrossOrigin(origins = "*")
public class MathangController {
	private MathangRepository mathangRepository ; 
	@Autowired
	public MathangController(MathangRepository mathangRepository) {
		this.mathangRepository = mathangRepository ; 
	}
	
	@GetMapping("/recent")
	public Iterable<Mathang> getAll(){
		return mathangRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public Mathang updateCompany(@PathVariable("id")String id,@RequestBody Mathang mathang) {
		 return  mathangRepository.save(mathang); 
	}
	@GetMapping("/{id}")
	public Mathang getCompanyById(@PathVariable("id") Integer id) {
		Optional<Mathang> mathang = mathangRepository.findById(id);
		if (mathang.isPresent()) {
			return mathang.get();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable("id")Integer id) {
		mathangRepository.deleteById(id);
	}
//	@PostMapping("/add")
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mathang postAccount(@RequestBody Mathang mathang) {
		return mathangRepository.save(mathang);
	}
}
