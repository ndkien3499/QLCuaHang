package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Mathang {
	private int id;
	private String ten;
	private int giatien;
	private Date ngaynhap;
	private String hansd;
	private String loaiMH;
	private int soluong;
	@ManyToOne
	private Quanli quanli;
}
