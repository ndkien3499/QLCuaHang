package com.example.demo.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class MathangHoadon {
	private int id ;
	private int soluong;
	
	@ManyToOne
	@JoinColumn
	private Hoadon hoadon;
	@ManyToOne 
	@JoinColumn
	private Mathang mathang;
}
