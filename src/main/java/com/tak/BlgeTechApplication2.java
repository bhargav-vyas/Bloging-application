package com.tak;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories(basePackages = "com.example.blog.model")
@SpringBootApplication
@ComponentScan("com.example.blog.model")
@EntityScan("com.example.blog.model")
@Repository

public class BlgeTechApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(BlgeTechApplication2.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    
	    config.setAllowCredentials(true);
	    
	    // Instead of '*' for allowedOrigins, use a specific domain or pattern.
	    config.setAllowedOrigins(Arrays.asList("http://localhost:5173", "http://localhost:5173"));
	    
	    // Alternatively, you can use allowedOriginPatterns for more flexibility
	    // config.setAllowedOriginPatterns(Arrays.asList("http://*.example.com"));
	    
	    config.setAllowedHeaders(Collections.singletonList("*"));
	    config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
	    
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
}
