package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication(scanBasePackages = { "com.*" })
//Below annotation is really important
@EnableJpaRepositories("com.cognizant.orm.learn.repository")
public class OrmLearnApplication {

	private static CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);

		LOGGER.info("Inside main");

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);

		 testGetAllCountries();

		try {
			getAllCountriesTest();
		} catch (CountryNotFoundException e) {
		}
		//

		testAddCountry();

//Testing Updation
		testUpdateCountry();
		
		//Testing Delete Country
		testDeleteCountry();
		
		
		//Test Search by Typing
		testSearchByTyping();
		
		//Test Search Starting with an alphabet
		testSearchStartingwithAlphabet();

	}

	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}

	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start");

		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

	}

	public static void testAddCountry() {
		Country c = new Country();
		c.setCode("AC");
		c.setName("ACountry");
		// Adding
		countryService.addCountry(c);

		try {
			countryService.findCountryByCode("AC");
		} catch (CountryNotFoundException e) {
		}
	}

	public static void testUpdateCountry() {
		countryService.updateCountry("AC", "BcCountry");
	}
	
	public static void testDeleteCountry() {
		countryService.deleteCountry("AC");
	}
	
	public static void testSearchByTyping() {
		List<Country> searchByTyping = countryService.searchByTyping("in");
		LOGGER.debug("searchByTyping",searchByTyping);
	}
	public static void testSearchStartingwithAlphabet() {
		List<Country> nameStartingWith = countryService.nameStartingWith("i");
		LOGGER.debug("Countries Whose name Start",nameStartingWith);
	}

}
