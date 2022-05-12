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

import com.example.demo.entity.Hoadon;
import com.example.demo.repository.HoadonRepository;


@RestController
@RequestMapping(path = "/hoadon", produces = "application/json")
@CrossOrigin(origins = "*")
public class HoadonController {
	private HoadonRepository hoadonRepository ; 
	@Autowired
	public HoadonController(HoadonRepository hoadonRepository) {
		this.hoadonRepository = hoadonRepository ; 
	}
	
	@GetMapping("/recent")
	public Iterable<Hoadon> getAll(){
		return hoadonRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public Hoadon updateCompany(@PathVariable("id")String id,@RequestBody Hoadon hoadon) {
		 return  hoadonRepository.save(hoadon); 
	}
	@GetMapping("/{id}")
	public Hoadon getCompanyById(@PathVariable("id") Integer id) {
		Optional<Hoadon> hoadon = hoadonRepository.findById(id);
		if (hoadon.isPresent()) {
			return hoadon.get();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable("id")Integer id) {
		hoadonRepository.deleteById(id);
	}
	@PostMapping("/add")
	public Hoadon postAccount(@RequestBody Hoadon hoadon) {
		return hoadonRepository.save(hoadon);
	}
}
