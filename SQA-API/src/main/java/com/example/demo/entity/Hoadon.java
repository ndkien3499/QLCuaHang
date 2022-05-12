package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Hoadon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private Date ngayxuat;
	
	@ManyToOne
	private NVBanhang nvBanhang;
	@ManyToOne
	private Khachhang khachhang;
}
