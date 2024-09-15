package com.wipro.online.gym.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@CrossOrigin(origins = "*")
@ComponentScan
public class OnlineGymManagementSystemApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OnlineGymManagementSystemApplication.class, args);
	}
	  @Bean
	    public WebMvcConfigurer corsConfigurer() {

	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry
	                        .addMapping("/**")
	                        .allowedMethods(CorsConfiguration.ALL)
	                        .allowedHeaders(CorsConfiguration.ALL)
	                        .allowedOriginPatterns(CorsConfiguration.ALL);
	            }
	        };
	    }
}
