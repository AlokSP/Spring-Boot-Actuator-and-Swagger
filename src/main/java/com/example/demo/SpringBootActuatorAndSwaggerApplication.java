package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot REST API Documentation", description = "Spring Boot REST API Documentation", version = "v1.0", contact = @Contact(name = "Alok Kumar", email = "xyz@gmail.com", url = "xyz.com"), license = @License(name = "Apache 2.0", url = "xyz.com/license")), externalDocs = @ExternalDocumentation(description = "Spring Boot Student Management Documentation", url = "https://www.xyz.com/student_management.html"))
public class SpringBootActuatorAndSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootActuatorAndSwaggerApplication.class, args);
    }

}
