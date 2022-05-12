package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Thanhvien;

@Controller
@RequestMapping("/")
public class LoginController {
	@GetMapping()
	public String login() {
		return "login";
	}
	private RestTemplate rest = new RestTemplate(); 
	
	
	@PostMapping("/home")
    public String checkLogin(Model model,HttpSession ss,@RequestParam(name = "username")String username , @RequestParam(name ="password")String password ) {  
		List<Thanhvien> accounts =  Arrays.asList(rest.getForObject("http://localhost:8080/thanhvien/recent",Thanhvien[].class));
		for(Thanhvien account : accounts) {
			if(account.getPassword().equals(password) && account.getUsername().equals(username) &&account.getVaitro().equals("quản lí")) {
				return "home";
			}
			
		}	
		return "login" ; 
	}
}
