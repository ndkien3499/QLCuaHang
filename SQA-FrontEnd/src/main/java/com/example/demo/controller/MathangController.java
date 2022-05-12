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

import com.example.demo.entity.Mathang;
import com.example.demo.entity.Quanli;
import com.example.demo.entity.Thanhvien;




@Controller
@RequestMapping(path = "/mathang")
public class MathangController {
	private RestTemplate rest = new RestTemplate();
	
	
	@GetMapping
	public String show(Model model) {
		List<Mathang> list = Arrays.asList(rest.getForObject("http://localhost:8080/mathang/recent", Mathang[].class));
		model.addAttribute("list",list);
		return "mathang";
	}
	@GetMapping("/delete/{id}")
	public String deleteAccount(@PathVariable int id,Model model) {
		rest.delete("http://localhost:8080/mathang/delete/"+id);
		return "redirect:/mathang" ; 
	}
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id")int id,Model model) {
		Mathang mathang = rest.getForObject("http://localhost:8080/mathang/"+id, Mathang.class);
			model.addAttribute("mathang",mathang);
		return "editMathang" ; 
	}
	@PostMapping("/edit/{id}")
	public String updateAccount(@PathVariable("id")int id,@RequestParam("ten")String ten,@RequestParam("giatien")int giatien,
			@RequestParam("ngaynhap")String ngaynhap,@RequestParam("hansd")String hansd,@RequestParam("loaiMH")String loaiMH,
			@RequestParam("soluong")int soluong) throws ParseException {
		Mathang mathang = rest.getForObject("http://localhost:8080/mathang/"+id, Mathang.class);
		mathang.setTen(ten);
		mathang.setGiatien(giatien);
		Date date2 = Date.valueOf(ngaynhap);
		mathang.setNgaynhap(date2);
		mathang.setHansd(hansd);
		mathang.setLoaiMH(loaiMH);
		mathang.setSoluong(soluong);
		mathang.setQuanli(mathang.getQuanli());
		rest.put("http://localhost:8080/mathang/update/"+id,mathang);
		return "redirect:/mathang";
	}
	@PostMapping("/new")
	public  String addAccount(Model model,@RequestParam("ten")String ten,@RequestParam("giatien")int giatien,
			@RequestParam("ngaynhap")String ngaynhap,@RequestParam("hansd")String hansd,@RequestParam("loaiMH")String loaiMH,
			@RequestParam("soluong")int soluong) throws ParseException{
		
		List<Mathang> list = Arrays.asList(rest.getForObject("http://localhost:8080/mathang/recent", Mathang[].class));
		
		Thanhvien thanhvien = rest.getForObject("http://localhost:8080/thanhvien/1", Thanhvien.class);
		Quanli quanli = new Quanli(); 
		quanli.setThanhvien(thanhvien);
		Mathang mathang = new Mathang();
		mathang.setId(list.size()+1);
		mathang.setTen(ten);
		mathang.setGiatien(giatien);
		Date date2 = Date.valueOf(ngaynhap);
		mathang.setNgaynhap(date2);
		mathang.setHansd(hansd);
		mathang.setLoaiMH(loaiMH);
		mathang.setSoluong(soluong);
		mathang.setQuanli(quanli);
		rest.postForObject("http://localhost:8080/mathang", mathang, Mathang.class);
		return "redirect:/mathang";
	}
	@GetMapping("/search")
	public String searchEmployee(Model model,@RequestParam("ten")String ten) {
		List<Mathang> mathangs= Arrays.asList(rest.getForObject("http://localhost:8080/mathang/recent",Mathang[].class));
		List<Mathang> list = new ArrayList<>();
		for(Mathang mathang : mathangs) {
			if(mathang.getTen().toLowerCase().contains(ten.toLowerCase()) || mathang.getTen().toUpperCase().contains(ten.toUpperCase())){
				list.add(mathang);
			}
			
			
		}
		model.addAttribute("list",list); 
		return "mathang" ;
	}
}
