package com.cognizant.ormllearn3.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sk_id")
	private int id;
	@Column(name="k_name")
	private String name;
	@ManyToMany(mappedBy = "skillList",fetch = FetchType.EAGER)
	private Set<Employee> employeeList; 

	
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", employeeList=" + employeeList + "]";
	}

}
