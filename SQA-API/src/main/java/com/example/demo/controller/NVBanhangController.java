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

import com.example.demo.entity.NVBanhang;
import com.example.demo.repository.NVBanhangRepository;



@RestController
@RequestMapping(path = "/nvbanhang", produces = "application/json")
@CrossOrigin(origins = "*")
public class NVBanhangController {
	private NVBanhangRepository nvBanhangRepository ; 
	@Autowired
	public NVBanhangController(NVBanhangRepository nvBanhangRepository) {
		this.nvBanhangRepository = nvBanhangRepository ; 
	}
	
	@GetMapping("/recent")
	public Iterable<NVBanhang> getAll(){
		return nvBanhangRepository.findAll();
	}
	
	@PutMapping("/update/{id}")
	public NVBanhang updateCompany(@PathVariable("id")String id,@RequestBody NVBanhang nvBanhang) {
		 return  nvBanhangRepository.save(nvBanhang); 
	}
	@GetMapping("/{id}")
	public NVBanhang getCompanyById(@PathVariable("id") Integer id) {
		Optional<NVBanhang> nvBanhang = nvBanhangRepository.findById(id);
		if (nvBanhang.isPresent()) {
			return nvBanhang.get();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable("id")Integer id) {
		nvBanhangRepository.deleteById(id);
	}
//	@PostMapping("/add")
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public NVBanhang postAccount(@RequestBody NVBanhang nvBanhang) {
		return nvBanhangRepository.save(nvBanhang);
	}
}
