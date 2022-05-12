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
public class Mathang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String ten;
	private int giatien;
	private Date ngaynhap;
	private String hansd;
	private String loaiMH;
	private int soluong;
	@ManyToOne
	private Quanli quanli;
}
