package com.example.election;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class ElectionApplication {

	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
		registration.addUrlMappings("/console/*");
		return registration;
	}

	public static void main(String[] args) {
		SpringApplication.run(ElectionApplication.class, args);
	}
}
