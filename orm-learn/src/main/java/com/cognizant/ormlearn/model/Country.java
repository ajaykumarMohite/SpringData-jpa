package com.cognizant.ormlearn.model;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "country")
public class Country {
	@Id
	@Column(name = "co_code")
	private String code;
	@Column(name = "co_name")
	private String name;
	
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}



}