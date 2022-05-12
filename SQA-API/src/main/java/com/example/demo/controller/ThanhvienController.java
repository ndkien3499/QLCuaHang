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

import com.example.demo.entity.Thanhvien;
import com.example.demo.repository.ThanhvienRepository;

@RestController
@RequestMapping(path = "/thanhvien")
@CrossOrigin(origins = "*")
public class ThanhvienController {
	private ThanhvienRepository thanhvienRepository ; 
	@Autowired
	public ThanhvienController(ThanhvienRepository thanhvienRepository) {
		this.thanhvienRepository = thanhvienRepository ; 
	}
	
	@GetMapping("/recent")
	public Iterable<Thanhvien> getAll(){
		return thanhvienRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public Thanhvien updateCompany(@PathVariable("id")String id,@RequestBody Thanhvien thanhvien) {
		 return  thanhvienRepository.save(thanhvien); 
	}
	@GetMapping("/{id}")
	public Thanhvien getCompanyById(@PathVariable("id") Integer id) {
		Optional<Thanhvien> thanhvien = thanhvienRepository.findById(id);
		if (thanhvien.isPresent()) {
			return thanhvien.get();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable("id")Integer id) {
		thanhvienRepository.deleteById(id);
	}
//	@PostMapping("/new")
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Thanhvien postAccount(@RequestBody Thanhvien thanhvien) {
		return thanhvienRepository.save(thanhvien);
	}
}
