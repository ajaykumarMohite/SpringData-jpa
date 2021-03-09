package com.cognizant.orm.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	//Reference Links for Below Methods
	 //https://docs.spring.io/spring-data/jpa/docs/2.2.0.RELEASE/reference/html/#jpa.query-methods.query-creation
	//https://docs.spring.io/spring-data/jpa/docs/2.2.0.RELEASE/reference/html/#repositories.query-methods
	//https://www.baeldung.com/spring-data-sorting
	List<Country> findBynameContainingOrderByName(String name);
	
	List<Country> findBynameStartingWithOrderByNameAsc(String name);
	
}

