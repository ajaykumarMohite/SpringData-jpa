package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm.learn.repository.CountryRepository;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {

		List<Country> findAll = countryRepository.findAll();

		return findAll;
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		java.util.Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}
		Country country = result.get();

		return country;
	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) {
		final Optional<Country> result = countryRepository.findById(code);
		Country country = result.get();
		country.setName(name);
		// countryRepository.save(country); //I believe that there is no need to use
		// save() as it will be taken care automatically
	}

	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}

	@Transactional
	public List<Country> searchByTyping(String name) {
		List<Country> contains = countryRepository.findBynameContainingOrderByName(name);
		return contains;

	}

	@Transactional
	public List<Country> nameStartingWith(String name) {
		List<Country> findBynameStartingWith = countryRepository.findBynameStartingWithOrderByNameAsc(name);
		return findBynameStartingWith;
	}

}
