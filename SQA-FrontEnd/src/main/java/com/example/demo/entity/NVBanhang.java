package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.ManyToOne;
import lombok.Data;
@Data
public class NVBanhang {
	private int id;
	private String ten;
	private Date date ;
	private String email;
	private String sdt ;
	@ManyToOne
	private Quanli quanli;
}
