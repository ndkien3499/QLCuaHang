package com.example.demo.controller;

import java.sql.Date;
//import java.util.Date;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.NVBanhang;
import com.example.demo.entity.Quanli;
import com.example.demo.entity.Thanhvien;




@Controller
@RequestMapping(path = "/nvbanhang")
public class NVBanhangController {
	private RestTemplate rest = new RestTemplate();
	
	
	@GetMapping
	public String show(Model model) {
		List<NVBanhang> list = Arrays.asList(rest.getForObject("http://localhost:8080/nvbanhang/recent", NVBanhang[].class));
		model.addAttribute("list",list);
		return "nvbanhang";
	}
	@GetMapping("/delete/{id}")
	public String deleteAccount(@PathVariable int id,Model model) {
		rest.delete("http://localhost:8080/nvbanhang/delete/"+id);
		return "redirect:/nvbanhang" ; 
	}
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id")int id,Model model) {
		NVBanhang nvbanhang = rest.getForObject("http://localhost:8080/nvbanhang/"+id, NVBanhang.class);
			model.addAttribute("nvbanhang",nvbanhang);
		return "editNVBanhang" ; 
	}
	@PostMapping("/edit/{id}")
	public String updateAccount(@PathVariable("id")int id,@RequestParam("ten")String ten,@RequestParam("date")String date,
			@RequestParam("email")String email,@RequestParam("sdt")String sdt) {
		NVBanhang account = rest.getForObject("http://localhost:8080/nvbanhang/"+id, NVBanhang.class);
		account.setTen(ten);
		Date date2 = Date.valueOf(date);
		account.setDate(date2);
		account.setEmail(email);
		account.setSdt(sdt);
		account.setQuanli(account.getQuanli());
		
		rest.put("http://localhost:8080/nvbanhang/update/"+id,account);
		return "redirect:/nvbanhang";
	}
	@PostMapping("/new")
	public  String addAccount(Model model,@RequestParam("ten")String ten,@RequestParam("date")String date,
			@RequestParam("email")String email,@RequestParam("sdt")String sdt) throws ParseException{
		
		Thanhvien thanhvien = rest.getForObject("http://localhost:8080/thanhvien/1", Thanhvien.class);
		Quanli quanli = new Quanli(); 
		quanli.setThanhvien(thanhvien);
		NVBanhang account = new NVBanhang();
		List<NVBanhang> list = Arrays.asList(rest.getForObject("http://localhost:8080/nvbanhang/recent", NVBanhang[].class));
		account.setId(list.size()+1);
		account.setTen(ten);
		Date date2 = Date.valueOf(date);
		account.setDate(date2);
		account.setEmail(email);
		account.setSdt(sdt);
		account.setQuanli(quanli);
		rest.postForObject("http://localhost:8080/nvbanhang", account, NVBanhang.class);
		return "redirect:/nvbanhang";
	}
	@GetMapping("/search")
	public String searchEmployee(Model model,@RequestParam("ten")String ten) {
		List<NVBanhang> employees= Arrays.asList(rest.getForObject("http://localhost:8080/nvbanhang/recent",NVBanhang[].class));
		List<NVBanhang> list = new ArrayList<>();
		for(NVBanhang employee : employees) {
			if(employee.getTen().toLowerCase().contains(ten.toLowerCase()) || employee.getTen().toUpperCase().contains(ten.toUpperCase())){
				list.add(employee);
			}
			
		}
		model.addAttribute("list",list); 
		return "nvbanhang" ;
	}
}
