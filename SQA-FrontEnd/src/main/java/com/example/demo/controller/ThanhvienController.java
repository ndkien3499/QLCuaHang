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

import com.example.demo.entity.Thanhvien;



@Controller
@RequestMapping(path = "/thanhvien")
public class ThanhvienController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String show(Model model) {
		List<Thanhvien> list = Arrays.asList(rest.getForObject("http://localhost:8080/thanhvien/recent", Thanhvien[].class));
		model.addAttribute("list",list);
		return "thanhvien";
	}
	@GetMapping("/delete/{id}")
	public String deleteAccount(@PathVariable int id,Model model) {
		rest.delete("http://localhost:8080/thanhvien/delete/"+id);
		return "redirect:/thanhvien" ; 
	}
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id")int id,Model model) {
		Thanhvien thanhvien = rest.getForObject("http://localhost:8080/thanhvien/"+id, Thanhvien.class);
			model.addAttribute("thanhvien",thanhvien);
		return "editThanhvien" ; 
	}
	@PostMapping("/edit/{id}")
	public String updateAccount(@PathVariable("id")int id,@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("vaitro")String vaitro,@RequestParam("ten")String ten,@RequestParam("date")String date,
			@RequestParam("email")String email,@RequestParam("sdt")String sdt,@RequestParam("diachi")String diachi) throws ParseException {
		Thanhvien account = rest.getForObject("http://localhost:8080/thanhvien/"+id, Thanhvien.class);
		account.setUsername(username);
		account.setPassword(password);
		account.setVaitro(vaitro);
		account.setTen(ten);
		Date date2 = Date.valueOf(date);
		account.setDate(date2);
		account.setEmail(email);
		account.setSdt(sdt);
		account.setDiachi(diachi);
		rest.put("http://localhost:8080/thanhvien/update/"+id,account);
		return "redirect:/thanhvien";
	}
	@PostMapping("/new")
	public  String addAccount(Model model,@RequestParam("id")Integer id,@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("vaitro")String vaitro,@RequestParam("ten")String ten,@RequestParam("date")String date,
			@RequestParam("email")String email,@RequestParam("sdt")String sdt,@RequestParam("diachi")String diachi) throws ParseException{
		Thanhvien account = new Thanhvien();
		account.setId(id);
		account.setUsername(username);
		account.setPassword(password);
		account.setVaitro(vaitro);
		account.setTen(ten);
		Date date2 = Date.valueOf(date);
		account.setDate(date2);
		account.setEmail(email);
		account.setSdt(sdt);
		account.setDiachi(diachi);
		rest.postForObject("http://localhost:8080/thanhvien", account, Thanhvien.class);
		return "redirect:/thanhvien";
	}
	@GetMapping("/search")
	public String searchEmployee(Model model,@RequestParam("id")String ten) {
		List<Thanhvien> employees= Arrays.asList(rest.getForObject("http://localhost:8080/thanhvien/recent",Thanhvien[].class));
		List<Thanhvien> list = new ArrayList<>();
		for(Thanhvien employee : employees) {
			if(employee.getTen().toLowerCase().contains(ten)){
				list.add(employee);
			}
			if(employee.getEmail().toLowerCase().contains(ten)){
				list.add(employee);
			}
			if(employee.getDiachi().toLowerCase().contains(ten)){
				list.add(employee);
			}
			if(employee.getSdt().toLowerCase().contains(ten)){
				list.add(employee);
			}
		}
		model.addAttribute("list",list); 
		return "thanhvien" ;
	}
}
