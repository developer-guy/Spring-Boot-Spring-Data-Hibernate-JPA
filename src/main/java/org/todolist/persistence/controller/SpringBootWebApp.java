package org.todolist.persistence.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.todolist.persistence.domain.User;

/**
 * Created by bapaydin on 16.10.2016.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.todolist.persistence")
@EnableJpaRepositories(basePackages = "org.todolist.persistence.repository")
@SpringBootApplication
public class SpringBootWebApp extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApp.class,args);
    }
}
