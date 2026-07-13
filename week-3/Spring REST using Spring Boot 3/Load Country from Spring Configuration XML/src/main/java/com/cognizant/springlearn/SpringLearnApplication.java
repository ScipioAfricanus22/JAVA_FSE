package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inside main method: Attempting to start SpringLearnApplication...");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("SpringLearnApplication started successfully!");
        
        displayDate();
        displayCountry();
    }

    public static void displayDate() {
        LOGGER.info("START - displayDate method initialization");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date parsedDate = format.parse("31/12/2018");
            System.out.println("Parsed Date Result: " + parsedDate);
        } catch (ParseException e) {
            LOGGER.error("Failed to parse static date payload", e);
        }
        LOGGER.info("END - displayDate execution finished");
    }

    public static void displayCountry() {
        LOGGER.info("START - displayCountry method initialization");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.info("END - displayCountry execution finished");
    }
}
