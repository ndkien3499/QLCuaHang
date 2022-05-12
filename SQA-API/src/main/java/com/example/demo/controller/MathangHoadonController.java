package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MathangHoadon;
import com.example.demo.repository.MathangHoadonRepository;


@RestController
@RequestMapping(path = "/mathanghoadon", produces = "application/json")
@CrossOrigin(origins = "*")
public class MathangHoadonController {
	private MathangHoadonRepository mathangHoadonRepository ; 
	@Autowired
	public MathangHoadonController(MathangHoadonRepository mathangHoadonRepository) {
		this.mathangHoadonRepository = mathangHoadonRepository ; 
	}
	
	@GetMapping("/recent")
	public Iterable<MathangHoadon> getAll(){
		return mathangHoadonRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public MathangHoadon updateCompany(@PathVariable("id")String id,@RequestBody MathangHoadon mathangHoadon) {
		 return  mathangHoadonRepository.save(mathangHoadon); 
	}
	@GetMapping("/{id}")
	public MathangHoadon getCompanyById(@PathVariable("id") Integer id) {
		Optional<MathangHoadon> mathangHoadon = mathangHoadonRepository.findById(id);
		if (mathangHoadon.isPresent()) {
			return mathangHoadon.get();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable("id")Integer id) {
		mathangHoadonRepository.deleteById(id);
	}
	@PostMapping("/add")
	public MathangHoadon postAccount(@RequestBody MathangHoadon mathangHoadon) {
		return mathangHoadonRepository.save(mathangHoadon);
	}
}
