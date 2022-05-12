package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Hoadon {
	private int id ;
	private Date ngayxuat;
	
	@ManyToOne
	private NVBanhang nvBanhang;
	@ManyToOne
	private Khachhang khachhang;
}
