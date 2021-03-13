package com.cognizant.ormllearn3.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "em_id")
	private int id;
	@Column(name = "em_name")
	private String name;
	@Column(name = "em_salary")
	private java.math.BigDecimal salary;
	@Column(name = "em_permanent")
	private boolean permanent;
	@Column(name = "em_date_of_birth")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "em_dp_id")
	private Department department;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_skill", joinColumns = @JoinColumn(name = "es_em_id"), inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
	private Set<Skill> skillList;

	public boolean isPermanent() {
		return permanent;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent + ", date="
				+ date + ", department=" + department + "]";
	}

}
