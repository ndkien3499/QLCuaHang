package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Thanhvien {
	private int id ;
	private String username;
	private String password;
	private String vaitro;
	private String ten;
	private Date date;
	private String email;
	private String sdt;
	private String diachi;
}
