package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia() endpoint execution initiated");
        
        // Load the XML application context configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Fetch the configured country bean from the IoC container
        Country country = context.getBean("country", Country.class);
        
        LOGGER.info("END - getCountryIndia() endpoint execution completed");
        return country;
    }
}
