package com.example.demo.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hoadon;
import com.example.demo.entity.Mathang;
import com.example.demo.entity.MathangHoadon;





@Controller
@RequestMapping(path = "/xemthongke")
public class HoadonController {
	private RestTemplate rest = new RestTemplate();
	
	
	@GetMapping
	public String show(Model model) {
		List<Hoadon> list = Arrays.asList(rest.getForObject("http://localhost:8080/hoadon/recent", Hoadon[].class));
		
		List<MathangHoadon> listMHHD = Arrays.asList(rest.getForObject("http://localhost:8080/mathanghoadon/recent", MathangHoadon[].class));
//		List<MathangHoadon> mathangHoadons = new ArrayList<>();
		
		int tongtien= 0;
		
		for(Hoadon hoadon : list) {
			for(MathangHoadon mathangHoadon : listMHHD) {		
				if(mathangHoadon.getHoadon().getId()==hoadon.getId()){
					
					tongtien+=mathangHoadon.getMathang().getGiatien() * mathangHoadon.getSoluong();
				}
				
			}
		}
		
		model.addAttribute("tongtien",tongtien);
		model.addAttribute("list",list);
		return "hoadon";
	}
	
	@GetMapping("/detail/{id}")
	public String showEditForm(@PathVariable("id")int id,Model model) {
		List<MathangHoadon> list = Arrays.asList(rest.getForObject("http://localhost:8080/mathanghoadon/recent", MathangHoadon[].class));
		List<MathangHoadon> mathangHoadons = new ArrayList<>();
		
		int tongtien= 0;
		for(MathangHoadon mathangHoadon : list) {
			if(mathangHoadon.getHoadon().getId()==id){
				mathangHoadons.add(mathangHoadon);
				tongtien+=mathangHoadon.getMathang().getGiatien() * mathangHoadon.getSoluong();
			}	
		}
		model.addAttribute("mathangHoadons",mathangHoadons);
		model.addAttribute("tongtien",tongtien);
		return "detailHoadon" ; 
	}
	
	@GetMapping("/search")
	public String searchEmployee(Model model,@RequestParam("ten")String ten) {
		List<Mathang> mathangs= Arrays.asList(rest.getForObject("http://localhost:8080/mathang/recent",Mathang[].class));
		List<Mathang> list = new ArrayList<>();
		for(Mathang mathang : mathangs) {
			if(mathang.getTen().toLowerCase().contains(ten)){
				list.add(mathang);
			}
			if(mathang.getLoaiMH().toLowerCase().contains(ten)){
				list.add(mathang);
			}
			
		}
		model.addAttribute("list",mathangs); 
		return "mathang" ;
	}
}
