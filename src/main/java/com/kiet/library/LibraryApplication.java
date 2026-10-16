package com.kiet.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(LibraryApplication.class);

    private final ApplicationContext context;

    public LibraryApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void run(String... args) {

        logger.info("Library Book Management System Started");

        logger.info("Loading Book Catalogue...");

        String[] beans = context.getBeanDefinitionNames();

        logger.info("Total number of beans: {}", beans.length);

        logger.info("Book Management REST API is Ready");
    }
}