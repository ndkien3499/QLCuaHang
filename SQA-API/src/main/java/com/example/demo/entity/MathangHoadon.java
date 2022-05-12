package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class MathangHoadon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int soluong;
	
	@ManyToOne
	@JoinColumn
	private Hoadon hoadon;
	@ManyToOne 
	@JoinColumn
	private Mathang mathang;
}
