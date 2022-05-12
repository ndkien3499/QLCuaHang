package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="thanhvien")
public class Thanhvien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
