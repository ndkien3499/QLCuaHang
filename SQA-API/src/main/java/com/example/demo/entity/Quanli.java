package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Quanli implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToOne
	private Thanhvien thanhvien;
}
